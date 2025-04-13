package com.luizfelipe.sistema_consorcio.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numeroGrupo;

    private int limiteCotas;

    private LocalDate dataVencimento;
    private LocalDate dataAssembleia;

    @ManyToOne
    private Administradora administradora;

    @OneToMany(mappedBy = "grupo")
    private List<Cota> cotas = new ArrayList<>();

    @OneToMany(mappedBy = "grupo")
    private List<Contrato> contratos = new ArrayList<>();


    @OneToMany(mappedBy = "grupo")
    private List<Plano> planos = new ArrayList<>();

    public Grupo() {
    }

    public Grupo(int numeroGrupo, int limiteCotas, Long id, LocalDate dataVencimento, LocalDate dataAssembleia, Administradora administradora, List<Cota> cotas, List<Contrato> contratos, List<Plano> planos) {
        this.numeroGrupo = numeroGrupo;
        this.limiteCotas = limiteCotas;
        this.id = id;
        this.dataVencimento = dataVencimento;
        this.dataAssembleia = dataAssembleia;
        this.administradora = administradora;
        this.cotas = cotas;
        this.contratos = contratos;
        this.planos = planos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumeroGrupo() {
        return numeroGrupo;
    }

    public void setNumeroGrupo(int numeroGrupo) {
        this.numeroGrupo = numeroGrupo;
    }

    public List<Cota> getCotas() {
        return cotas;
    }

    public void setCotas(List<Cota> cotas) {
        this.cotas = cotas;
    }

    public int getLimiteCotas() {
        return limiteCotas;
    }

    public void setLimiteCotas(int limiteCotas) {
        this.limiteCotas = limiteCotas;
    }

    public List<Contrato> getContratos() {
        return contratos;
    }

    public void setContratos(List<Contrato> contratos) {
        this.contratos = contratos;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public LocalDate getDataAssembleia() {
        return dataAssembleia;
    }

    public void setDataAssembleia(LocalDate dataAssembleia) {
        this.dataAssembleia = dataAssembleia;
    }

    public Administradora getAdministradora() {
        return administradora;
    }

    public void setAdministradora(Administradora administradora) {
        this.administradora = administradora;
    }

    public List<Plano> getPlanos() {
        return planos;
    }

    public void setPlanos(List<Plano> planos) {
        this.planos = planos;
    }
}
