package com.uce.edu.service;

import com.uce.edu.repository.modelo.Alumno;

public interface IAlumnoService {
    public Alumno buscar(Integer id);
    public void registrar(Alumno alumno);
    public void actualizar(Alumno alumno);
    public void eliminar(Integer id);
}
