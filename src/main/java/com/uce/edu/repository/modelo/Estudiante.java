package com.uce.edu.repository.modelo;

import jakarta.persistence.*;
import org.hibernate.id.factory.internal.AutoGenerationTypeStrategy;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name ="estudiante")
public class Estudiante {
    @Column(name = "estu_id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @SequenceGenerator(name = "generador", sequenceName = "seq_estudiante", allocationSize = 1)
    private Integer id;
    @Column(name = "estu_nombre")
    private String nombre;
    @Column(name = "estu_apellido")
    private String apellido;
    @Column(name = "estu_cedula")
    private String cedula;
    @Column(name = "estu_fecha_nacimiento")
    private LocalDateTime fechaNacimiento;

    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

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

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
}
