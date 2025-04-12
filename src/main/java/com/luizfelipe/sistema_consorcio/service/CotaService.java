package com.luizfelipe.sistema_consorcio.service;

import com.luizfelipe.sistema_consorcio.enums.StatusCota;
import com.luizfelipe.sistema_consorcio.model.Cota;
import com.luizfelipe.sistema_consorcio.model.Grupo;
import com.luizfelipe.sistema_consorcio.repository.CotaRepository;
import com.luizfelipe.sistema_consorcio.repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CotaService {

    @Autowired
    private CotaRepository cotaRepository;

    @Autowired
    private GrupoRepository grupoRepository;

    public Cota criarCota(Long grupoId) {
        Grupo grupo = grupoRepository.findById(grupoId)
                .orElseThrow(() -> new RuntimeException("Grupo nao encotrado"));

        int numeroCota = gerarNumeroCota(grupo);

        Cota cota = new Cota();
        cota.setNumero(numeroCota);
        cota.setStatus(StatusCota.DISPONIVEL);
        cota.setGrupo(grupo);

        return cotaRepository.save(cota);
    }

    private int gerarNumeroCota(Grupo grupo) {
        int totalCotasNoGrupo = grupo.getCotas().size();
        int limiteCotas = grupo.getLimiteCotas();

        if (totalCotasNoGrupo >= limiteCotas) {
          throw new RuntimeException("Limte de cotas atingido para este grupo");

        }
        return totalCotasNoGrupo + 1;
    }
}
