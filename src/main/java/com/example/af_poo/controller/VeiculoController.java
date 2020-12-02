package com.example.af_poo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.example.af_poo.dto.ReservasDTO;
import com.example.af_poo.dto.VeiculoDTO;
import com.example.af_poo.model.Veiculo;
import com.example.af_poo.service.ReservasService;
import com.example.af_poo.service.VeiculoService;

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
    VeiculoService serviceVeiculo;

    @Autowired
    ReservasService serviceReservas;

    @GetMapping()
    public List<Veiculo> getVeiculos()
    {
        return  serviceVeiculo.getTodosVeiculos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> getVeiculoPorId(@PathVariable int id)
    {
        Veiculo veiculo = serviceVeiculo.getVeiculoPorId(id);
        return ResponseEntity.ok(veiculo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(@PathVariable int id)
    {
        Veiculo veiculo = serviceVeiculo.getVeiculoPorId(id);
        
        serviceReservas.remove(veiculo);
        serviceVeiculo.removePorId(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> atualizar(@RequestBody VeiculoDTO veiculoDTO, @PathVariable int id)
    {
        Veiculo veiculo = serviceVeiculo.fromDTO(veiculoDTO);
        veiculo.setId(id);
        veiculo = serviceVeiculo.atualizar(veiculo);
        return ResponseEntity.ok(veiculo);
    }

    @GetMapping("/{codigo}/reservas")
    public List<ReservasDTO> getReservasCliente(@PathVariable int id)
    {
        Veiculo veiculo = serviceVeiculo.getVeiculoPorId(id);
        return serviceReservas.toVeiculoListDTO(veiculo.getReservas());
    }

    @PostMapping()
    public ResponseEntity<Veiculo> salvar(@Valid @RequestBody VeiculoDTO veiculoDTO, HttpServletRequest request, UriComponentsBuilder builder)
    {
        Veiculo veiculo = serviceVeiculo.fromDTO(veiculoDTO);
        Veiculo novoVeiculo = serviceVeiculo.salvar(veiculo);
        UriComponents uriComponents = builder.path(request.getRequestURI() + "/" + novoVeiculo.getId()).build();
        return ResponseEntity.created(uriComponents.toUri()).build();
    }
}
