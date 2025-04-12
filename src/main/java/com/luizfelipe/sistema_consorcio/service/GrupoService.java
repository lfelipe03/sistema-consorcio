package com.luizfelipe.sistema_consorcio.service;

import com.luizfelipe.sistema_consorcio.model.Administradora;
import com.luizfelipe.sistema_consorcio.model.Grupo;
import com.luizfelipe.sistema_consorcio.repository.AdministradoraRepository;
import com.luizfelipe.sistema_consorcio.repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

public class GrupoService {

    @Autowired
    private GrupoRepository grupoRepository;

    @Autowired
    private AdministradoraRepository administradoraRepository;

    public Grupo criarGrupo(Long administradoraId, int numeroGrupo, int limiteCotas, LocalDate dataVencimento, LocalDate dataAssembleia) {
        Administradora administradora = administradoraRepository.findById(administradoraId)
                .orElseThrow(() -> new RuntimeException("Administradora nao encontrada"));

        Grupo grupo = new Grupo();
        grupo.setNumeroGrupo(numeroGrupo);
        grupo.setLimiteCotas(limiteCotas);
        grupo.setDataVencimento(dataVencimento);
        grupo.setDataAssembleia(dataAssembleia);
        grupo.setAdministradora(administradora);

        return grupoRepository.save(grupo);


    }

    public List<Grupo> listarGrupos() {
        return grupoRepository.findAll();
    }
}
