package com.luizfelipe.sistema_consorcio.service;

import com.luizfelipe.sistema_consorcio.enums.StatusContrato;
import com.luizfelipe.sistema_consorcio.model.*;
import com.luizfelipe.sistema_consorcio.repository.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

public class ContratoService {

    @Autowired
    private ContratoRepository contratoRepository;

    @Autowired
    private CotaRepository cotaRepository;

    @Autowired
    private CotaService cotaService;

    @Autowired
    private PlanoRepository planoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private GrupoRepository grupoRepository;

    public Contrato criarContrato(Long clienteId, Long planoId, Long grupoId) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Plano plano = planoRepository.findById(planoId)
                .orElseThrow(() -> new RuntimeException("Plano não encontrado"));

        Grupo grupo = grupoRepository.findById(grupoId)
                .orElseThrow(() -> new RuntimeException("Grupo não encontrado"));

        Cota cota = cotaService.criarCota(grupoId);

        Contrato contrato = new Contrato(grupoId);
        contrato.setCliente(cliente);
        contrato.setCota(cota);
        contrato.setGrupo(grupo);
        contrato.setPlano(plano);

        contrato.setDataInicio(LocalDate.now());
        contrato.setDataTermino(LocalDate.now().plusMonths(plano.getPrazoMeses()));

        contrato.setStatus(StatusContrato.ATIVO);
        return contratoRepository.save(contrato);
    }
}
