package com.example.af_poo.controller;

import javax.servlet.http.HttpServletRequest;

import com.example.af_poo.dto.ClienteDTO;
import com.example.af_poo.model.Cliente;
import com.example.af_poo.service.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/Clientes")
public class ClienteController 
{
    @Autowired
    private ClienteService service;

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClientePorId(@PathVariable int id)
    {
        Cliente cliente = service.getClientePorId(id);
        return ResponseEntity.ok(cliente);
    }

    @PostMapping
    public ResponseEntity<Cliente> salvar(@RequestBody ClienteDTO clienteDTO,
                                           HttpServletRequest request,
                                           UriComponentsBuilder builder
                                           ) {
         Cliente cliente = service.fromDTO(clienteDTO);
         cliente = service.save(cliente);
         UriComponents uriComponents = builder.path(request.getRequestURI()+"/"+cliente.getId()).build();
         return ResponseEntity.created(uriComponents.toUri()).build();
    }
    
    
}
