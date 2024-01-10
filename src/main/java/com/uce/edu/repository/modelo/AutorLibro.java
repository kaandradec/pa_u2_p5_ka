package com.uce.edu.repository.modelo;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "autor2_libro2")
public class AutorLibro {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_autor_libro")
    @SequenceGenerator(name = "seq_autor_libro", sequenceName = "seq_autor_libro", allocationSize = 1)
    @Column(name = "auli_id")
    private Integer id;

    @Column(name = "auli_fecha")
    private LocalDateTime fecha;
    @Column(name = "auli_codigo")
    private String codigo;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "auli_id_autor")
    private Autor2 autor2;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "auli_id_libro")
    private Libro2 libro2;


    // SET Y GET
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Autor2 getAutor2() {
        return autor2;
    }

    public void setAutor2(Autor2 autor2) {
        this.autor2 = autor2;
    }

    public Libro2 getLibro2() {
        return libro2;
    }

    public void setLibro2(Libro2 libro2) {
        this.libro2 = libro2;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
