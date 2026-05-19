/*
    Autor: Gustavo Shinozaki de Freitas
*/

package com.example.demo.mapper;

import com.example.demo.DTO.request.ManutencaoDTO;
import com.example.demo.DTO.response.ManutencaoresponseDTO;
import com.example.demo.Entities.Carro;
import com.example.demo.Entities.Manutencao;

public class ManutencaoMapper {

    public static Manutencao toEntity(
            ManutencaoDTO dto,
            Carro carro
    ) {

        Manutencao manutencao = new Manutencao();

        manutencao.setCarro(carro);
        manutencao.setDataInicio(dto.dataInicio());
        manutencao.setDataFim(dto.dataFim());
        manutencao.setDescricao(dto.descricao());
        manutencao.setStatus(dto.status());

        return manutencao;
    }

    public static ManutencaoresponseDTO toResponseDTO(
            Manutencao manutencao
    ) {

        return new ManutencaoresponseDTO(

                manutencao.getId(),
                manutencao.getCarro().getId(),
                manutencao.getDataInicio(),
                manutencao.getDataFim(),
                manutencao.getDescricao(),
                manutencao.getStatus()

        );
    }
}