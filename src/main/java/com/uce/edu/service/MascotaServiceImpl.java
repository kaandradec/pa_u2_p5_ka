package com.uce.edu.service;

import com.uce.edu.repository.IMascotaRepository;
import com.uce.edu.repository.modelo.Mascota;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MascotaServiceImpl implements IMascotaService{
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
}
