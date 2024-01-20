package com.uce.edu.service;

import com.uce.edu.repository.IHabitacionRepository;
import com.uce.edu.repository.modelo.Habitacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitacionServiceImpl implements IHabitacionService{
    @Autowired
    private IHabitacionRepository iHabitacionRepository;
    @Override
    public void guardar(Habitacion habitacion) {
        this.iHabitacionRepository.insertar(habitacion);
    }

    @Override
    public Habitacion buscar(Integer id) {
        return this.iHabitacionRepository.seleccionar(id);
    }
    @Override
    public void actualizar(Habitacion ciudadano) {
        this.iHabitacionRepository.actualizar(ciudadano);
    }

    @Override
    public void eliminar(Integer id) {
        this.iHabitacionRepository.eliminar(id);
    }

    @Override
    public List<Habitacion> buscarPorClase(String clase) {
        return this.iHabitacionRepository.seleccionarPorClase(clase);
    }
}
