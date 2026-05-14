/*
    Autor: Gustavo Shinozaki de Freitas 
*/

package com.example.demo.DTO.response;

import java.time.LocalDateTime;

public record ManutencaoresponseDTO(
    
    Long id,
    Long carroId,
    LocalDateTime dataInicio,
    LocalDateTime dataFim,
    String descricao,
    String status
) {}
