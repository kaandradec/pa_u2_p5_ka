package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Habitacion;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class HabitacionRepositoryImpl implements IHabitacionRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Habitacion seleccionar(Integer id) {
        return this.entityManager.find(Habitacion.class, id);
    }

    @Override
    public void insertar(Habitacion habitacion) {
        this.entityManager.persist(habitacion);
    }

    @Override
    public void actualizar(Habitacion habitacion) {
        this.entityManager.merge(habitacion);
    }

    @Override
    public void eliminar(Integer id) {
        Habitacion habitacion = this.seleccionar(id);
        this.entityManager.remove(habitacion);
    }

    @Override
    public List<Habitacion> seleccionarPorClase(String clase) {
        TypedQuery<Habitacion> query4 = entityManager.createQuery("SELECT h FROM Habitacion h WHERE h.clase = :clase", Habitacion.class);
        query4.setParameter("clase", clase);

        return query4.getResultList();
    }
}
