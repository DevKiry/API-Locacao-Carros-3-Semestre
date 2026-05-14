/*
    Autor: Juan Felipe Araujo Da Silva
*/
package com.example.demo.mapper;

import com.example.demo.DTO.request.CarroRequestDTO;
import com.example.demo.DTO.response.CarroResponseDTO;
import com.example.demo.Entities.Carro;

public class CarroMapper {

    public static Carro toEntity(CarroRequestDTO dto) {
        Carro carro = new Carro();

        carro.setModelo(dto.modelo());
        carro.setMarca(dto.marca());
        carro.setAno(dto.ano());
        carro.setPlaca(dto.placa());
        carro.setPrecoDiaria(dto.precoDiaria());
        carro.setDisponivel(true);

        return carro;
    }

    public static CarroResponseDTO toResponse(Carro carro) {
        return new CarroResponseDTO(
            carro.getId(),
            carro.getModelo(),
            carro.getMarca(),
            carro.getAno(),
            carro.getPlaca(),
            carro.getDisponivel(),
            carro.getPrecoDiaria()
        );
    }

    public static void updateEntity(Carro carro, CarroRequestDTO dto) {
        carro.setModelo(dto.modelo());
        carro.setMarca(dto.marca());
        carro.setAno(dto.ano());
        carro.setPlaca(dto.placa());
        carro.setPrecoDiaria(dto.precoDiaria());
    }
}