package com.example.af_poo.model;

import java.time.LocalDateTime;

public class Reservas 
{
    private int numero;
    private Cliente cliente;
    private Veiculo veiculo;
    private LocalDateTime dataInicio;
    private boolean dataFim;
   // private double totalReserva;
    
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

    public boolean isDataFim() 
    {
        return dataFim;
    }

    public void setDataFim(boolean dataFim) 
    {
        this.dataFim = dataFim;
    }
    

}
