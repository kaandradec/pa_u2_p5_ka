package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.repository.modelo.Libro2;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
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
    public void insertar(Libro2 libro2) {
        this.entityManager.persist(libro2);
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

    @Override
    public Libro seleccionarPorNombre(String nombre) {

        // SQL: SELECT * FROM libro l WHERE l.libr_titulo = ?
        // JPQL: SELECT l FROM Libro l WHERE l.titulo = :variable  // l: es la entidad libro, lo mismo que le alias en este caso

        Query myQuery = this.entityManager.createQuery("SELECT l FROM Libro l WHERE l.titulo = :variable");
        myQuery.setParameter("variable", nombre); // JPQL: SELECT l FROM Libro l WHERE l.titulo = :nombre
        return (Libro) myQuery.getSingleResult(); // en el caso de obtener mas de un resultado tendremos un error
    }
}
