package com.uce.edu.service;

import com.uce.edu.repository.IMascotaRepository;
import com.uce.edu.repository.modelo.Mascota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascotaServiceImpl implements IMascotaService {
    @Autowired
    private IMascotaRepository iMascotaRepository;

    @Override
    public List<Mascota> listarMascotas() {
        return this.iMascotaRepository.listarMascotas();
    }

    @Override
    public List<Mascota> listarMascotasPorTipo(String tipo) {
        return this.iMascotaRepository.listarMascotasPorTipo(tipo);
    }

    @Override
    public void actualizarColorMascota(String nombre, String nuevoColor) {
        this.iMascotaRepository.actualizarColorMascota(nombre, nuevoColor);
    }

    @Override
    public void quitarMascotaPorId(Long id) {
        this.iMascotaRepository.eliminarMascotaPorId(id);
    }

    @Override
    public Long contarMascotas() {
        return this.iMascotaRepository.contarMascotas();
    }

    @Override
    public Mascota buscarPorCriteriaTelefonoPlacaORNombre(String telefonoPlaca, String nombre) {
        return this.iMascotaRepository.seleccionarPorCriteriaTelefonoPlacaORNombre(telefonoPlaca, nombre);
    }

    @Override
    public List<Mascota> listarPorCriteriaTipoAndColor(String tipo, String color) {
        return this.iMascotaRepository.listarPorCriteriaTipoAndColor(tipo, color);
    }

    @Override
    public List<Mascota> listarPorCriteriaEdadORPeso(Integer edad, Double peso) {
        return this.iMascotaRepository.listarPorCriteriaEdadORPeso(edad, peso);
    }

    @Override
    public List<Mascota> listarPorCriteriaTipoEdad(String tipo, Integer edad) {
        return this.iMascotaRepository.listarPorCriteriaTipoEdad(tipo, edad);
    }

    @Override
    public Integer contarPorCriteriaBetweenPeso(Double pesoMinimo, Double pesoMaximo) {
        return this.iMascotaRepository.contarPorCriteriaBetweenPeso(pesoMinimo, pesoMaximo);
    }
}
