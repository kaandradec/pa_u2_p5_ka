package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Empleado;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class EmpleadoRepositoryImpl implements IEmpleadoRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void insertar(Empleado empleado) {
        this.entityManager.persist(empleado);
    }

    @Override
    public Empleado seleccionar(Integer id) {
        return this.entityManager.find(Empleado.class, id);
    }
}
