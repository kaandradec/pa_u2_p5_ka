package com.uce.edu.service;

import com.uce.edu.repository.modelo.Habitacion;

public interface IHabitacionService {
    public Habitacion buscar(Integer id);
    public void guardar(Habitacion habitacion);
    public void actualizar(Habitacion habitacion);
    public void eliminar(Integer id);
}
