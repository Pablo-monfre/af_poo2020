package com.example.af_poo.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Cliente 
{
    private int id;
    private String nome;
    private String endereco;
    private String cpf;

    @JsonIgnore
    private ArrayList<Reservas> reservas = new ArrayList<Reservas>();


    public int getId() 
    {
        return id;
    }

    public void setId(int id) 
    {
        this.id = id;
    }

    public String getNome() 
    {
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    public String getEndereco() 
    {
        return endereco;
    }

    public void setEndereco(String endereco) 
    {
        this.endereco = endereco;
    }

    public String getCpf() 
    {
        return cpf;
    }

    public void setCpf(String cpf) 
    {
        this.cpf = cpf;
    }

    public ArrayList<Reservas> getReservas() 
    {
        return reservas;
    }

    public void setReservas(ArrayList<Reservas> reservas) 
    {
        this.reservas = reservas;
    }

    public boolean addReserva(Reservas reserva)
    {
        return reservas.add(reserva);
    }

    public boolean removeReserva(Reservas reserva) 
    {
        return reservas.remove(reserva);
    }

    
}
