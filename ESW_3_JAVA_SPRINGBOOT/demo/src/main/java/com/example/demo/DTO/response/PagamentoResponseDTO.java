/*
Autor...: João Victor Rantin Silvério
Data....: 06/05/2026
Objetivo: Criar o PagamentoResponseDTO
*/
package com.example.demo.DTO.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PagamentoResponseDTO (
    Long id,
    BigDecimal valor,
    LocalDateTime dataPagamento,
    String status,
    String formaPagamento
){}
