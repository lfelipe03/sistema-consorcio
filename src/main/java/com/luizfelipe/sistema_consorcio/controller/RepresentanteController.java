package com.luizfelipe.sistema_consorcio.controller;

import com.luizfelipe.sistema_consorcio.dto.RepresentanteDTO;
import com.luizfelipe.sistema_consorcio.service.RepresentanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("representantes")
public class RepresentanteController {

    @Autowired
    private RepresentanteService representanteService;

    @PostMapping
    public ResponseEntity<String> cadastrarRepresentante(@RequestBody RepresentanteDTO representanteDTO) {
        representanteService.cadastrarRepresentante(representanteDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body("Representante cadastrado com sucesso!");
    }

    @GetMapping
    public ResponseEntity<List<RepresentanteDTO>> listarRepresentante() {
        List<RepresentanteDTO> representanteDTO = representanteService.listarRepresentante();

        return ResponseEntity.ok(representanteDTO);
    }

}
