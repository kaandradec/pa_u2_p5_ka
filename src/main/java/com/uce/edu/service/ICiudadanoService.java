package com.uce.edu.service;

import com.uce.edu.repository.modelo.Alumno;
import com.uce.edu.repository.modelo.Ciudadano;
import jakarta.persistence.criteria.CriteriaBuilder;

public interface ICiudadanoService {
    public void registrar(Ciudadano ciudadano);
    public Ciudadano buscar(Integer id);
}
