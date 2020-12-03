package com.example.af_poo.controller;


import com.example.af_poo.model.Reservas;
import com.example.af_poo.service.ReservasService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/reservas")
public class ReservasController 
{
    @Autowired
    ReservasService reservaService;

    @GetMapping("/{numero}")
    public ResponseEntity<Reservas> getReservaPorNumero(@PathVariable int numero)
    {
        return ResponseEntity.ok(reservaService.getReservasPorNumero(numero));
    }
    
    
}
