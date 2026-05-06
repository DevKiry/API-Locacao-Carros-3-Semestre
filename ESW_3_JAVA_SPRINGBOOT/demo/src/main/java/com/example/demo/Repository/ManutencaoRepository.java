/*
    Autor: Gustavo Shinozaki de Freitas 
*/

package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entities.Manutencao;

public interface ManutencaoRepository extends JpaRepository<Manutencao, Long> {

    List<Manutencao> findByCarroId(Long carroId);

    List<Manutencao> findByStatus(String status);

}
