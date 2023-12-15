package com.uce.edu.debermapeoobjetos.repository.modelo;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "orden")
public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_orden")
    @SequenceGenerator(name = "seq_orden", sequenceName = "seq_orden", allocationSize = 1)
    @Column(name = "orden_id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "orden_cliente_id")  // Un Cliente puede tener varias Ordenes
    private Cliente cliente;
    @Column(name = "orden_fecha")
    private LocalDate fecha;
    @Column(name = "orden_total")
    private BigDecimal total;
    @Column(name = "orden_estado")
    private String estado;

    //GETTERS SETTERS
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
