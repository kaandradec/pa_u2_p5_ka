package com.uce.edu.transferencia.service;

import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;

import java.math.BigDecimal;

public interface ICuentaBancariaService {
    public CuentaBancaria buscar(String numero);
    public void guardar(CuentaBancaria cuentaBancaria);
    public void actualizar(CuentaBancaria cuentaBancaria);
    public void eliminar(String numero);
    public void depositar(String numeroCuenta,  BigDecimal monto);
}

