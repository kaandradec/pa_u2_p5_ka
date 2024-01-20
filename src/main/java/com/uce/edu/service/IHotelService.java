package com.uce.edu.service;

import com.uce.edu.repository.modelo.Habitacion;
import com.uce.edu.repository.modelo.Hotel;

import java.util.List;

public interface IHotelService {
    public Hotel buscar(Integer id);
    public void guardar(Hotel hotel);
    public void actualizar(Hotel hotel);
    public void eliminar(Integer id);

    public List<Hotel> listar();
    public Hotel buscarPorNombre(String nombre);
    public List<Habitacion> buscarHabitacionesPorNombreHotel(String nombre);
    public List<Hotel> buscarPorNumeroHabitaciones(Integer numeroHabitaciones);
}
