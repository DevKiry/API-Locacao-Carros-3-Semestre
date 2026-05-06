/*  Autor: Wellyngton Gabriel Randolfo Ramos
    data transfer object: reserva response
*/
package com.example.demo.DTO.response;

import java.time.LocalDateTime;

public record ReservaeresponseDTO(
    Long id_reserva,
    LocalDateTime datainicio,
    LocalDateTime datafim,
    String statusreserva
){
}
