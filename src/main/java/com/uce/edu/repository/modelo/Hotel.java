package com.uce.edu.repository.modelo;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_hotel")
    @SequenceGenerator(name = "seq_hotel", sequenceName = "seq_hotel", allocationSize = 1)
    @Column(name = "hote_id")
    private Integer id;
    @Column(name = "hote_nombre")
    private String nombre;
    @Column(name = "hote_direccion")
    private String direccion;
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL) // mappedBy: atributo con que fue mapeado en la otra clase (Habitacion)
    private List<Habitacion> habitaciones;

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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(List<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Hotel{");
        sb.append("id=").append(id);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", direccion='").append(direccion).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
