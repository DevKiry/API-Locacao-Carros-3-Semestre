package com.example.demo.dto.request;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public record CarroRequestDTO(

    @NotBlank(message = "Modelo é obrigatório")
    @Size(max = 100, message = "Modelo deve ter no máximo 100 caracteres")
    String modelo,

    @NotBlank(message = "Marca é obrigatória")
    @Size(max = 100, message = "Marca deve ter no máximo 100 caracteres")
    String marca,

    @NotNull(message = "Ano é obrigatório")
    @Min(value = 1900, message = "Ano inválido")
    @Max(value = 2100, message = "Ano inválido")
    Integer ano,

    @NotBlank(message = "Placa é obrigatória")
    @Pattern(
        regexp = "^[A-Z]{3}[0-9]{4}$|^[A-Z]{3}[0-9][A-Z0-9][0-9]{2}$",
        message = "Placa inválida"
    )
    String placa,

    @NotNull(message = "Preço da diária é obrigatório")
    @DecimalMin(value = "0.0", inclusive = false, message = "Preço deve ser maior que zero")
    @Digits(integer = 10, fraction = 2, message = "Formato de preço inválido")
    BigDecimal precoDiaria
) {}
