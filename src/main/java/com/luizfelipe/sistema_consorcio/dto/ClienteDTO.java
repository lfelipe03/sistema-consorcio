package com.luizfelipe.sistema_consorcio.dto;

import com.luizfelipe.sistema_consorcio.model.Endereco;

import java.time.LocalDate;

public record ClienteDTO(
        String nome,
        String cpf,
        String rg,
        String email,
        Endereco endereco,
        String telefone,
        LocalDate dataNascimento,
        Long vendedorId) {
}
