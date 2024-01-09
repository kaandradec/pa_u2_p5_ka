package com.uce.edu.service;

import com.uce.edu.repository.ILibroRepository;
import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.repository.modelo.Libro2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
