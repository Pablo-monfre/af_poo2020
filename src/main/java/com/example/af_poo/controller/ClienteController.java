package com.example.af_poo.controller;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.example.af_poo.dto.ClienteDTO;
import com.example.af_poo.dto.ReservasDTO;
import com.example.af_poo.model.Cliente;
import com.example.af_poo.model.Reservas;
import com.example.af_poo.repository.ReservasRepository;
import com.example.af_poo.service.ClienteService;
import com.example.af_poo.service.ReservasService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/clientes")
public class ClienteController 
{
    @Autowired
    private ClienteService serviceCliente;

    @Autowired
    private ReservasService serviceReserva;

    @Autowired
    private ReservasRepository RepositoryReservas;

    @GetMapping()
    public List<Cliente> getClientes() 
    {
        return serviceCliente.getTodosCliente();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable int id)
    {
        serviceCliente.removePorId(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@RequestBody ClienteDTO clienteDTO, @PathVariable int id) 
    {
        Cliente cliente = serviceCliente.fromDTO(clienteDTO);
        cliente.setId(id);
        cliente = serviceCliente.salvar(cliente);
        return ResponseEntity.ok(cliente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClientePorId(@PathVariable int id)
    {
        Cliente cliente = serviceCliente.getClientePorId(id);
        return ResponseEntity.ok(cliente);
    }

    @GetMapping("/{id}/reservas")
    public List<ReservasDTO> getReservasCliente(@PathVariable int id)
    {
        Cliente cliente = serviceCliente.getClientePorId(id);
        return serviceReserva.toClienteListDTO(cliente.getReservas());
    }

    @PostMapping()
    public ResponseEntity<Cliente> salvar(@Valid @RequestBody ClienteDTO clienteDTO, HttpServletRequest request, UriComponentsBuilder builder)
    {
        Cliente cliente = serviceCliente.fromDTO(clienteDTO);
        Cliente novoCliente = serviceCliente.salvar(cliente);
        UriComponents uriComponents = builder.path(request.getRequestURI() + "/" + novoCliente.getId()).build();
        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @PostMapping("/{idCliente}/veiculos/{idVeiculo}")
    public ResponseEntity<Reservas> salvarReserva(@RequestBody ReservasDTO reservaDTO, @PathVariable int idCliente, @PathVariable int idVeiculo)
    {
        Reservas reserva = serviceReserva.fromDTO(reservaDTO);

        if(reserva.getDataInicio().getDayOfWeek().equals(DayOfWeek.SUNDAY) 
        ||  reserva.getDataFim().getDayOfWeek().equals(DayOfWeek.SUNDAY) )
        {
            return ResponseEntity.badRequest().build();
        }

        if(reserva.getDataInicio().isBefore(LocalDateTime.now()))
        {
            return ResponseEntity.badRequest().build();
        }

        if(reserva.getDataInicio().isBefore(reserva.getDataInicio()))
        {
            return ResponseEntity.badRequest().build();
        }
        else
        {
            for(Reservas aux: RepositoryReservas.getReservas())
            {
                if((reserva.getDataInicio().isAfter(aux.getDataInicio()) 
                && reserva.getDataInicio().isBefore(aux.getDataFim()))
                || (reserva.getDataFim().isAfter(aux.getDataInicio())
                && reserva.getDataFim().isBefore(aux.getDataFim()))
                || reserva.getDataInicio().isBefore(aux.getDataInicio()) 
                && reserva.getDataFim().isAfter(aux.getDataFim()))
                {
                    return ResponseEntity.badRequest().build();
                }
            }
            reserva = serviceReserva.salvar(reserva, idCliente, idVeiculo);
            reserva.setValorTotal((reserva.getDataFim().compareTo(reserva.getDataInicio())) * reserva.getVeiculo().getValorDiaria());
            return new ResponseEntity<Reservas>(HttpStatus.CREATED);
        }
    }
}
