package com.example.af_poo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import com.example.af_poo.model.Cliente;

import org.springframework.stereotype.Component;

@Component
public class ClienteRepository 
{
    private List<Cliente> clientes;
    private int nextId = 1;

    @PostConstruct
    public void init() 
    {
        Cliente c1 = new Cliente();
        c1.setId(1);
        c1.setNome("Pablo");
        c1.setEndereco("Rua Avenida, 102");
        c1.setCpf("23234543212");

        clientes = new ArrayList<Cliente>();
        clientes.add(c1);

        nextId = 2;
    }

    public Cliente save(Cliente cliente) 
    {
        cliente.setId(nextId);
        clientes.add(cliente);
        nextId++;
        return cliente;

    }

    public List<Cliente> getClientes() 
    {
        return clientes;
    }

    public Optional<Cliente> getClientePorId(int id) 
    {
        for (Cliente aux : clientes) 
        {
            if (aux.getId() == id) 
            {
                return Optional.of(aux);
            }
        }
        return Optional.empty();
    }

    public Cliente salvar(Cliente cliente)
    {
        cliente.setId(nextId++);
        clientes.add(cliente);
        return cliente;
    }

    public void remove(Cliente cliente) 
    {
        clientes.remove(cliente);
	}

    public Cliente update(Cliente cliente) 
    {
        
        Cliente aux = getClientePorId(cliente.getId()).get();

        if(aux != null)
        {
            aux.setNome(cliente.getNome());
            aux.setEndereco(cliente.getEndereco());
            aux.setCpf(cliente.getCpf());
        }
        
        return aux;
        
	}


    
}
