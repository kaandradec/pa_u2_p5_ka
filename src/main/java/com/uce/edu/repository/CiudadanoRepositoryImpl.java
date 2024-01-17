package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CiudadanoRepositoryImpl implements ICiudadanoRepository{
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
        myQuery.setParameter("cedula",cedula);
        return myQuery.getSingleResult();
    }

    @Override
    public Ciudadano seleccionarPorCedulaCiu(String cedula) {
        // NATIVE Query
        Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM ciudadano c WHERE c.ciud_cedula = :cedula", Ciudadano.class);
        myQuery.setParameter("cedula",cedula);
        return (Ciudadano) myQuery.getSingleResult();
    }
}
