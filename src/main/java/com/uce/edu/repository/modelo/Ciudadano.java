package com.uce.edu.repository.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "ciudadano")
public class Ciudadano {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_ciudadano")
    @SequenceGenerator(name = "seq_ciudadano", sequenceName = "seq_ciudadano", allocationSize = 1)
    @Column(name = "ciud_id")
    private Integer id;
    @Column(name = "ciud_nombre")
    private String nombre;
    @Column(name = "ciud_apellido")
    private String apellido;
    @OneToOne(mappedBy = "ciudadano") // empleado va hacer una relacion a
    private Empleado empleado;

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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Ciudadano{");
        sb.append("id=").append(id);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", apellido='").append(apellido).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
