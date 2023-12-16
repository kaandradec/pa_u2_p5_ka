package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Estudiante;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class EstudianteRepositoryImpl implements IEstudianteRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Estudiante seleccionar(Integer id) {
        return this.entityManager.find(Estudiante.class, id);
    }

    @Override
    public void insertar(Estudiante estudiante) {
        this.entityManager.persist(estudiante);
    }

    @Override
    public void actualizar(Estudiante estudiante) {
        this.entityManager.merge(estudiante);
    }

    @Override
    public void eliminar(Integer id) {
        Estudiante estudiante = this.seleccionar(id);
        this.entityManager.remove(estudiante);
    }
}
