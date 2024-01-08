package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Autor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class AutorRepositoryImpl implements IAutorRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Autor seleccionar(Integer id) {
        return this.entityManager.find(Autor.class, id);
    }

    @Override
    public void insertar(Autor autor) {
        this.entityManager.persist(autor);
    }

    @Override
    public void actualizar(Autor autor) {
        this.entityManager.merge(autor);
    }

    @Override
    public void eliminar(Integer id) {
        Autor autor = this.seleccionar(id);
        this.entityManager.remove(autor);
    }
}
