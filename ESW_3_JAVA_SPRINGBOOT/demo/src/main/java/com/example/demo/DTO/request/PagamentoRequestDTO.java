/*
Autor...: João Victor Rantin Silvério
Data....: 06/05/2026
Objetivo: Criar o PagamentoRequestDTO
*/

package com.example.demo.DTO.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PagamentoRequestDTO (
    Long id,

    @NotNull(message = "O valor é obrigatório")
    BigDecimal valor,

    LocalDateTime dataPagamento,

    @NotBlank(message = "O Status é obrigatório")
    String status,

    @NotBlank(message = "A forma de pagamento deve ser obrigatória")
    String formaPagamento
){}
