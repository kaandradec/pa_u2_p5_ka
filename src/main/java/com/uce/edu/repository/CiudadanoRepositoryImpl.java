package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CiudadanoRepositoryImpl implements ICiudadanoRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insertar(Ciudadano ciudadano) {
        this.entityManager.persist(ciudadano);
    }

    @Override
    public Ciudadano seleccionar(Integer id) {
        return this.entityManager.find(Ciudadano.class, id);
    }

    @Override
    public void actualizar(Ciudadano ciudadano) {
        this.entityManager.merge(ciudadano);
    }

    @Override
    public void eliminar(Integer id) {
        Ciudadano ciudadano = this.seleccionar(id);
        this.entityManager.remove(ciudadano);
    }

    @Override
    public Empleado seleccionarPorCedula(String cedula) {
        TypedQuery<Empleado> myQuery = this.entityManager.createQuery("SELECT e FROM Empleado e WHERE e.ciudadano.cedula = :cedula", Empleado.class);
        myQuery.setParameter("cedula", cedula);
        return myQuery.getSingleResult();
    }

    @Override
    public Ciudadano seleccionarPorCedulaCiu(String cedula) {
        // NATIVE Query
        Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM ciudadano c WHERE c.ciud_cedula = :cedula", Ciudadano.class);
        myQuery.setParameter("cedula", cedula);
        return (Ciudadano) myQuery.getSingleResult();
    }

    @Override
    public Ciudadano seleccionarPorApellido(String apellido) {
        // CRITERIA API QUERY
        // 0. Crear una instancia de la interfaz CriteriaBuilder a partir de un EntityManager
        CriteriaBuilder myCriteriaBuilder = this.entityManager.getCriteriaBuilder();

        // 1. Determinar el tipo de retorno que va a tener mi consulta
        CriteriaQuery<Ciudadano> myCriteriaQuery = myCriteriaBuilder.createQuery(Ciudadano.class);

        // 2. Contruir el SQL
        //  2.1 Determinar el FROM (Mediante interfaz Root)
        //  NOTA: No necesariamete el from es igual al tipo de retorno.
        //  Ejemplo -> SELECT c.empleado FROM Ciudadano c WHERE c.empleado.nombre = :dato
        Root<Ciudadano> myFrom = myCriteriaQuery.from(Ciudadano.class); // SQL -> ...FROM Ciudadano...

        //  2.2 Construir las condiciones (WHERE) del SQL
        //  En Criteria API Query las condiciones de las conoce como "Predicate"
        //  c.apellido = :dato
        Predicate condicionApellido = myCriteriaBuilder.equal(myFrom.get("apellido"), apellido);
        //  .equal(A que atributo se aplica la condicion (apellido), A que lo vamos a comparar)

        // 3. Construimos el SQL final
        myCriteriaQuery.select(myFrom).where(condicionApellido);

        // 4. Ejecutar la consulta con un TypedQuery
        TypedQuery<Ciudadano> myTypedQuery = this.entityManager.createQuery(myCriteriaQuery);

        return myTypedQuery.getSingleResult();
    }

    @Override
    public Ciudadano seleccionarPorCriteria(String nombre, String apellido, String cedula) {
        // CRITERIA API QUERY DINAMICO
        // 0. Crear una instancia de la interfaz CriteriaBuilder a partir de un EntityManager
        CriteriaBuilder myCriteriaBuilder = this.entityManager.getCriteriaBuilder();

        // 1. Determinar el tipo de retorno que va a tener mi consulta
        CriteriaQuery<Ciudadano> myCriteriaQuery = myCriteriaBuilder.createQuery(Ciudadano.class);

        // 2. Contruir el SQL
        //  2.1 Determinar el FROM (Mediante interfaz Root)
        Root<Ciudadano> myFrom = myCriteriaQuery.from(Ciudadano.class);

        //  2.2 Construir las condiciones (WHERE)
        //  En Criteria API Query las condiciones de las conoce como "Predicate"
        Predicate condicionGenerica = null;
        // Obtener 2 digitos
        if (cedula.startsWith("17")) {
            condicionGenerica = myCriteriaBuilder.equal(myFrom.get("nombre"), nombre);
        } else if (cedula.startsWith("05")) {
            condicionGenerica = myCriteriaBuilder.equal(myFrom.get("apellido"), apellido);
        } else {
            condicionGenerica = myCriteriaBuilder.equal(myFrom.get("cedula"), cedula);
        }

        // 3. Construir SQL final
        myCriteriaQuery.select(myFrom).where(condicionGenerica);

        // 4. Ejecutar la consulta con un TypedQuery
        TypedQuery<Ciudadano> myTypedQuery = this.entityManager.createQuery(myCriteriaQuery);

        return myTypedQuery.getSingleResult();
    }

    @Override
    public Ciudadano seleccionarPorCriteriaAndOr(String nombre, String apellido, String cedula) {
        // CRITERIA API QUERY DINAMICO
        // 0. Crear una instancia de la interfaz CriteriaBuilder a partir de un EntityManager
        CriteriaBuilder myCriteriaBuilder = this.entityManager.getCriteriaBuilder();

        // 1. Determinar el tipo de retorno que va a tener mi consulta
        CriteriaQuery<Ciudadano> myCriteriaQuery = myCriteriaBuilder.createQuery(Ciudadano.class);

        // 2. Contruir el SQL
        //  2.1 Determinar el FROM (Mediante interfaz Root)
        Root<Ciudadano> myFrom = myCriteriaQuery.from(Ciudadano.class);

        //  2.2 Construir las condiciones (WHERE)

        Predicate condicionTotal = null;
        // c.nombre = nombre
        Predicate condicionNombre = myCriteriaBuilder.equal(myFrom.get("nombre"), nombre);
        // c.apellido = apellido
        Predicate condicionApellido = myCriteriaBuilder.equal(myFrom.get("apellido"), apellido);
        // Obtener 2 digitos
        if (cedula.startsWith("17")) {
            // c.nombre = nombre OR c.apellido = apellido
            condicionTotal = myCriteriaBuilder.or(condicionNombre, condicionApellido);
        } else if (cedula.startsWith("05")) {
            // c.nombre = nombre AND c.apellido = apellido
            condicionTotal = myCriteriaBuilder.and(condicionNombre, condicionApellido);
        }

        // 3. Construir SQL final
        myCriteriaQuery.select(myFrom).where(condicionTotal);

        // 4. Ejecutar la consulta con un TypedQuery
        TypedQuery<Ciudadano> myTypedQuery = this.entityManager.createQuery(myCriteriaQuery);

        return myTypedQuery.getSingleResult();
    }
}
