/*  Autor: Wellyngton Gabriel Randolfo Ramos
    data transfer object: reserva request
*/
package com.example.demo.DTO.request;

import jakarta.validation.constraints.NotBlank;

public record ReservaeresponseDTO(

    @NotBlank(message = "Data de inicio não pode vir vazia")
    LocalDateTime datainicio,

    @NotBlank(message = "Data do fim não pode vir vazia")
    LocalDateTime datafim,

    @NotBlank(message = "Status não pode vir vazio")
    String statusreserva
){
}