package com.example.af_poo.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Veiculo 
{
    private int id;
    private String modelo;
    private Float valorDiaria;

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

    public boolean addReserva(Reservas reserva)
    {
        return reservas.add(reserva);
    }

    public boolean removeReserva(Reservas reserva) 
    {
        return reservas.remove(reserva);
    }

    
}
