package com.uce.edu.debermapeoobjetos.repository.modelo;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "autor")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_autor")
    @SequenceGenerator(name = "seq_autor", sequenceName = "seq_autor", allocationSize = 1)
    @Column(name = "autor_id")
    private Integer id;
    @Column(name = "autor_nombre")
    private String nombre;
    @Column(name = "autor_apellido")
    private String apellido;
    @Column(name = "autor_fecha_nacimiento")
    private LocalDate fechaNacimiento;
    @Column(name = "autor_nacionalidad")
    private String nacionalidad;

    //GETTERS SETTERS
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
}
