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


}

