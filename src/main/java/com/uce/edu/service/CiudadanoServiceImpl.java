package com.uce.edu.service;

import com.uce.edu.repository.ICiudadanoRepository;
import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CiudadanoServiceImpl implements ICiudadanoService {
    @Autowired
    private ICiudadanoRepository iCiudadanoRepository;

    @Override
    public void registrar(Ciudadano ciudadano) {
        this.iCiudadanoRepository.insertar(ciudadano);
    }

    @Override
    public Ciudadano buscar(Integer id) {
        return this.iCiudadanoRepository.seleccionar(id);
    }

    @Override
    public void actualizar(Ciudadano ciudadano) {
        this.iCiudadanoRepository.actualizar(ciudadano);
    }

    @Override
    public void eliminar(Integer id) {
        this.iCiudadanoRepository.eliminar(id);
    }

    @Override
    public Empleado buscarPorCedula(String cedula) {
        return this.iCiudadanoRepository.seleccionarPorCedula(cedula);
    }

    @Override
    public Ciudadano buscarPorCedulaCiu(String cedula) {
        return this.iCiudadanoRepository.seleccionarPorCedulaCiu(cedula);
    }

    @Override
    public Ciudadano buscarPorApellido(String apellido) {
        return this.iCiudadanoRepository.seleccionarPorApellido(apellido);
    }

    @Override
    public Ciudadano buscarPorCriteria(String nombre, String apellido, String cedula) {
        return this.iCiudadanoRepository.seleccionarPorCriteria(nombre, apellido, cedula);
    }

    @Override
    public Ciudadano buscarPorCriteriaAndOr(String nombre, String apellido, String cedula) {
        return this.iCiudadanoRepository.seleccionarPorCriteriaAndOr(nombre, apellido, cedula);
    }
}
