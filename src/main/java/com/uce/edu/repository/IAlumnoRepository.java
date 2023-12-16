package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Alumno;
import com.uce.edu.repository.modelo.Estudiante;

public interface IAlumnoRepository {
    public Alumno seleccionar(Integer id);
    public void insertar(Alumno alumno);
    public void actualizar(Alumno alumno);
    public void eliminar(Integer id);
}
