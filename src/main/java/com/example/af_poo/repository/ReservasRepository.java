package com.example.af_poo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.af_poo.model.Reservas;

import org.springframework.stereotype.Component;

@Component
public class ReservasRepository 
{
    private ArrayList<Reservas> reserva;
    private int nextNumero = 1;

    public List<Reservas> getReservas()
    {
        return reserva;
    }

    public Optional<Reservas> getReservasPorNumero( int numero)
    {
        for( Reservas aux : reserva)
        {
            if(aux.getNumero() == numero)
            {
                return Optional.of(aux);
            }
        }
        return Optional.empty();
    }

    public Reservas salvar(Reservas Reservas)
    {
        Reservas.setNumero(nextNumero++);
        reserva.add(reserva);
        return reserva;
    }

    public void remove(Reservas reserva) 
    {
        reservas.remove(reserva);
	}
    
}
