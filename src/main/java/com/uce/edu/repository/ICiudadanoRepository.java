package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Alumno;
import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Estudiante;

public interface ICiudadanoRepository {
    public void insertar(Ciudadano ciudadano);
    public Ciudadano seleccionar(Integer id);
}
