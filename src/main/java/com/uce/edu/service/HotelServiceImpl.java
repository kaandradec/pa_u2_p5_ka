package com.uce.edu.service;

import com.uce.edu.repository.IHotelRepository;
import com.uce.edu.repository.modelo.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelServiceImpl implements IHotelService{
    @Autowired
    private IHotelRepository iHotelRepository;
    @Override
    public void guardar(Hotel hotel) {
        this.iHotelRepository.insertar(hotel);
    }

    @Override
    public Hotel buscar(Integer id) {
        return this.iHotelRepository.seleccionar(id);
    }
    @Override
    public void actualizar(Hotel ciudadano) {
        this.iHotelRepository.actualizar(ciudadano);
    }

    @Override
    public void eliminar(Integer id) {
        this.iHotelRepository.eliminar(id);
    }
}
