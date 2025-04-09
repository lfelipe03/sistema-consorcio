package com.luizfelipe.sistema_consorcio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class Planos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private BigDecimal valorCartaDeCredito;
    private BigDecimal valorDeParcela;
    private Integer prazoMeses;
    private BigDecimal taxaDeAdministracao;

    public Planos() {

    }

    public Planos(Long id, BigDecimal valorCartaDeCredito, String nome, BigDecimal valorDeParcela, Integer prazoMeses, BigDecimal taxaDeAdministracao) {
        this.id = id;
        this.valorCartaDeCredito = valorCartaDeCredito;
        this.nome = nome;
        this.valorDeParcela = valorDeParcela;
        this.prazoMeses = prazoMeses;
        this.taxaDeAdministracao = taxaDeAdministracao;
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
