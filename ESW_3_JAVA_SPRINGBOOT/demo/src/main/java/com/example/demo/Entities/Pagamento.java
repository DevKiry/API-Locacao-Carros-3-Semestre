/*
Autor...: João Victor Rantin Silvério
Data....: 06/05/2026
Objetivo: Criar a entidade Pagamento
*/

package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_pagamento")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) //Coluna não pode ser NULL
    private BigDecimal valor;

    @CreationTimestamp
    @Column(nullable = false, updatable = false) //Coluna não pode ser NULL e não pode ser alterada depois de criado
    private LocalDateTime dataPagamento;

    @Column(nullable = false) //Coluna não pode ser NULL
    private String status = "PENDENTE";

    @Column(nullable = false) //Coluna não pode ser NULL
    private String formaPagamento;

    @ManyToOne
    @JoinColumn(name = "reserva_id", nullable = false)
    private Reserva reserva;
}
