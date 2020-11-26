package com.example.af_poo.service;

import java.util.List;
import java.util.Optional;

import com.example.af_poo.dto.ClienteDTO;
import com.example.af_poo.model.Cliente;
import com.example.af_poo.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ClienteService 
{
    @Autowired
    private ClienteRepository repository;

    public Cliente fromDTO(ClienteDTO objDTO){
        Cliente cliente = new Cliente();
        cliente.setEndereco(objDTO.getEndereco());
        return cliente;
    }

	public List<Cliente> getClientes() {
		return repository.getClientes();
	}

	public Cliente getClientePorId(int id) {
        Optional<Cliente> op = repository.getClientePorId(id);
        return op.orElseThrow( () ->  new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não cadastrado!"));
	}

	public Cliente save(Cliente cliente) {
      	return repository.save(cliente);
	}

	public void removePorId(int id) {
         repository.delete(getClientePorId(id)); 
	}

	public Cliente update(Cliente cliente) {
        getClientePorId(cliente.getId()); //So para lancar o 404
		return repository.update(cliente);
	}
    

}
