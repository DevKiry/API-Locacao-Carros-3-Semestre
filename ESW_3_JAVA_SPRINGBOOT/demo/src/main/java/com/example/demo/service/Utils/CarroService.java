/*
    Autor: Juan Felipe Araujo Da Silva
*/
package com.example.demo.service;

import com.example.demo.DTO.request.CarroRequestDTO;
import com.example.demo.DTO.response.CarroResponseDTO;
import com.example.demo.Entities.Carro;
import com.example.demo.Repository.CarroRepository;
import com.example.demo.mapper.CarroMapper;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarroService {

    private final CarroRepository repository;

    public CarroResponseDTO criar(CarroRequestDTO dto) {

        if (repository.existsByPlaca(dto.placa())) {
            throw new RuntimeException("Placa já cadastrada");
        }

        Carro carro = CarroMapper.toEntity(dto);

        return CarroMapper.toResponse(repository.save(carro));
    }

    public List<CarroResponseDTO> listarTodos() {

        return repository.findAll()
                .stream()
                .map(CarroMapper::toResponse)
                .collect(Collectors.toList());
    }

    public CarroResponseDTO buscarPorId(Long id) {

        Carro carro = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carro não encontrado"));

        return CarroMapper.toResponse(carro);
    }

    public CarroResponseDTO atualizar(Long id, CarroRequestDTO dto) {

        Carro carro = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carro não encontrado"));

        CarroMapper.updateEntity(carro, dto);

        return CarroMapper.toResponse(repository.save(carro));
    }

    public void deletar(Long id) {

        if (!repository.existsById(id)) {
            throw new RuntimeException("Carro não encontrado");
        }

        repository.deleteById(id);
    }

    public List<CarroResponseDTO> listarDisponiveis() {

        return repository.findByDisponivelTrue()
                .stream()
                .map(CarroMapper::toResponse)
                .collect(Collectors.toList());
    }
}