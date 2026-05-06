package com.example.demo.DTO.response;


import com.example.demo.Entities.Carro;
import java.math.BigDecimal;

public class CarroresponseDTO {

    private Long id;
    private String modelo;
    private String marca;
    private Integer ano;
    private String placa;
    private Boolean disponivel;
    private BigDecimal precoDiaria;

    public CarroresponseDTO() {}

    public CarroresponseDTO(Carro carro) {
        this.id = carro.getId();
        this.modelo = carro.getModelo();
        this.marca = carro.getMarca();
        this.ano = carro.getAno();
        this.placa = carro.getPlaca();
        this.disponivel = carro.getDisponivel();
        this.precoDiaria = carro.getPrecoDiaria();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public Integer getAno() { return ano; }
    public void setAno(Integer ano) { this.ano = ano; }

    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }

    public Boolean getDisponivel() { return disponivel; }
    public void setDisponivel(Boolean disponivel) { this.disponivel = disponivel; }

    public BigDecimal getPrecoDiaria() { return precoDiaria; }
    public void setPrecoDiaria(BigDecimal precoDiaria) { this.precoDiaria = precoDiaria; }
}
