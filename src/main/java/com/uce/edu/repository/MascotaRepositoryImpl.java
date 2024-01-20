package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Mascota;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Transactional
public class MascotaRepositoryImpl implements IMascotaRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Mascota> listarMascotas() {
        Query query = this.entityManager.createNativeQuery("SELECT * FROM mascota", Mascota.class);
        return query.getResultList();
    }

    @Override
    public List<Mascota> listarMascotasPorTipo(String tipo) {
        TypedQuery<Mascota> query = entityManager.createQuery("SELECT m FROM Mascota m WHERE m.tipo = :tipo", Mascota.class);
        query.setParameter("tipo", tipo);

        return query.getResultList();
    }

    @Override
    public void actualizarColorMascota(String nombre, String nuevoColor) {
        Query query = entityManager.createNativeQuery("UPDATE mascota SET color = :nuevoColor WHERE nombre = :nombre");
                query.setParameter("nombre", nombre);
                query.setParameter("nuevoColor", nuevoColor);
        query.executeUpdate();
    }

    @Override
    public void eliminarMascotaPorId(Long id) {
        Query query = entityManager.createNativeQuery("DELETE FROM mascota WHERE id_mascota = :id");
        query.setParameter("id", id);

        query.executeUpdate();
    }

    @Override
    public Long contarMascotas() {
        Query nativeQuery = entityManager.createNativeQuery("SELECT COUNT(*) FROM mascota");
        return (Long) nativeQuery.getSingleResult();
    }
}
