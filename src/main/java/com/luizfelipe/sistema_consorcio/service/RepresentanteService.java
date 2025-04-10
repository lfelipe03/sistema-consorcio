package com.luizfelipe.sistema_consorcio.service;

import com.luizfelipe.sistema_consorcio.dto.RepresentanteDTO;
import com.luizfelipe.sistema_consorcio.model.Administradora;
import com.luizfelipe.sistema_consorcio.model.Representante;
import com.luizfelipe.sistema_consorcio.repository.AdministradoraRepository;
import com.luizfelipe.sistema_consorcio.repository.RepresentanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class RepresentanteService {

    @Autowired
    private RepresentanteRepository representanteRepository;

   @Autowired
   private AdministradoraRepository  administradoraRepository;

    public void cadastrarRepresentante(RepresentanteDTO dto) {
        Representante representante = new Representante();

        Administradora administradora = administradoraRepository.findById(dto.administradoraId())
                .orElseThrow(() -> new RuntimeException("Administradora nao encontrada"));

        representante.setNomeRepresentante(dto.nomeRepresentante());
        representante.setCnpj(dto.cnpj());
        representante.setEndereco(dto.endereco());
        representante.setEmail(dto.email());
        representante.setTelefone(dto.telefone());

        representante.setAdministradora(administradora);

        representanteRepository.save(representante);
    }

    public List<RepresentanteDTO> listarRepresentante() {
        List<Representante> representantes = representanteRepository.findAll();

        return representantes.stream()
                .map(r -> new RepresentanteDTO(
                        r.getNomeRepresentante(),
                        r.getCnpj(),
                        r.getEndereco(),
                        r.getEmail(),
                        r.getTelefone(),
                        r.getAdministradora().getId()
                )).collect(Collectors.toList());


    }

}
