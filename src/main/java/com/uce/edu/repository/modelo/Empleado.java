package com.uce.edu.repository.modelo;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_empleado")
    @SequenceGenerator(name = "seq_empleado", sequenceName = "seq_empleado", allocationSize = 1)
    @Column(name = "empl_id")
    private Integer id;
    @Column(name = "empl_salario")
    private BigDecimal salario;
    @Column(name = "empl_fecha_ingreso")
    private LocalDateTime fechaIngreso;
    @OneToOne
    @JoinColumn(name = "empl_id_ciudadano")
    private Ciudadano ciudadano;

    // GET Y SET
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDateTime fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Ciudadano getCiudadano() {
        return ciudadano;
    }

    public void setCiudadano(Ciudadano ciudadano) {
        this.ciudadano = ciudadano;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", salario=" + salario +
                ", fechaIngreso=" + fechaIngreso +
                ", ciudadano=" + ciudadano +
                '}';
    }
}
