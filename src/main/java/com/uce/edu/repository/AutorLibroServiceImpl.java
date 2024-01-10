package com.uce.edu.repository;

import com.uce.edu.repository.modelo.AutorLibro;
import com.uce.edu.service.IAutorLibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Service
public class AutorLibroServiceImpl implements IAutorLibroService {
    @Autowired
    private IAutorLibroRepository iAutorLibroRepository;
    @Override
    public void guardar(AutorLibro autorLibro) {
        this.iAutorLibroRepository.insertar(autorLibro);
    }

    @Override
    public AutorLibro buscarPorCodigo(String codigo) {
        return this.iAutorLibroRepository.seleccionarPorCodigo(codigo);
    }

    @Override
    public void actualizarRegistro(String codigo, LocalDateTime fechaRegistro) {
        AutorLibro autorLibro = this.buscarPorCodigo(codigo);
        autorLibro.setFecha(fechaRegistro);

        this.iAutorLibroRepository.actualizar(autorLibro);
    }
}
