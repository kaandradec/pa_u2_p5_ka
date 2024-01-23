package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Mascota;
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

import java.util.List;

@Repository
@Transactional
public class MascotaRepositoryImpl implements IMascotaRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Mascota> listarMascotas() {
        Query query = this.entityManager.createNativeQuery("SELECT * FROM mascota", Mascota.class);
        return query.getResultList();
    }

    @Override
    public List<Mascota> listarMascotasPorTipo(String tipo) {
        TypedQuery<Mascota> query = entityManager.createQuery("SELECT m FROM Mascota m WHERE m.tipo = :tipo", Mascota.class);
        query.setParameter("tipo", tipo);

        return query.getResultList();
    }

    @Override
    public void actualizarColorMascota(String nombre, String nuevoColor) {
        Query query = entityManager.createNativeQuery("UPDATE mascota SET color = :nuevoColor WHERE nombre = :nombre");
        query.setParameter("nombre", nombre);
        query.setParameter("nuevoColor", nuevoColor);
        query.executeUpdate();
    }

    @Override
    public void eliminarMascotaPorId(Long id) {
        Query query = entityManager.createNativeQuery("DELETE FROM mascota WHERE id_mascota = :id");
        query.setParameter("id", id);

        query.executeUpdate();
    }

    @Override
    public Long contarMascotas() {
        Query nativeQuery = entityManager.createNativeQuery("SELECT COUNT(*) FROM mascota");
        return (Long) nativeQuery.getSingleResult();
    }

    // Criteria API QUERY
    // Si se envia un telefonoPlaca vacio entonces se busca por nombre.
    @Override
    public Mascota seleccionarPorCriteriaTelefonoPlacaORNombre(String telefonoPlaca, String nombre) {
        // Busca mascota por telefonoPlaca, en el caso de no tenerlo busca por nombre
        CriteriaBuilder myCriteriaBuilder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Mascota> myCriteriaQuery = myCriteriaBuilder.createQuery(Mascota.class); // Tipo de retorno
        Root<Mascota> myFrom = myCriteriaQuery.from(Mascota.class); // FROM mascota

        Predicate condicion = null;
        if (telefonoPlaca.isBlank()) condicion = myCriteriaBuilder.equal(myFrom.get("nombre"), nombre);
        else condicion = myCriteriaBuilder.equal(myFrom.get("telefonoPlaca"), telefonoPlaca);

        myCriteriaQuery.select(myFrom).where(condicion);

        TypedQuery<Mascota> myTypedQuery = this.entityManager.createQuery(myCriteriaQuery);

        return myTypedQuery.getSingleResult();
    }

    @Override
    public List<Mascota> listarPorCriteriaTipoAndColor(String tipo, String color) {
        CriteriaBuilder myCriteriBuilder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Mascota> myCriteriQuery = myCriteriBuilder.createQuery(Mascota.class);
        Root<Mascota> myFrom = myCriteriQuery.from(Mascota.class);

        Predicate condicionTipo = myCriteriBuilder.equal(myFrom.get("tipo"), tipo);
        Predicate condicionColor = myCriteriBuilder.equal(myFrom.get("color"), color);
        Predicate condicion = myCriteriBuilder.and(condicionTipo, condicionColor);

        myCriteriQuery.select(myFrom).where(condicion);

        TypedQuery<Mascota> myTypedQuery = this.entityManager.createQuery(myCriteriQuery);

        return myTypedQuery.getResultList();
    }

    @Override
    public List<Mascota> listarPorCriteriaEdadORPeso(Integer edad, Double peso) {
        CriteriaBuilder myCriteriBuilder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Mascota> myCriteriQuery = myCriteriBuilder.createQuery(Mascota.class);
        Root<Mascota> myFrom = myCriteriQuery.from(Mascota.class);

        Predicate condicionEdad = myCriteriBuilder.equal(myFrom.get("edad"), edad);
        Predicate condicionPeso = myCriteriBuilder.equal(myFrom.get("peso"), peso);
        Predicate condicion = myCriteriBuilder.or(condicionEdad, condicionPeso);

        myCriteriQuery.select(myFrom).where(condicion);

        TypedQuery<Mascota> myTypedQuery = this.entityManager.createQuery(myCriteriQuery);

        return myTypedQuery.getResultList();
    }

    @Override
    public List<Mascota> listarPorCriteriaTipoEdad(String tipo, Integer edad) {
        CriteriaBuilder myCriteriBuilder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Mascota> myCriteriQuery = myCriteriBuilder.createQuery(Mascota.class);
        Root<Mascota> myFrom = myCriteriQuery.from(Mascota.class);


        Predicate condicion = null;
        if (tipo.equalsIgnoreCase("perro"))
            condicion = myCriteriBuilder.lessThanOrEqualTo(myFrom.get("edad"), edad);
        if (tipo.equalsIgnoreCase("gato"))
            condicion = myCriteriBuilder.greaterThanOrEqualTo(myFrom.get("edad"), edad);


        myCriteriQuery.select(myFrom).where(condicion);

        TypedQuery<Mascota> myTypedQuery = this.entityManager.createQuery(myCriteriQuery);

        return myTypedQuery.getResultList();
    }

    @Override
    public Integer contarPorCriteriaBetweenPeso(Double pesoMinimo, Double pesoMaximo) {
        CriteriaBuilder myCriteriBuilder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> myCriteriQuery = myCriteriBuilder.createQuery(Long.class);
        Root<Mascota> myFrom = myCriteriQuery.from(Mascota.class);

        Predicate condicion = myCriteriBuilder.between(myFrom.get("peso"), pesoMinimo, pesoMaximo);

        myCriteriQuery.select(myCriteriBuilder.count(myFrom)).where(condicion);

        TypedQuery<Long> myTypedQuery = this.entityManager.createQuery(myCriteriQuery);

        return myTypedQuery.getSingleResult().intValue();
    }


}
