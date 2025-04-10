package com.luizfelipe.sistema_consorcio.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numeroGrupo;

    private int limiteCotas;

    @OneToMany(mappedBy = "grupo")
    private List<Cota> cotas = new ArrayList<>();

    @OneToMany(mappedBy = "grupo")
    private List<Contrato> contratos = new ArrayList<>();

    public Grupo() {
    }

    public Grupo(Long id, int numeroGrupo, List<Cota> cotas, int limiteCotas) {
        this.id = id;
        this.numeroGrupo = numeroGrupo;
        this.cotas = cotas;
        this.limiteCotas = limiteCotas;
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
}
