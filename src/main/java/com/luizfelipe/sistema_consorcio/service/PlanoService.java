package com.luizfelipe.sistema_consorcio.service;

import com.luizfelipe.sistema_consorcio.dto.PlanoDTO;
import com.luizfelipe.sistema_consorcio.model.Plano;
import com.luizfelipe.sistema_consorcio.repository.PlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

public class PlanoService {

    @Autowired
    private PlanoRepository planoRepository;

    public Plano criarPlano(PlanoDTO planoDTO) {
        Plano plano = new Plano();

        plano.setNome(planoDTO.nome());
        plano.setValorCartaDeCredito(planoDTO.valorCartaDeCredito());
        plano.setValorDeParcela(planoDTO.valorDeParcela());
        plano.setPrazoMeses(planoDTO.prazoMeses());
        plano.setTaxaDeAdministracao(planoDTO.taxaDeAdministracao());

        BigDecimal saldoDevedor = planoDTO.valorCartaDeCredito().add(planoDTO.taxaDeAdministracao());
        plano.setSaldoDevedor(saldoDevedor);

        return planoRepository.save(plano);
    }

    public List<Plano> listarPlanos() {
        return planoRepository.findAll();
    }


}
