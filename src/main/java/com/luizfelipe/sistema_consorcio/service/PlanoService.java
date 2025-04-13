package com.luizfelipe.sistema_consorcio.service;

import com.luizfelipe.sistema_consorcio.dto.PlanoDTO;
import com.luizfelipe.sistema_consorcio.model.Plano;
import com.luizfelipe.sistema_consorcio.repository.PlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

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

        BigDecimal taxaPercentual = planoDTO.taxaDeAdministracao().divide(new BigDecimal(100));
        BigDecimal valorTaxa = planoDTO.valorCartaDeCredito().multiply(taxaPercentual);
        BigDecimal saldoDevedor = planoDTO.valorCartaDeCredito().add(valorTaxa);

        plano.setSaldoDevedor(saldoDevedor);

        return planoRepository.save(plano);
    }

    public List<PlanoDTO> listarPlanos() {
        List<Plano> planos = planoRepository.findAll();

        return planos.stream()
                .map(p -> new PlanoDTO(
                        p.getNome(),
                        p.getValorCartaDeCredito(),
                        p.getValorDeParcela(),
                        p.getTaxaDeAdministracao(),
                        p.getPrazoMeses(),
                        p.getSaldoDevedor()
                )).collect(Collectors.toList());
    }

    public List<Plano> criarVariosPlanos(List<PlanoDTO> planoDTO) {
        List<Plano> planos = planoDTO.stream()
                .map(dto -> {
                    Plano plano = new Plano();
                    plano.setNome(dto.nome());
                    plano.setValorCartaDeCredito(dto.valorCartaDeCredito());
                    plano.setValorDeParcela(dto.valorDeParcela());
                    plano.setPrazoMeses(dto.prazoMeses());
                    plano.setTaxaDeAdministracao(dto.taxaDeAdministracao());

                    BigDecimal taxaPercentual = dto.taxaDeAdministracao().divide(new BigDecimal(100));
                    BigDecimal valorTaxa = dto.valorCartaDeCredito().multiply(taxaPercentual);
                    BigDecimal saldoDevedor = dto.valorCartaDeCredito().add(valorTaxa);

                    plano.setSaldoDevedor(saldoDevedor);

                    return plano;
                })
                .collect(Collectors.toList());

        return planoRepository.saveAll(planos);
    }

}
