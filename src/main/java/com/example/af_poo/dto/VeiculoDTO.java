package com.example.af_poo.dto;

import java.util.ArrayList;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import com.example.af_poo.model.Reservas;

import org.hibernate.validator.constraints.Length;

public class VeiculoDTO 
{
    @NotBlank(message = "Insira modelo do veiculo")
    @Length(min=3, max=30)
    private String modelo;
    @Positive
    private float valorDiaria;
    
    private ArrayList<Reservas> reservas = new ArrayList<Reservas>();

    public String getModelo() 
    {
        return modelo;
    }

    public void setModelo(String modelo) 
    {
        this.modelo = modelo;
    }

    public float getValorDiaria() 
    {
        return valorDiaria;
    }

    public void setValorDiaria(float valorDiaria) 
    {
        this.valorDiaria = valorDiaria;
    }

    public ArrayList<Reservas> getReservas() 
    {
        return reservas;
    }

    public void setReservas(ArrayList<Reservas> reservas) 
    {
        this.reservas = reservas;
    }
    
}
