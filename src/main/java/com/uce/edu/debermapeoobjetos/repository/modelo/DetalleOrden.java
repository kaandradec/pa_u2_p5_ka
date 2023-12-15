package com.uce.edu.debermapeoobjetos.repository.modelo;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "detalle_orden")
public class DetalleOrden {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_detalle_orden")
    @SequenceGenerator(name = "seq_detalle_orden", sequenceName = "seq_detalle_orden", allocationSize = 1)
    @Column(name = "det_id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "det_orden_id") // Una Orden puede estar en varios detallesDeOrden
    private Orden orden;
    @ManyToOne
    @JoinColumn(name = "det_libro_id") // Un libro puede estar en varios detallesDeorden
    private Libro libro;
    @Column(name = "det_cantidad")
    private Integer cantidad;
    @Column(name = "det_subtotal")
    private BigDecimal subtotal;

    //GETTERS SETTERS
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }
}
