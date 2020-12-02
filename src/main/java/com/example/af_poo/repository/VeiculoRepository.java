package com.example.af_poo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import com.example.af_poo.model.Veiculo;

import org.springframework.stereotype.Component;

@Component
public class VeiculoRepository 
{
    private ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
    private int nextId;

    @PostConstruct
    public void init()
    {
        Veiculo c1 = new Veiculo();
        c1.setId(1);
        c1.setModelo("hb20");
        c1.setValorDiaria(200);

        nextId = 2;
    }

    public List<Veiculo> getTodosVeiculos()
    {
        return veiculos;
    }

    public Optional<Veiculo>  getVeiculoPorId(int id)
    {
        for(Veiculo aux : veiculos)
        {
            if(aux.getId() == id)
            {
                return Optional.of(aux);
            }
        }
        return Optional.empty();
    }

    public void remove(Veiculo veiculo)
    {
        veiculos.remove(veiculo);
    }

    public Veiculo atualizar(Veiculo veiculo)
    {
        Veiculo aux = getVeiculoPorId(veiculo.getId()).get();

        if(aux != null)
        {
            aux.setModelo(veiculo.getModelo());
            aux.setValorDiaria(veiculo.getValorDiaria());
        }
        return aux;
    }

    public Veiculo salvar(Veiculo veiculo)
    {
        veiculo.setId(nextId++);
        veiculos.add(veiculo);
        return veiculo;
    }

}
