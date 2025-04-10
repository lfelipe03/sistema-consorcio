package com.luizfelipe.sistema_consorcio.controller;

import com.luizfelipe.sistema_consorcio.dto.VendedorDTO;
import com.luizfelipe.sistema_consorcio.model.Vendedor;
import com.luizfelipe.sistema_consorcio.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("vendedor")
public class VendedorController {

    @Autowired
    private VendedorService vendedorService;

    @PostMapping
    public ResponseEntity<String> cadastrarVendedor(@RequestBody VendedorDTO vendedorDTO) {
        vendedorService.cadastrarVendedor(vendedorDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body("Vendedor cadastrado com sucesso");
    }

    @GetMapping
    public ResponseEntity<List<VendedorDTO>> listarVendedor() {
        List<VendedorDTO> vendedores = vendedorService.listarVendedores();

        return ResponseEntity.ok(vendedores);
    }

}
