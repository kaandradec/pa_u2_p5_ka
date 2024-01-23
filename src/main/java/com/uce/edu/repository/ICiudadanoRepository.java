package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Ciudadano;
import com.uce.edu.repository.modelo.Empleado;

public interface ICiudadanoRepository {
    void insertar(Ciudadano ciudadano);

    Ciudadano seleccionar(Integer id);

    void actualizar(Ciudadano ciudadano);

    void eliminar(Integer id);

    Empleado seleccionarPorCedula(String cedula);

    Ciudadano seleccionarPorCedulaCiu(String cedula);

    Ciudadano seleccionarPorApellido(String apellido);

    // Funcionalidad: que cuando sea el ciudadano de Pichincha lo busque por nombre
    // cuando sea de Cotopaxi lo busque por apellido
    // cuando no sea de ni de Cotopaxi ni Pichincha lo busque por cedula
    Ciudadano seleccionarPorCriteria(String nombre, String apellido, String cedula);
    Ciudadano seleccionarPorCriteriaAndOr(String nombre, String apellido, String cedula);


}
