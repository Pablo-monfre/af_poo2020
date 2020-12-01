package com.example.af_poo.service;

import java.util.List;
import java.util.Optional;

import com.example.af_poo.model.Reservas;
import com.example.af_poo.repository.ReservasRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ReservasService 
{
    @Autowired
    private ReservasRepository repository;

    public List<Reservas> getReservas()
    {
        return repository.getReservas();
    }

    public Reservas getReservasPorNumero(int numero) {
        Optional<Reservas> op = repository.getReservasPorNumero(numero);
		return op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente nao cadastrado"));
	}


  //  public Reservas salvar(Reservas reservas)
    {
  //      return repository.salvar(reservas);
    }

    public void removePorNumero(int numero)
    {
 //       repository.remove(getReservasPorNumero(numero));
    }


    
}
