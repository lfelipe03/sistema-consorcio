package com.luizfelipe.sistema_consorcio.dto;

import com.luizfelipe.sistema_consorcio.model.Endereco;

public record ClienteDTO(
                         String nome,
                         String cpf,
                         String rg,
                         String email,
                         Endereco endereco,
                         String telefone) {
}
