package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.repository.modelo.Libro2;

import java.time.LocalDateTime;
import java.util.List;

public interface ILibroRepository {
    public Libro seleccionar(Integer id);

    public void insertar(Libro libro);
    public void insertar(Libro2 libro);

    public void actualizar(Libro libro2);

    public void eliminar(Integer id);

    public Libro seleccionarPorNombre(String nombre);
    public Libro seleccionarPorTitulo(String titulo);
    public Libro seleccionarPorTituloNamed(String titulo);

    public List<Libro> seleccionarPorFechaPublicacion(LocalDateTime fechaPublicacion);
    public List<Libro> seleccionarPorFecha(LocalDateTime fechaPublicacion);
    public List<Libro> seleccionarPorFechaNamed(LocalDateTime fechaPublicacion);

}
