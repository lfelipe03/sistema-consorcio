package com.luizfelipe.sistema_consorcio.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class Endereco implements Serializable {
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;

    public String getRua() {
        return rua;
    }

    public String getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getCep() {
        return cep;
    }

    public String getEstado() {
        return estado;
    }
}
