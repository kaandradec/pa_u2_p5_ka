package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Habitacion
        ;

public interface IHabitacionRepository {
    public Habitacion seleccionar(Integer id);

    public void insertar(Habitacion habitacion);

    public void actualizar(Habitacion habitacion);

    public void eliminar(Integer id);
}
