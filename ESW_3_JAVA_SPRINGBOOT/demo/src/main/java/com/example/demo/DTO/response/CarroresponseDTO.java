package com.example.demo.DTO.response;


import com.example.demo.Entities.Carro;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class CarroResponseDTO {

    private Long id;
    private String modelo;
    private String marca;
    private Integer ano;
    private String placa;
    private Boolean disponivel;
    private Float precoDiaria;

    public CarroResponseDTO(Carro carro) {
        this.id = carro.getId();
        this.modelo = carro.getModelo();
        this.marca = carro.getMarca();
        this.ano = carro.getAno();
        this.placa = carro.getPlaca();
        this.disponivel = carro.getDisponivel();
        this.precoDiaria = carro.getPrecoDiaria();
    }
}