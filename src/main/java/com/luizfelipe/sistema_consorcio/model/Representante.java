package com.luizfelipe.sistema_consorcio.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "representantes")
public class Representante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeRepresentante;
    private String cnpj;
    private String endereco;
    private String email;
    private String telefone;
    private BigDecimal comissaoRepresentante;

    public Representante() {
    }

    public Representante(Long id, String nomeRepresentante, String cnpj, String endereco, String email, String telefone, BigDecimal comissaoRepresentante) {
        this.id = id;
        this.nomeRepresentante = nomeRepresentante;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
        this.comissaoRepresentante = comissaoRepresentante;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeRepresentante() {
        return nomeRepresentante;
    }

    public void setNomeRepresentante(String nomeRepresentante) {
        this.nomeRepresentante = nomeRepresentante;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public BigDecimal getComissaoRepresentante() {
        return comissaoRepresentante;
    }

    public void setComissaoRepresentante(BigDecimal comissaoRepresentante) {
        this.comissaoRepresentante = comissaoRepresentante;
    }
}
