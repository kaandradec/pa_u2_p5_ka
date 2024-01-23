package com.uce.edu.service;

import com.uce.edu.repository.modelo.Mascota;

import java.util.List;

public interface IMascotaService {
    public List<Mascota> listarMascotas();

    public List<Mascota> listarMascotasPorTipo(String tipo);

    public void actualizarColorMascota(String nombre, String nuevoColor);

    public void quitarMascotaPorId(Long id);

    public Long contarMascotas();

    //Criteria API Query
    Mascota buscarPorCriteriaTelefonoPlacaORNombre(String telefonoPlaca, String nombre);

    List<Mascota> listarPorCriteriaTipoAndColor(String tipo, String color);

    List<Mascota> listarPorCriteriaEdadORPeso(Integer edad, Double peso);

    List<Mascota> listarPorCriteriaTipoEdad(String tipo, Integer edad);

    Integer contarPorCriteriaBetweenPeso(Double pesoMinimo, Double pesoMaximo);
}
