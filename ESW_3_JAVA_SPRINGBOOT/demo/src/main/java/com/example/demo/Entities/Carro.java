package com.example.demo.Entities;
import jakarta.persistence.*;


@Entity
@Table(name = "carros")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false)
    private Integer ano;

    @Column(nullable = false, unique = true)
    private String placa;

    @Column(nullable = false)
    private Boolean disponivel;

    @Column(nullable = false)
    private float precoDiaria;

    public Carro() {}

    public Carro(String modelo, String marca, Integer ano, String placa,
                 Boolean disponivel, float precoDiaria) {
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.placa = placa;
        this.disponivel = disponivel;
        this.precoDiaria = precoDiaria;
    }

    // Getters e Setters
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

    public float getPrecoDiaria() { return precoDiaria; }
    public void setPrecoDiaria(float precoDiaria) { this.precoDiaria = precoDiaria; }
}