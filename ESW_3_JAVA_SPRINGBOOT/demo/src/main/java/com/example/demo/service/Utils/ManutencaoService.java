/*
    Autor: Gustavo Shinozaki de Freitas
*/

package com.example.demo.service.Utils;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.DTO.request.ManutencaoDTO;
import com.example.demo.DTO.response.ManutencaoresponseDTO;
import com.example.demo.Entities.Carro;
import com.example.demo.Entities.Manutencao;
import com.example.demo.Repository.CarroRepository;
import com.example.demo.Repository.ManutencaoRepository;
import com.example.demo.mapper.ManutencaoMapper;

@Service
public class ManutencaoService {

    private final ManutencaoRepository manutencaoRepository;
    private final CarroRepository carroRepository;

    public ManutencaoService(
        ManutencaoRepository manutencaoRepository,
        CarroRepository carroRepository
    ) {
        this.manutencaoRepository = manutencaoRepository;
        this.carroRepository = carroRepository;
    }

    // Cria manutenção
    public ManutencaoresponseDTO criar(
        ManutencaoDTO dto
    ) {

        Carro carro = carroRepository
                .findById(dto.carroId())
                .orElseThrow();

        Manutencao manutencao =ManutencaoMapper.toEntity(dto, carro);

        manutencao = manutencaoRepository.save(manutencao);

        return ManutencaoMapper.toResponseDTO(manutencao);
    }

    // Lista todas as manutenções
    public List<ManutencaoresponseDTO> listar() {

        return manutencaoRepository.findAll()
                .stream()
                .map(ManutencaoMapper::toResponseDTO)
                .toList();
    }

    // Busca manutenção por id
    public ManutencaoresponseDTO buscarPorId(Long id) {

            Manutencao manutencao = manutencaoRepository
                    .findById(id)
                    .orElseThrow();

            return ManutencaoMapper
                    .toResponseDTO(manutencao);
    }

    // Atualiza o status da manutenção
    public ManutencaoresponseDTO atualizarStatus(

            Long id,
            String status
    ) {

    Manutencao manutencao = manutencaoRepository
            .findById(id)
            .orElseThrow();

    manutencao.setStatus(status);

    manutencao =
            manutencaoRepository.save(manutencao);

    return ManutencaoMapper
            .toResponseDTO(manutencao);
    }

    // Deleta manutenção
    public void deletar(Long id) {

            manutencaoRepository.deleteById(id);
    }
}
