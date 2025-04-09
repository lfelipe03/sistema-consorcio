package com.luizfelipe.sistema_consorcio.controller;

import com.luizfelipe.sistema_consorcio.dto.AdminstradoraDTO;
import com.luizfelipe.sistema_consorcio.dto.RepresentanteDTO;
import com.luizfelipe.sistema_consorcio.service.AdministradoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("administradora")
public class AdministradoraController {

    @Autowired
    private AdministradoraService administradoraService;

    @PostMapping
    public ResponseEntity<String> cadastroAdministradora(@RequestBody AdminstradoraDTO adminstradoraDTO){
        administradoraService.cadastroAdministradora(adminstradoraDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body("Administradora cadastrada com sucesso!");
    }

    @GetMapping
    public ResponseEntity<List<AdminstradoraDTO>> listarAdministradora() {
        List<AdminstradoraDTO> adminstradora = administradoraService.listarAdministradora();

        return ResponseEntity.ok(adminstradora);
    }

    @PostMapping("cadastrar-representante")
    public ResponseEntity<String> cadastrarRepresentante(@RequestBody RepresentanteDTO representanteDTO) {
        administradoraService.cadastrarRepresentante(representanteDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body("Representante criado com sucesso pela administradora!");
    }

    @GetMapping("listar-representante")
    public ResponseEntity<List<RepresentanteDTO>> listarRepresentante() {
        List<RepresentanteDTO> representante = administradoraService.listarRepresentante();

        return ResponseEntity.ok(representante);
    }

}
