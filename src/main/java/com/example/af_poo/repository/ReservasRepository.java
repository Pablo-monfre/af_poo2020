package com.example.af_poo.repository;

import java.util.ArrayList;
import java.util.Optional;

import com.example.af_poo.model.Reservas;
import com.example.af_poo.model.Veiculo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReservasRepository 
{
    @Autowired
    ClienteRepository clienteRepositorio;

    @Autowired
    VeiculoRepository veiculoRepositorio;

    private ArrayList<Reservas> reservas = new ArrayList<Reservas>();
    private int proxCod = 1;

    public Optional<Reservas> getReservaPorNumero(int numero)
    {
        for(Reservas aux : reservas)
        {
            if(aux.getNumero() == numero)
            {
                return Optional.of(aux);
            }
        }
        return Optional.empty();
    }

    public Reservas salvar(Reservas reserva, int idCliente, int idVeiculo)
    {
        reserva.setNumero(proxCod++);
        reserva.setCliente(clienteRepositorio.getClientePorId(idCliente).get());
        reserva.setVeiculo(veiculoRepositorio.getVeiculoPorId(idVeiculo).get());
        reservas.add(reserva);
        return reserva;
    }
    
    public void remove(Veiculo veiculo)
    {
        for ( Reservas aux : reservas)
        {
            if ( veiculo.getId() == aux.getVeiculo().getId())
            {
                reservas.remove(aux);
            }
        }
    }

    public ArrayList<Reservas> getReservas() 
    {
        return reservas;
    }

    public void setReservas(ArrayList<Reservas> reservas) 
    {
        this.reservas = reservas;
    }
    
}
