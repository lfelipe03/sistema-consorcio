package com.luizfelipe.sistema_consorcio.controller;

import com.luizfelipe.sistema_consorcio.dto.PlanoDTO;
import com.luizfelipe.sistema_consorcio.model.Plano;
import com.luizfelipe.sistema_consorcio.service.PlanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("planos")
public class PlanoController {

    @Autowired
    private PlanoService planoService;

    @PostMapping
    public ResponseEntity<String> criarPlano(@RequestBody PlanoDTO planoDTO) {
        planoService.criarPlano(planoDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body("Plano criado com sucesso!");
    }

    @GetMapping
    public ResponseEntity<List<PlanoDTO>> listarPlanos() {
        List<PlanoDTO> planos = planoService.listarPlanos();

        return ResponseEntity.ok(planos);
    }

    @PostMapping
    public ResponseEntity<String> criarVariosPlano(@RequestBody List<PlanoDTO> planoDTO) {
        planoService.criarVariosPlanos(planoDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body("Planos criado com sucesso");
    }
}
