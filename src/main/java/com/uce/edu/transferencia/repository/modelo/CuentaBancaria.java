package com.uce.edu.transferencia.repository.modelo;

import jakarta.persistence.*;

import java.math.BigDecimal;

//@Entity
//@Table(name = "cuenta_bancaria")
public class CuentaBancaria {
    @Column(name = "cuenta_id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cuenta")
    @SequenceGenerator(name = "seq_cuenta", sequenceName = "seq_cuenta", allocationSize = 1)
    private String numero;
    @Column(name = "cuenta_cedula")
    private String cedulaPropietario;
    @Column(name = "cuenta_saldo")
    private BigDecimal saldo;

    // SET Y GET
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCedulaPropietario() {
        return cedulaPropietario;
    }

    public void setCedulaPropietario(String cedulaPropietario) {
        this.cedulaPropietario = cedulaPropietario;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "CuentaBancaria{" +
                "numero='" + numero + '\'' +
                ", cedulaPropietario='" + cedulaPropietario + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}
