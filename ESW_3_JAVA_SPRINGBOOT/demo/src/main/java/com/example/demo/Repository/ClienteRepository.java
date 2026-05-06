/*  Autor: Caio Felipe Braga de Oliveira
    Data: 06/05/2026
    Entidade: Cliente
*/
package com.example.demo.Repository;

import com.example.demo.Entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByEmail(String email);

    Optional<Cliente> findByDocumento(int documento);

    boolean existsByEmail(String email);

    boolean existsByDocumento(int documento);
}
