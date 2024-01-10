package com.uce.edu.repository.modelo;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "libro2")
public class Libro2 {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_libro2")
    @SequenceGenerator(name = "seq_libro2", sequenceName = "seq_libro2", allocationSize = 1)
    @Column(name = "libr_id")
    private Integer id;
    @Column(name = "libr_titulo")
    private String titulo;
    @Column(name = "libr_fecha_publicacion")
    private LocalDateTime fechaPublicacion;

    @OneToMany(mappedBy = "libro2")
    private List<AutorLibro> autoresLibros;

    // SET Y GET
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDateTime getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDateTime fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public List<AutorLibro> getAutoresLibros() {
        return autoresLibros;
    }

    public void setAutoresLibros(List<AutorLibro> autoresLibros) {
        this.autoresLibros = autoresLibros;
    }
}
