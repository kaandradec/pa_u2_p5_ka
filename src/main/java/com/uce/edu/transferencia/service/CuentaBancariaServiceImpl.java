package com.uce.edu.transferencia.service;

import com.uce.edu.transferencia.repository.ICuentaBancariaRepository;
import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CuentaBancariaServiceImpl implements ICuentaBancariaService{
    @Autowired
    private ICuentaBancariaRepository bancariaRepository;
    @Override
    public CuentaBancaria buscar(String numero) {
        return this.bancariaRepository.seleccionar(numero);
    }

    @Override
    public void guardar(CuentaBancaria cuentaBancaria) {
        this.bancariaRepository.insertar(cuentaBancaria);
    }

    @Override
    public void actualizar(CuentaBancaria cuentaBancaria) {
        this.bancariaRepository.actualizar(cuentaBancaria);
    }

    @Override
    public void eliminar(String numero) {
        this.bancariaRepository.eliminar(numero);

    }


    public void depositar(String numeroCuenta,  BigDecimal monto){
        CuentaBancaria cta = this.bancariaRepository.seleccionar(numeroCuenta);
        BigDecimal saldoActual = cta.getSaldo();
        BigDecimal montoConDescuento = descontarPorcentaje(monto, 0.9);

        cta.setSaldo(saldoActual.add(montoConDescuento));
        this.bancariaRepository.actualizar(cta);
    }

    public BigDecimal descontarPorcentaje(BigDecimal monto, double porcentaje){
        return monto.multiply(new BigDecimal(porcentaje + ""));
    }

}
