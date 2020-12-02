package com.example.af_poo.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Reservas 
{
    private int numero;
    private Cliente cliente;
    private Veiculo veiculo;
    @JsonFormat(pattern = "dd/MM/yyyy@HH:mm")
    private LocalDateTime dataInicio;
    @JsonFormat(pattern = "dd/MM/yyyy@HH:mm")
    private LocalDateTime dataFim;
    private double valorTotal;
    
    public int getNumero() 
    {
        return numero;
    }

    public void setNumero(int numero) 
    {
        this.numero = numero;
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
    

}
