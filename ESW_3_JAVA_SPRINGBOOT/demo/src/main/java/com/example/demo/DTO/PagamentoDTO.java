package com.example.demo.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class PagamentoDTO {
    private Long id;

    @NotNull(message = "O valor é obrigatório")
    private BigDecimal valor;

    private LocalDateTime dataPagamento;

    @NotBlank(message = "O Status é obrigatório")
    private String status;

    @NotBlank(message = "A forma de pagamento deve ser obrigatória")
    private String formaPagamento;
}
