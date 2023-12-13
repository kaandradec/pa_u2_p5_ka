package com.uce.edu.repository.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "alumno")
public class Alumno {
    @Column(name = "alum_id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_alumno")
    @SequenceGenerator(name = "seq_alumno", sequenceName = "seq_alumno", allocationSize = 1)
    private Integer id;
    @Column(name = "alum_nombre")
    private String nombre;

    // SET Y GET
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
