package com.uce.edu.service;

import com.uce.edu.repository.modelo.Autor;

public interface IAutorService {
    public Autor buscar(Integer id);
    public void registrar(Autor autor);
    public void actualizar(Autor autor);
    public void eliminar(Integer id);
}
