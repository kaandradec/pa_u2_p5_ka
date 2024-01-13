package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Libro;
import com.uce.edu.repository.modelo.Libro2;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.List;

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
        //return (Libro) myQuery.getSingleResult(); // en el caso de obtener mas de un resultado tendremos un error
        return (Libro) myQuery.getResultList().get(0); // Forma 2 de hacerlo, donde no tendremos las excepciones de getSingleResult()
    }

    @Override
    public Libro seleccionarPorTitulo(String titulo) {
        //TYPED QUERY
        TypedQuery<Libro> myQuery = this.entityManager.createQuery("SELECT l FROM Libro l WHERE l.titulo = :titulo", Libro.class);
        myQuery.setParameter("titulo", titulo);

        return myQuery.getSingleResult();
    }

    @Override
    public Libro seleccionarPorTituloNamed(String titulo) {
        TypedQuery<Libro> myQuery = this.entityManager.createNamedQuery("Libro.queryBuscarPorTitulo", Libro.class);
        myQuery.setParameter("titulo", titulo);

        return myQuery.getResultList().get(0);
    }

    @Override
    public List<Libro> seleccionarPorFechaPublicacion(LocalDateTime fechaPublicacion) {
        // SQL: SELECT * from libro l WHERE l.libr_fecha_publicacion >= ?
        // JPQL: SELECT l from Libro l WHERE l.fechaPublicacion >= :fecha

        Query myQuery = this.entityManager.createQuery("SELECT l from Libro l WHERE l.fechaPublicacion >= :fecha");
        myQuery.setParameter("fecha", fechaPublicacion);

        return (List<Libro>) myQuery.getResultList();
    }

    @Override
    public List<Libro> seleccionarPorFecha(LocalDateTime fechaPublicacion) {
        // TYPED QUERY
        // Usamos Libro en lugar de List<Libro>
        TypedQuery<Libro> myQuery = this.entityManager.createQuery("SELECT l from Libro l WHERE l.fechaPublicacion >= :fecha", Libro.class);
        myQuery.setParameter("fecha", fechaPublicacion);

        return myQuery.getResultList();
    }

    @Override
    public List<Libro> seleccionarPorFechaNamed(LocalDateTime fechaPublicacion) {
        TypedQuery<Libro> myQuery = this.entityManager.createNamedQuery("Libro.queryBuscarPorFecha", Libro.class);
        myQuery.setParameter("fecha", fechaPublicacion);

        return myQuery.getResultList();
    }
}
