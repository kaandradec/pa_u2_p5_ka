package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class LibroRepositoryImpl implements ILibroRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Libro seleccionar(Integer id) {
        return this.entityManager.find(Libro.class, id);
    }

    @Override
    public void insertar(Libro libro) {
        this.entityManager.persist(libro);
    }

    @Override
    public void actualizar(Libro libro) {
        this.entityManager.merge(libro);
    }

    @Override
    public void eliminar(Integer id) {
        Libro libro = this.seleccionar(id);
        this.entityManager.remove(libro);
    }
}
