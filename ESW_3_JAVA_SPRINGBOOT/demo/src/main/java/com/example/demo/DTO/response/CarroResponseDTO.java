package com.example.demo.DTO.response;

import java.math.BigDecimal;

public record CarroResponseDTO(

    Long id,
    String modelo,
    String marca,
    Integer ano,
    String placa,
    Boolean disponivel,
    BigDecimal precoDiaria
) {}
