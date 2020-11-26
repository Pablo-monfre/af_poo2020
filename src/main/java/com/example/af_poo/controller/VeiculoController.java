package com.example.af_poo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.example.af_poo.dto.VeiculoDTO;
import com.example.af_poo.model.Veiculo;
import com.example.af_poo.service.VeiculoServise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController 
{
    @Autowired
    private VeiculoServise service;
    
    @GetMapping
    public List<Veiculo> getTodosVeiculos()
    {
        return service.getTodosVeiculos();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> getVeiculoPorId(@PathVariable int id)
    {
        Veiculo veiculo = service.getVeiculoPorId(id);
        return ResponseEntity.ok(veiculo);
    } 

    @PostMapping
    public ResponseEntity<Veiculo> getVeiculoPorId(@RequestBody VeiculoDTO veiculoDTO, HttpServletRequest request,
            UriComponentsBuilder builder)
    {
        Veiculo veiculo = service.fromDTO(veiculoDTO);
        veiculo = service.salvar(veiculo);
        UriComponents uriComponents = builder.path(request.getRequestURI()+"/"+veiculo.getId()).build();
        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable int id)
    {

        service.removePorId(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> atualizar(@RequestBody VeiculoDTO veiculoDTO, @PathVariable int id)
    {
        Veiculo veiculo = service.fromDTO(veiculoDTO);
        veiculo.setId(id);
        veiculo = service.atualizar(veiculo);
        return ResponseEntity.ok(veiculo);

    }
}
