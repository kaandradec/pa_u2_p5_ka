package com.uce.edu.service;

import com.uce.edu.repository.modelo.AutorLibro;

import java.time.LocalDateTime;

public interface IAutorLibroService {
     void guardar(AutorLibro autorLibro);
     AutorLibro buscarPorCodigo(String codigo);
     void actualizarRegistro(String codigo, LocalDateTime fechaRegistro);

}
