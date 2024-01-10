package com.uce.edu.repository;

import com.uce.edu.repository.modelo.AutorLibro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class AutorLibroRepositoryImpl implements IAutorLibroRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public AutorLibro seleccionarPorCodigo(String codigo) {
        Query myQuery = entityManager.createQuery("SELECT al FROM AutorLibro al WHERE al.codigo = :codigo");
        myQuery.setParameter("codigo", codigo);
        return (AutorLibro) myQuery.getSingleResult();
    }

    @Override
    public void insertar(AutorLibro autorLibro) {
        this.entityManager.persist(autorLibro);
    }

    @Override
    public void actualizar(AutorLibro autorLibro) {
        this.entityManager.merge(autorLibro);
    }
}
