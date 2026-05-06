package com.example.demo.DTO.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ManutencaoDTO {

    private Long carroId;

    private LocalDateTime dataInicio;

    private LocalDateTime dataFim;

    @NotBlank(message = "A descrição é obrigatória")
    private String descricao;

    @NotBlank(message = "O Status é obrigatório")
    private String status;

}
