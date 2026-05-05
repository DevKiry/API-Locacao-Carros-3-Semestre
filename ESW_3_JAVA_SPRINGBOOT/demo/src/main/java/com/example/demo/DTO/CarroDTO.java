package com.example.demo.DTO;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CarroDTO {

    private Long id;

    @NotBlank(message = "O modelo é obrigatório")
    private String modelo;

    @NotBlank(message = "A marca é obrigatória")
    private String marca;

    @NotNull(message = "O ano é obrigatório")
    @Min(value = 1900, message = "Ano inválido")
    @Max(value = 2100, message = "Ano inválido")
    private Integer ano;

    @NotBlank(message = "A placa é obrigatória")
    @Pattern(
        regexp = "[A-Z]{3}[0-9][A-Z0-9][0-9]{2}",
        message = "Placa inválida"
    )
    private String placa;

    private Boolean disponivel = true;

    @NotNull(message = "O preço da diária é obrigatório")
    @DecimalMin(value = "0.0", inclusive = false, message = "Preço deve ser maior que zero")
    private BigDecimal precoDiaria;
}