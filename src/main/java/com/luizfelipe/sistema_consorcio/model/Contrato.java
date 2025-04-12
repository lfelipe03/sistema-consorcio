package com.luizfelipe.sistema_consorcio.model;

import com.luizfelipe.sistema_consorcio.enums.StatusContrato;
import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class Contrato {

    private String idContrato;
    private LocalDate dataInicio;
    private LocalDate dataTermino;
    @Enumerated(EnumType.STRING)
    private StatusContrato status;
    private int parcelasPagas;
    private double valorTotal;
    private String formaPagamento;
    @ManyToOne
    @JoinColumn(name = "plano_id")
    private Plano plano;

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

    private BigDecimal saldoDevedor;

    public Contrato(Long grupoId) {
    }

    public Contrato(String idContrato, LocalDate dataInicio, LocalDate dataTermino, StatusContrato status, int parcelasPagas, double valorTotal, String formaPagamento, Plano plano, Vendedor vendedor, Grupo grupo, Cota cota, Cliente cliente) {
        this.idContrato = idContrato;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.status = status;
        this.parcelasPagas = parcelasPagas;
        this.valorTotal = valorTotal;
        this.formaPagamento = formaPagamento;
        this.plano = plano;
        this.vendedor = vendedor;
        this.grupo = grupo;
        this.cota = cota;
        this.cliente = cliente;
    }

    public BigDecimal getSaldoDevedor() {
        return saldoDevedor;
    }

    public void setSaldoDevedor(BigDecimal saldoDevedor) {
        this.saldoDevedor = saldoDevedor;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDate dataTermino) {
        this.dataTermino = dataTermino;
    }

    public StatusContrato getStatus() {
        return status;
    }

    public void setStatus(StatusContrato status) {
        this.status = status;
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

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
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
