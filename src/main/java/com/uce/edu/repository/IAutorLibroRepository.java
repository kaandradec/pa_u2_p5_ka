package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Autor;
import com.uce.edu.repository.modelo.Autor2;
import com.uce.edu.repository.modelo.AutorLibro;

public interface IAutorLibroRepository {
    AutorLibro seleccionarPorCodigo(String codigo);
    public void insertar(AutorLibro autorLibro);
    public void actualizar(AutorLibro autorLibro);

}
