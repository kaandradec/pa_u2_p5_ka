package com.uce.edu.service;

import com.uce.edu.repository.modelo.Libro;

public interface ILibroService {
    public Libro buscar(Integer id);
    public void guardar(Libro libro);
    public void actualizar(Libro libro);
    public void eliminar(Integer id);
}
