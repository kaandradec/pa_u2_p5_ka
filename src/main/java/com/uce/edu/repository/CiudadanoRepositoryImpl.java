package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Ciudadano;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
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
}
