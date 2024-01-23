package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Mascota;

import java.util.List;

public interface IMascotaRepository {
    List<Mascota> listarMascotas();

    List<Mascota> listarMascotasPorTipo(String tipo);

    void actualizarColorMascota(String nombre, String nuevoColor);

    void eliminarMascotaPorId(Long id);

    Long contarMascotas();

    //Criteria API Query
    Mascota seleccionarPorCriteriaTelefonoPlacaORNombre(String telefonoPlaca, String nombre);

    List<Mascota> listarPorCriteriaTipoAndColor(String tipo, String color);

    List<Mascota> listarPorCriteriaEdadORPeso(Integer edad, Double peso);

    List<Mascota> listarPorCriteriaTipoEdad(String tipo, Integer edad);

    Integer contarPorCriteriaBetweenPeso(Double pesoMinimo, Double pesoMaximo);


}
