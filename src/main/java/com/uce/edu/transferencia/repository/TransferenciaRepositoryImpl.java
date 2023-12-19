package com.uce.edu.transferencia.repository;

import com.uce.edu.transferencia.repository.modelo.Transferencia;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TransferenciaRepositoryImpl implements ITransferenciaRepository{
    private static List<Transferencia> base = new ArrayList<>();

    @Override
    public Transferencia seleccionar(String numero) {
        for(Transferencia transfer:base) {
            if (transfer.getNumero().equals(numero)) {
                return transfer;
            }
        }
        return null;
    }

    @Override
    public void insertar(Transferencia transferencia) {
        base.add(transferencia);
    }

    @Override
    public void actualizar(Transferencia transferencia) {
        this.eliminar(transferencia.getNumero());
        this.insertar(transferencia);
    }

    @Override
    public void eliminar(String numero) {
        Transferencia transfer = this.seleccionar(numero);
        base.remove(transfer);
    }

    @Override
    public List<Transferencia> listar() {
        return base;
    }
}
