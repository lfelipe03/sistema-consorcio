package com.luizfelipe.sistema_consorcio.service;

import com.luizfelipe.sistema_consorcio.dto.RepresentanteDTO;
import com.luizfelipe.sistema_consorcio.model.Representante;
import com.luizfelipe.sistema_consorcio.repository.RepresentanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class RepresentanteService {

    @Autowired
    private RepresentanteRepository repository;

    protected void salvarRepresentante(RepresentanteDTO dto) {
        Representante representante = new Representante();

        representante.setNomeRepresentante(dto.nomeRepresentante());
        representante.setCnpj(dto.cnpj());
        representante.setEndereco(dto.endereco());
        representante.setEmail(dto.email());
        representante.setTelefone(dto.telefone());
    }


}
