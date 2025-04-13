package com.luizfelipe.sistema_consorcio.dto;

import java.math.BigDecimal;

public record PlanoDTO(
        String nome,
        BigDecimal valorCartaDeCredito,
        BigDecimal valorDeParcela,
        BigDecimal taxaDeAdministracao,
        Integer prazoMeses,
        BigDecimal saldoDevedor
) {}
