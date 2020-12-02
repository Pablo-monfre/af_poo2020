package com.example.af_poo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.af_poo.dto.VeiculoDTO;
import com.example.af_poo.model.Veiculo;
import com.example.af_poo.repository.VeiculoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class VeiculoService 
{
    @Autowired
    private VeiculoRepository repository;

    public Veiculo fromDTO(VeiculoDTO dto)
    {
        Veiculo veiculo = new Veiculo();
        veiculo.setModelo(dto.getModelo());
        veiculo.setValorDiaria(dto.getValorDiaria());
        return veiculo;
    }

    public VeiculoDTO toDTO(Veiculo veiculo)
    {
        VeiculoDTO dto = new VeiculoDTO();
        dto.setModelo(veiculo.getModelo());
        dto.setValorDiaria(veiculo.getValorDiaria());
        return dto;
    }

    public List<VeiculoDTO> toListDTO(List<Veiculo> veiculos)
    {
        ArrayList<VeiculoDTO> listDTO = new ArrayList<VeiculoDTO>();

        for(Veiculo aux: veiculos)
        {
            listDTO.add(toDTO(aux));
        }
        return listDTO;
    }
    
    public List<Veiculo> getTodosVeiculos()
    
    {
        return repository.getTodosVeiculos();
    }
    
    public Veiculo getVeiculoPorId(int id){
        Optional <Veiculo> op = repository.getVeiculoPorId(id);
        return op.orElseThrow(  () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Veiculo nao encontrado"));
    }

    public void removePorId(int id)
    {
        repository.remove(getVeiculoPorId(id));
    }

    
    public Veiculo atualizar(Veiculo veiculo)
    
    {
        getVeiculoPorId(veiculo.getId());
        return repository.atualizar(veiculo);
    }

    public Veiculo salvar(Veiculo veiculo){
        return repository.salvar(veiculo);
    }

}
