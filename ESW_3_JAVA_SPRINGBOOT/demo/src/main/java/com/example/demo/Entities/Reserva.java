/*  Autor: Wellyngton Gabriel Randolfo Ramos
    entidade: reserva
*/
package com.example.demo.Entities;

import java.time.LocalDateTime;
import lombok.*;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "tb_reserva")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id_reserva;

    @Column(nullable = false)
    private LocalDateTime datainicio;

    @Column(nullable = false)
    private LocalDateTime datafim;

    @Column(nullable = false)
    private String statusreserva;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false, foreignKey = @ForeignKey(name = "clientesomething"))
    private Cliente cliente;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carro_id", nullable = false, foreignKey = @ForeignKey(name = "carrosomething"))
    private Carro carro;
    
}
