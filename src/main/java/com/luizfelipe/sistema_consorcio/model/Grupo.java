package com.luizfelipe.sistema_consorcio.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private int limiteCotas;

    @OneToMany(mappedBy = "grupo", cascade = CascadeType.ALL)
    private List<Cota> cotas;

    public Grupo() {
    }

    public Grupo(Long id, String nome, List<Cota> cotas, int limiteCotas) {
        this.id = id;
        this.nome = nome;
        this.cotas = cotas;
        this.limiteCotas = limiteCotas;
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
}
