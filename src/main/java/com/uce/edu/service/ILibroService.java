package com.uce.edu.service;

import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.repository.modelo.Libro2;

import java.time.LocalDateTime;
import java.util.List;

public interface ILibroService {
    public Libro buscar(Integer id);
    public void guardar(Libro libro);
    public Libro buscarPorNombre(String nombre);
    public Libro buscarPorTitulo(String titulo);
    public Libro buscarPorTituloNamed(String titulo);

    public List<Libro> buscarPorFecha(LocalDateTime fecha);
    public List<Libro> buscarPorFechaPubli(LocalDateTime fecha);
    public List<Libro> buscarPorFechaPubliNamed(LocalDateTime fecha);

    public void guardar(Libro2 libro2);
    public void actualizar(Libro libro);
    public void eliminar(Integer id);

}
