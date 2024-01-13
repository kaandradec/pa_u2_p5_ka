package com.uce.edu.service;

import com.uce.edu.repository.ILibroRepository;
import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.repository.modelo.Libro2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LibroServiceImpl implements ILibroService {
    @Autowired
    private ILibroRepository iLibroRepository;

    @Override
    public void guardar(Libro libro) {
        this.iLibroRepository.insertar(libro);
    }

    @Override
    public Libro buscarPorNombre(String nombre) {
        return this.iLibroRepository.seleccionarPorNombre(nombre);
    }

    @Override
    public Libro buscarPorTitulo(String titulo) {
        return this.iLibroRepository.seleccionarPorTitulo(titulo);
    }

    @Override
    public Libro buscarPorTituloNamed(String titulo) {
        return this.iLibroRepository.seleccionarPorTituloNamed(titulo);
    }

    @Override
    public List<Libro> buscarPorFecha(LocalDateTime fecha) {
        return this.iLibroRepository.seleccionarPorFechaPublicacion(fecha);
    }

    @Override
    public List<Libro> buscarPorFechaPubli(LocalDateTime fecha) {
        return this.iLibroRepository.seleccionarPorFecha(fecha);
    }

    @Override
    public List<Libro> buscarPorFechaPubliNamed(LocalDateTime fecha) {
        return this.iLibroRepository.seleccionarPorFechaNamed(fecha);
    }

    @Override
    public void guardar(Libro2 libro2) {
        this.iLibroRepository.insertar(libro2);
    }

    @Override
    public Libro buscar(Integer id) {
        return this.iLibroRepository.seleccionar(id);
    }

    @Override
    public void actualizar(Libro libro) {
        this.iLibroRepository.actualizar(libro);
    }

    @Override
    public void eliminar(Integer id) {
        this.iLibroRepository.eliminar(id);
    }
}
