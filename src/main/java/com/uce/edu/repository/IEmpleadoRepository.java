package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Alumno;
import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;

public interface IEmpleadoRepository {
    public void insertar(Empleado empleado);
    public Empleado seleccionar(Integer id);
;
}
