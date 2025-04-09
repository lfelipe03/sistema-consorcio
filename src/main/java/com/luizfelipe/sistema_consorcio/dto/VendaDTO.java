package com.luizfelipe.sistema_consorcio.dto;

import java.math.BigDecimal;

public record VendaDTO(Long clienteId,
                       Long vendedorId,
                       Long planoId,
                       BigDecimal valorTotal,
                       String formaPagamento) {
}
