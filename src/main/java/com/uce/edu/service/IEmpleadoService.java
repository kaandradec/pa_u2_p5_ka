package com.uce.edu.service;

import com.uce.edu.repository.EmpleadoRepositoryImpl;
import com.uce.edu.repository.modelo.Empleado;

public interface IEmpleadoService {
    public void registrar(Empleado empleado);
    public Empleado buscar(Integer id);
}
