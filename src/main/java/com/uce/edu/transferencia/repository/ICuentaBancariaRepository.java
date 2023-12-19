package com.uce.edu.transferencia.repository;

import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;

public interface ICuentaBancariaRepository {
    // CRUD
    public CuentaBancaria seleccionar(String numero);
    public void insertar(CuentaBancaria cuentaBancaria);
    public void actualizar(CuentaBancaria cuentaBancaria);
    public void eliminar(String numero);
}
