package com.example.af_poo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.af_poo.dto.ReservasDTO;
import com.example.af_poo.model.Reservas;
import com.example.af_poo.model.Veiculo;
import com.example.af_poo.repository.ReservasRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ReservasService 
{
    @Autowired
    private ReservasRepository repository;

    @Autowired
    VeiculoService veiculoService;

    @Autowired
    ClienteService clienteService;

    public Reservas fromDTO(ReservasDTO reservasDTO)
    {
        Reservas reserva = new Reservas();
        reserva.setDataInicio(reservasDTO.getDataInicio());
        reserva.setDataFim(reservasDTO.getDataFim());
        return reserva;
    }

    public Reservas getReservasPorNumero(int numero)
    {
        Optional<Reservas> op = repository.getReservaPorNumero(numero);
        return op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reserva não encontrada"));
    }

    public Reservas salvar(Reservas reserva, int idCliente, int idVeiculo)
    {
        veiculoService.getVeiculoPorId(idVeiculo).addReserva(reserva);
        clienteService.getClientePorId(idCliente).addReserva(reserva);
        return repository.salvar(reserva, idCliente, idVeiculo);
    }

    public void remove (Veiculo veiculo)
    {
        repository.remove(veiculo);
    }

    public ReservasDTO toClienteDTO(Reservas reserva)
    {
        ReservasDTO dto = new ReservasDTO();

        dto.setNumero(reserva.getNumero());
        dto.setDataInicio(reserva.getDataInicio());
        dto.setDataFim(reserva.getDataFim());
        dto.setVeiculo(reserva.getVeiculo());
        dto.setValorTotal(reserva.getValorTotal());
        
        return dto;
    }

    public ReservasDTO toVeiculoDTO(Reservas reserva)
    {
        ReservasDTO dto = new ReservasDTO();

        dto.setNumero(reserva.getNumero());
        dto.setDataInicio(reserva.getDataInicio());
        dto.setDataFim(reserva.getDataFim());
        dto.setCliente(reserva.getCliente());
        dto.setValorTotal(reserva.getValorTotal());
        
        return dto;
    }

    public List<ReservasDTO> toClienteListDTO(List<Reservas> reservas)
    {
        ArrayList<ReservasDTO> listDTO = new ArrayList<ReservasDTO>();

        for(Reservas aux: reservas)
        {
            listDTO.add(toClienteDTO(aux));
        }
        return listDTO;
    }

    public List<ReservasDTO> toVeiculoListDTO(List<Reservas> reservas)
    {
        ArrayList<ReservasDTO> listDTO = new ArrayList<ReservasDTO>();

        for(Reservas aux: reservas)
        {
            listDTO.add(toVeiculoDTO(aux));
        }
        return listDTO;
    }
    
}
