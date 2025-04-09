package com.luizfelipe.sistema_consorcio.service;

import com.luizfelipe.sistema_consorcio.dto.AdminstradoraDTO;
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
public class AdministradoraService {

    @Autowired
    AdministradoraRepository administradoraRepository;

    @Autowired
    RepresentanteService representanteService;

    @Autowired
    RepresentanteRepository representanteRepository;

    public void cadastroAdministradora(AdminstradoraDTO dto) {
        Administradora administradora = new Administradora();

        administradora.setNomeAdministradora(dto.nomeAdministradora());
        administradora.setCnpj(dto.cnpj());
        administradora.setTelefone(dto.telefone());
        administradora.setEndereco(dto.endereco());
        administradora.setEmail(dto.email());

        administradoraRepository.save(administradora);

    }

    public List<AdminstradoraDTO> listarAdministradora() {
        List<Administradora> administradoras = administradoraRepository.findAll();

        return administradoras.stream()
                .map(a -> new AdminstradoraDTO(
                        a.getNomeAdministradora(),
                        a.getCnpj(),
                        a.getEndereco(),
                        a.getEmail(),
                        a.getTelefone()
                )).collect(Collectors.toList());
    }

    public void cadastrarRepresentante(RepresentanteDTO dto) {
        representanteService.salvarRepresentante(dto);
    }

    public List<RepresentanteDTO> listarRepresentante() {
        List<Representante> representantes = representanteRepository.findAll();

        return representantes.stream()
                .map(r -> new RepresentanteDTO(
                        r.getNomeRepresentante(),
                        r.getCnpj(),
                        r.getEndereco(),
                        r.getEmail(),
                        r.getTelefone()
                )).collect(Collectors.toList());
    }


}
