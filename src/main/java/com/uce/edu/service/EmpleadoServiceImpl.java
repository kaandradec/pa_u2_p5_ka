package com.uce.edu.service;

import com.uce.edu.repository.IEmpleadoRepository;
import com.uce.edu.repository.modelo.Alumno;
import com.uce.edu.repository.modelo.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService{
    @Autowired
    private IEmpleadoRepository iEmpleadoRepository;
    @Override
    public void registrar(Empleado empleado) {
        this.iEmpleadoRepository.insertar(empleado);
    }

    @Override
    public Empleado buscar(Integer id) {
        return this.iEmpleadoRepository.seleccionar(id);
    }
    @Override
    public void actualizar(Empleado empleado) {
        this.iEmpleadoRepository.actualizar(empleado);
    }

    @Override
    public void eliminar(Integer id) {
        this.iEmpleadoRepository.eliminar(id);
    }
}
