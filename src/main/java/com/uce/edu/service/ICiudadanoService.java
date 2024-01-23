package com.uce.edu.service;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;

public interface ICiudadanoService {
    void registrar(Ciudadano ciudadano);

    Ciudadano buscar(Integer id);

    void actualizar(Ciudadano ciudadano);

    void eliminar(Integer id);

    Empleado buscarPorCedula(String cedula);

    Ciudadano buscarPorCedulaCiu(String cedula);

    Ciudadano buscarPorApellido(String apellido);

    Ciudadano buscarPorCriteria(String nombre, String apellido, String cedula);
    Ciudadano buscarPorCriteriaAndOr(String nombre, String apellido, String cedula);
}
