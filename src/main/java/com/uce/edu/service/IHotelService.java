package com.uce.edu.service;

import com.uce.edu.repository.modelo.Hotel;

public interface IHotelService {
    public Hotel buscar(Integer id);
    public void guardar(Hotel hotel);
    public void actualizar(Hotel hotel);
    public void eliminar(Integer id);
}
