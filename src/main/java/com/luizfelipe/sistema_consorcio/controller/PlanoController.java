package com.luizfelipe.sistema_consorcio.controller;

import com.luizfelipe.sistema_consorcio.dto.PlanoDTO;
import com.luizfelipe.sistema_consorcio.service.PlanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("planos")
public class PlanoController {

    @Autowired
    private PlanoService planoService;

    @PostMapping
    private ResponseEntity<String> criarPlano(@RequestBody PlanoDTO planoDTO) {
        planoService.criarPlano(planoDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body("Plano criado com sucesso!");
    }
}
