/*
    Autor: Gustavo Shinozaki de Freitas 
*/

package com.example.demo.DTO.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ManutencaoDTO (

    @NotNull(message = "O ID do carro é obrigatorio")
    Long carroId,

    LocalDateTime dataInicio,

    LocalDateTime dataFim,

    @NotBlank(message = "A descrição é obrigatória")
    String descricao,

    @NotBlank(message = "O Status é obrigatório")
    String status

) {}
