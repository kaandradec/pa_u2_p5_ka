package com.uce.edu.service;

import com.uce.edu.repository.modelo.Autor;
import com.uce.edu.repository.modelo.Autor2;

public interface IAutorService {
    public Autor buscar(Integer id);
    public void registrar(Autor autor);
    public void registrar(Autor2 autor2);
    public void actualizar(Autor autor);
    public void eliminar(Integer id);
}
