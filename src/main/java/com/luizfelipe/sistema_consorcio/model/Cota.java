package com.luizfelipe.sistema_consorcio.model;
import jakarta.persistence.*;

@Entity
public class Cota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numero;

    private boolean contemplada;

    @ManyToOne
    @JoinColumn(name = "grupo_id")
    private Grupo grupo;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToOne(mappedBy = "cota")
    private Contrato contrato;

    public Cota() {
    }

    public Cota(Long id, int numero, boolean contemplada, Grupo grupo, Cliente cliente, Contrato contrato) {
        this.id = id;
        this.numero = numero;
        this.contemplada = contemplada;
        this.grupo = grupo;
        this.cliente = cliente;
        this.contrato = contrato;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isContemplada() {
        return contemplada;
    }

    public void setContemplada(boolean contemplada) {
        this.contemplada = contemplada;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }
}

