package com.uce.edu.repository.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "mascota")
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_mascota")
    @SequenceGenerator(name = "seq_mascota", sequenceName = "seq_mascota", allocationSize = 1)
    @Column(name = "id_mascota")
    private Long id;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "telefono_placa")
    private String telefonoPlaca;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "edad")
    private Integer edad;

    @Column(name = "color")
    private String color;

    @Column(name = "peso")
    private Double peso;

    // GET Y SET
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Mascota{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", edad=" + edad +
                ", color='" + color + '\'' +
                ", peso=" + peso +
                '}';
    }
}
