package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Autor;
import com.uce.edu.repository.modelo.Autor2;

public interface IAutorRepository {
    public Autor seleccionar(Integer id);

    public void insertar(Autor autor);
    public void insertar(Autor2 autor2);

    public void actualizar(Autor autor);

    public void eliminar(Integer id);
}
