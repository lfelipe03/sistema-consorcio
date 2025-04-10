package com.luizfelipe.sistema_consorcio.model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

import java.util.Date;

public class Contrato {

    private String idContrato;
    private Date dataInicio;
    private Date dataTermino;
    private String status; //
    private int parcelasPagas;
    private double valorTotal;
    private String formaPagamento;
    @ManyToOne
    @JoinColumn(name = "plano_id")
    private Planos plano;

    @ManyToOne
    @JoinColumn(name = "vendedor_id")
    private Vendedor vendedor;

    @ManyToOne
    @JoinColumn(name = "vendedor_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "grupo_id")
    private Grupo grupo;

    @OneToOne
    @JoinColumn(name = "cota_id")
    private Cota cota;

    public Contrato(String idContrato, Cliente cliente, Vendedor vendedor, Planos plano, Date dataInicio, String formaPagamento) {
        this.idContrato = idContrato;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.plano = plano;
        this.dataInicio = dataInicio;
        this.formaPagamento = formaPagamento;
        this.status = "Ativo";
    }

    public Contrato(Cliente cliente, Vendedor vendedor, Planos plano, Date dataInicio, String formaPagamento) {

    }

    public String getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(String idContrato) {
        this.idContrato = idContrato;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Planos getPlano() {
        return plano;
    }

    public void setPlano(Planos plano) {
        this.plano = plano;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getParcelasPagas() {
        return parcelasPagas;
    }

    public void setParcelasPagas(int parcelasPagas) {
        this.parcelasPagas = parcelasPagas;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Cota getCota() {
        return cota;
    }

    public void setCota(Cota cota) {
        this.cota = cota;
    }
}
