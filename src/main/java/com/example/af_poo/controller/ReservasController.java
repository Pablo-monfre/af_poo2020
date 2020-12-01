package com.example.af_poo.controller;

import java.util.List;

import com.example.af_poo.model.Reservas;
//import com.example.af_poo.service.ClienteService;
import com.example.af_poo.service.ReservasService;
//import com.example.af_poo.service.VeiculoServise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/Reservas")
public class ReservasController 
{
    @Autowired
    private ReservasService ServiceReserva;

    //@Autowired
   // private ClienteService serviceCliente;

  //  @Autowired
 //   private VeiculoServise serviseVeiculo;

    @GetMapping
    public List<Reservas> getReservas()
    {
        return ServiceReserva.getReservas();
    }
    
    @GetMapping("/{numero}")
    public ResponseEntity<Reservas> getReservasPorNumero(@PathVariable int numero)
    {
        Reservas reservas = ServiceReserva.getReservasPorNumero(numero);
        return ResponseEntity.ok(reservas);
    }

    
    
    
}
