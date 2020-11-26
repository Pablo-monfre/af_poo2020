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
    private int nextId;

    @PostConstruct
    public void init() {

        Cliente c1 = new Cliente();
        c1.setId(1);
        c1.setNome("Jose");
        c1.setEndereco("Rua X, 99");
        c1.setCpf(1001232323);

        clientes = new ArrayList<Cliente>();
        clientes.add(c1);

        nextId = 2;
    }

    public Cliente save(Cliente cliente) {
        cliente.setId(nextId);
        clientes.add(cliente);
        nextId++;
        return cliente;

    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public Optional<Cliente> getClientePorId(int id) {
        for (Cliente aux : clientes) {
            if (aux.getId() == id) {
                return Optional.of(aux);
            }
        }
        return Optional.empty();
    }

	public void delete(Cliente cliente) {
        clientes.remove(cliente);
	}

	public Cliente update(Cliente cliente) {
        
        Cliente aux = getClientePorId(cliente.getId()).get();

        if(aux != null){
            aux.setEndereco(cliente.getEndereco());
            aux.setNome(cliente.getNome());
        }

        return aux;
        
	}


    
}
