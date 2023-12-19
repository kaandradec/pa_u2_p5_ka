package com.uce.edu.transferencia.repository.modelo;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

//@Entity
//@Table(name = "transferencia")
public class Transferencia {
    @Column(name = "trans_id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_trans")
    @SequenceGenerator(name = "seq_trans", sequenceName = "seq_trans", allocationSize = 1)
    private String numero;
    @Column(name = "trans_fecha")
    private LocalDateTime fecha;
    @Column(name = "trans_monto")
    private BigDecimal monto;
    @Column(name = "trans_cuenta_origen")
    private CuentaBancaria cuentaOrigen;
    @Column(name = "trans_cuenta_destino")
    private CuentaBancaria cuentaDestino;

    public Transferencia(){
    }

    // GET SET
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public CuentaBancaria getCuentaOrigen() {
        return cuentaOrigen;
    }

    public void setCuentaOrigen(CuentaBancaria cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    public CuentaBancaria getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(CuentaBancaria cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    @Override
    public String toString() {
        return "Transferencia{" +
                "numero='" + numero + '\'' +
                ", fecha=" + fecha +
                ", monto=" + monto +
                ", cuentaOrigen=" + cuentaOrigen +
                ", cuentaDestino=" + cuentaDestino +
                '}';
    }
}
