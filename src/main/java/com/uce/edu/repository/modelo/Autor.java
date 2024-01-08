package com.uce.edu.repository.modelo;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "autor")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_autor")
    @SequenceGenerator(name = "seq_autor", sequenceName = "seq_autor", allocationSize = 1)
    @Column(name = "auto_id")
    private Integer id;
    @Column(name = "auto_nombre")
    private String nombre;
    @Column(name = "auto_nacionalidad")
    private String nacionalidad;
    @ManyToMany(mappedBy = "autores", cascade =  CascadeType.ALL) // nombre de la otra entidad que se va a mapear.
    private Set<Libro> libros;

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

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Set<Libro> getLibros() {
        return libros;
    }

    public void setLibros(Set<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Autor{");
        sb.append("id=").append(id);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", nacionalidad='").append(nacionalidad).append('\'');
//        sb.append(", libros=").append(libros);
        sb.append('}');
        return sb.toString();
    }
}
