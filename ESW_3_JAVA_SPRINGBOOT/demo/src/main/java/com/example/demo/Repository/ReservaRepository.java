/*  Autor: Wellyngton Gabriel Randolfo Ramos
    repositorio: reserva
*/
package com.example.demo.Repository;

import java.util.List;
import com.example.demo.Entities.Reserva;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    List<Reserva> findByStatusreserva(String statusreserva);
}
