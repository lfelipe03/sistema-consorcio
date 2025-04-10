package com.luizfelipe.sistema_consorcio.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Administradora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeAdministradora;
    private String cnpj;
    private String endereco;
    private String email;
    private String telefone;
    private BigDecimal comissaoAdministradora;

    @OneToMany(mappedBy = "administradora")
    private List<Representante> representantes = new ArrayList<>();


    public Administradora() {
    }

    public Administradora(Long id, String nomeAdministradora, String cnpj, String endereco, String email, String telefone, BigDecimal comissaoAdministradora) {
        this.id = id;
        this.nomeAdministradora = nomeAdministradora;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
        this.comissaoAdministradora = comissaoAdministradora;
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

    public String getNomeAdministradora() {
        return nomeAdministradora;
    }

    public void setNomeAdministradora(String nomeAdministradora) {
        this.nomeAdministradora = nomeAdministradora;
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

    public BigDecimal getComissaoAdministradora() {
        return comissaoAdministradora;
    }

    public void setComissaoAdministradora(BigDecimal comissaoAdministradora) {
        this.comissaoAdministradora = comissaoAdministradora;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Representante> getRepresentantes() {
        return representantes;
    }

    public void setRepresentantes(List<Representante> representantes) {
        this.representantes = representantes;
    }
}
