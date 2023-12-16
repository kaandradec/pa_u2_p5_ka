package com.uce.edu.service;

import com.uce.edu.repository.IEstudianteRepository;
import com.uce.edu.repository.modelo.Estudiante;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EstudianteServiceImpl implements  IEstudianteService{
    @Autowired
    private IEstudianteRepository iEstudianteRepository;
    @Override
    public Estudiante buscar(Integer id) {
        return this.iEstudianteRepository.seleccionar(id);
    }

    @Override
    public void registrar(Estudiante estudiante) {
        this.iEstudianteRepository.insertar(estudiante);
    }

    @Override
    public void actualizar(Estudiante estudiante) {
        this.iEstudianteRepository.actualizar(estudiante);
    }

    @Override
    public void eliminar(Integer id) {
        this.iEstudianteRepository.eliminar(id);
    }
}
