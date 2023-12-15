package com.uce.edu.debermapeoobjetos.repository.modelo;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "libro")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_libro")
    @SequenceGenerator(name = "seq_libro", sequenceName = "seq_libro", allocationSize = 1)
    @Column(name = "libro_id")
    private Integer id;
    @Column(name = "libro_nombre")
    private String titulo;
    @ManyToOne // Varios libros pueden pertenecer a un Autor
    @JoinColumn(name = "libro_autor_id")
    private Autor autor;
    @Column(name = "libro_fecha_publicacion")
    private LocalDate fechaPublicacion;
    @Column(name = "libro_precio")
    private BigDecimal precio;

    //GETTERS SETTERS
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

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
}
