package com.uce.edu.service;

import com.uce.edu.repository.ICiudadanoRepository;
import com.uce.edu.repository.modelo.Ciudadano;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CiudadanoServiceImpl implements ICiudadanoService{
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
}
