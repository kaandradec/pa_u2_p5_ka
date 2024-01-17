package com.uce.edu.service;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;

public interface ICiudadanoService {
    public void registrar(Ciudadano ciudadano);
    public Ciudadano buscar(Integer id);
    public void actualizar(Ciudadano ciudadano);
    public void eliminar(Integer id);
    Empleado buscarPorCedula(String cedula);
    Ciudadano buscarPorCedulaCiu(String cedula);
}
