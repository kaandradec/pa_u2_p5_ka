package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.repository.modelo.Libro2;

public interface ILibroRepository {
    public Libro seleccionar(Integer id);

    public void insertar(Libro libro);
    public void insertar(Libro2 libro);

    public void actualizar(Libro libro2);

    public void eliminar(Integer id);

    public Libro seleccionarPorNombre(String nombre);
}
