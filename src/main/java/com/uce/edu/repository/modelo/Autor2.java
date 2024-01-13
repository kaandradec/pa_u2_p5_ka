package com.uce.edu.repository.modelo;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "autor2")
public class Autor2 {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_autor2")
    @SequenceGenerator(name = "seq_autor2", sequenceName = "seq_autor2", allocationSize = 1)
    @Column(name = "auto_id")
    private Integer id;
    @Column(name = "auto_nombre")
    private String nombre;
    @Column(name = "auto_nacionalidad")
    private String nacionalidad;

    @OneToMany(mappedBy = "autor2")
    private List<AutorLibro> autoresLibros;

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

    public List<AutorLibro> getAutoresLibros() {
        return autoresLibros;
    }

    public void setAutoresLibros(List<AutorLibro> autoresLibros) {
        this.autoresLibros = autoresLibros;
    }
}
