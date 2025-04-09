package com.luizfelipe.sistema_consorcio.dto;

public record RepresentanteDTO(
        String nomeRepresentante,
        String cnpj,
        String endereco,
        String telefone,
        String email
) {}
