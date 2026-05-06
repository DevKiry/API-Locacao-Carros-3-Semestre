/*
autor: Arthur Broleze Silvestrini
 */

package com.example.demo.Repository;

import com.example.demo.Entities.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {

    // Retorna todos os carros disponíveis para locação
    List<Carro> findByDisponivelTrue();

    // Busca carro pela placa (deve ser única)
    Optional<Carro> findByPlaca(String placa);

    // Verifica se já existe um carro com a placa informada
    boolean existsByPlaca(String placa);

    // Retorna carros por marca
    List<Carro> findByMarcaIgnoreCase(String marca);

    // Retorna carros disponíveis de uma marca específica
    List<Carro> findByMarcaIgnoreCaseAndDisponivelTrue(String marca);
}