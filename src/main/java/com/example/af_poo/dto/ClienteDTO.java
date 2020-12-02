package com.example.af_poo.dto;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

public class ClienteDTO 
{
    @NotBlank(message = "Insira Nome:")
    @Length(min=3, max=20)
    private String nome;
    @NotBlank(message = "Insira CPF:")
    @Length(min=11, max=11)
    private String cpf;
    @NotBlank(message = "Insira Endereço:")
    @Length(min=5, max=100)
    private String endereco;

    public String getNome() 
    {
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    public String getCpf() 
    {
        return cpf;
    }

    public void setCpf(String cpf) 
    {
        this.cpf = cpf;
    }

    public String getEndereco() 
    {
        return endereco;
    }

    public void setEndereco(String endereco) 
    {
        this.endereco = endereco;
    }
    
}
