package com.example.af_poo.dto;

import java.time.LocalDateTime;

import com.example.af_poo.model.Cliente;
import com.example.af_poo.model.Veiculo;
import com.fasterxml.jackson.annotation.JsonFormat;

import org.hibernate.validator.constraints.Length;

public class ReservasDTO 
{
    private int numero;
    private Cliente cliente;
    private Veiculo veiculo;
    
    @Length(message = "Data no formato: 'dd/MM/yyyy@HH:mm:ss' ")
    @JsonFormat(pattern = "dd/MM/yyyy@HH:mm")
    private LocalDateTime dataInicio;
    @Length(message = "Data no formato: 'dd/MM/yyyy@HH:mm:ss' ")
    @JsonFormat(pattern = "dd/MM/yyyy@HH:mm")
    private LocalDateTime dataFim;

    private double valorTotal;

    public LocalDateTime getDataInicio() 
    {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) 
    {
            this.dataInicio = dataInicio;
    }

    public LocalDateTime getDataFim() 
    {
        return dataFim;
    }

    public void setDataFim(LocalDateTime dataFim) 
    {
        this.dataFim = dataFim;
    }

    public double getValorTotal() 
    {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) 
    {
        this.valorTotal = valorTotal;
    }

    public Cliente getCliente() 
    {
        return cliente;
    }

    public void setCliente(Cliente cliente) 
    {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() 
    {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) 
    {
        this.veiculo = veiculo;
    }

    public int getNumero() 
    {
        return numero;
    }

    public void setNumero(int numero) 
    {
        this.numero = numero;
    }
    
    
}
