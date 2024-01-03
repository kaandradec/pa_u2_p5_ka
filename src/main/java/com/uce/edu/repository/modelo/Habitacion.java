package com.uce.edu.repository.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "habitacion")
public class Habitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_habitacion")
    @SequenceGenerator(name = "seq_habitacion", sequenceName = "seq_habitacion", allocationSize = 1)
    @Column(name = "habi_id")
    private Integer id;
    @Column(name = "habi_numero")
    private String numero;

    @Column(name = "habi_clase")
    private String clase;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "habi_id_hotel") // nombre de la columna con la que se va a relacionar FK
    private Hotel hotel;
    // SET Y GET
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public String toString() {
        return "Habitacion{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", clase='" + clase + '\'' +
                '}';
    }
}
