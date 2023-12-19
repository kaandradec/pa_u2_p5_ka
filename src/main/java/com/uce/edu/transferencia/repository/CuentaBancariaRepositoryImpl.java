package com.uce.edu.transferencia.repository;

import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CuentaBancariaRepositoryImpl implements ICuentaBancariaRepository{
    private static List<CuentaBancaria> base = new ArrayList<>();

    @Override
    public CuentaBancaria seleccionar(String numero) {
        for(CuentaBancaria cuenta:base) {
            if (cuenta.getNumero().equals(numero)) {
                CuentaBancaria cta = new CuentaBancaria();
                cta.setCedulaPropietario(cuenta.getCedulaPropietario());
                cta.setNumero(cuenta.getNumero());
                cta.setSaldo(cuenta.getSaldo());
                return cta;
            }
        }
        return null;
    }

    public CuentaBancaria seleccionarEliminar(String numero) {
        for(CuentaBancaria cuenta:base) {
            if (cuenta.getNumero().equals(numero)) {
                return cuenta;
            }
        }
        return null;
    }

    @Override
    public void insertar(CuentaBancaria cuentaBancaria) {
        base.add(cuentaBancaria);
    }

    @Override
    public void actualizar(CuentaBancaria cuentaBancaria) {
        this.eliminar(cuentaBancaria.getNumero());
        this.insertar(cuentaBancaria);
    }

    @Override
    public void eliminar(String numero) {
        CuentaBancaria cuenta = this.seleccionarEliminar(numero);
        base.remove(cuenta);

    }
}
