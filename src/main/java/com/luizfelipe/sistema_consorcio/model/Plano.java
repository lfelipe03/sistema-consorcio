package com.luizfelipe.sistema_consorcio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class Plano {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private BigDecimal valorCartaDeCredito;
    private BigDecimal valorDeParcela;
    private Integer prazoMeses;
    private BigDecimal taxaDeAdministracao;
    private BigDecimal saldoDevedor;

    public Plano() {

    }


    public Plano(Long id, String nome, BigDecimal valorCartaDeCredito, BigDecimal valorDeParcela, Integer prazoMeses, BigDecimal saldoDevedor, BigDecimal taxaDeAdministracao) {
        this.id = id;
        this.nome = nome;
        this.valorCartaDeCredito = valorCartaDeCredito;
        this.valorDeParcela = valorDeParcela;
        this.prazoMeses = prazoMeses;
        this.saldoDevedor = saldoDevedor;
        this.taxaDeAdministracao = taxaDeAdministracao;
    }

    public BigDecimal getSaldoDevedor() {
        return saldoDevedor;
    }

    public void setSaldoDevedor(BigDecimal saldoDevedor) {
        this.saldoDevedor = saldoDevedor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValorCartaDeCredito() {
        return valorCartaDeCredito;
    }

    public void setValorCartaDeCredito(BigDecimal valorCartaDeCredito) {
        this.valorCartaDeCredito = valorCartaDeCredito;
    }

    public BigDecimal getValorDeParcela() {
        return valorDeParcela;
    }

    public void setValorDeParcela(BigDecimal valorDeParcela) {
        this.valorDeParcela = valorDeParcela;
    }

    public Integer getPrazoMeses() {
        return prazoMeses;
    }

    public void setPrazoMeses(Integer prazoMeses) {
        this.prazoMeses = prazoMeses;
    }

    public BigDecimal getTaxaDeAdministracao() {
        return taxaDeAdministracao;
    }

    public void setTaxaDeAdministracao(BigDecimal taxaDeAdministracao) {
        this.taxaDeAdministracao = taxaDeAdministracao;
    }
}
