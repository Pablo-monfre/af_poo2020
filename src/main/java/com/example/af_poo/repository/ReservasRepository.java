package com.example.af_poo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.af_poo.model.Reservas;

import org.springframework.stereotype.Component;

@Component
public class ReservasRepository 
{
    private ArrayList<Reservas> reservas;
 //   private int nextNumero = 1;

    public List<Reservas> getReservas()
    {
        return reservas;
    }

    public Optional<Reservas> getReservasPorNumero( int numero)
    {
        for( Reservas aux : reservas)
        {
            if(aux.getNumero() == numero)
            {
                return Optional.of(aux);
            }
        }
        return Optional.empty();
    }

  //  public Reservas salvar(Reservas Reservas)
    //{
   //     reservas.setNumero(nextNumero++);
     //   reservas.add(reservas);
       // return reservas;
    //}
    
}
