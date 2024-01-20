package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Habitacion;
import com.uce.edu.repository.modelo.Hotel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class HotelRepositoryImpl implements IHotelRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Hotel seleccionar(Integer id) {
        return this.entityManager.find(Hotel.class, id);
    }

    @Override
    public void insertar(Hotel hotel) {
        this.entityManager.persist(hotel);
    }

    @Override
    public void actualizar(Hotel hotel) {
        this.entityManager.merge(hotel);
    }

    @Override
    public void eliminar(Integer id) {
        Hotel hotel = this.seleccionar(id);
        this.entityManager.remove(hotel);
    }

    @Override
    public List<Hotel> listar() {
        TypedQuery<Hotel> query1 = entityManager.createQuery("SELECT h FROM Hotel h", Hotel.class);
        return query1.getResultList();
    }

    @Override
    public Hotel seleccionarPorNombre(String nombre) {
        TypedQuery<Hotel> query2 = entityManager.createQuery("SELECT h FROM Hotel h WHERE h.nombre = :nombre", Hotel.class);
        query2.setParameter("nombre", nombre);
        return query2.getSingleResult();
    }

    @Override
    public List<Habitacion> seleccionarHabitacionesPorNombreHotel(String nombre) {
        Hotel hotel = this.seleccionarPorNombre(nombre);
        Integer hotelId = hotel.getId();

        TypedQuery<Habitacion> query3 = entityManager.createQuery("SELECT h FROM Habitacion h WHERE h.hotel.id = :hotelId", Habitacion.class);
        query3.setParameter("hotelId", hotelId);

        return query3.getResultList();
    }

    @Override
    public List<Hotel> seleccionarPorNumeroHabitaciones(Integer numeroHabitaciones) {
        TypedQuery<Hotel> query5 = entityManager.createQuery("SELECT h FROM Hotel h WHERE SIZE(h.habitaciones) > :n", Hotel.class);
        query5.setParameter("n", numeroHabitaciones);

        return query5.getResultList();
    }
}
