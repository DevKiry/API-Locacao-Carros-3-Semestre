/*
    Autor: Caio Felipe Braga de Oliveira
    Data: 06/05/2026
    Mapper: Cliente
*/
package com.example.demo.mapper;

import com.example.demo.DTO.request.ClienterequestDTO;
import com.example.demo.DTO.response.ClienteresponseDTO;
import com.example.demo.Entities.Cliente;

public class ClienteMapper {

    public static Cliente toEntity(ClienterequestDTO dto) {
        Cliente cliente = new Cliente();

        cliente.setNome(dto.nome());
        cliente.setEmail(dto.email());
        cliente.setTelefone(dto.telefone());
        cliente.setEndereco(dto.endereco());
        cliente.setDocumento(dto.documento());

        return cliente;
    }

    public static ClienteresponseDTO toResponse(Cliente cliente) {
        return new ClienteresponseDTO(
                cliente.getId(),
                cliente.getNome(),
                cliente.getEmail(),
                cliente.getTelefone(),
                cliente.getEndereco(),
                cliente.getDocumento()
        );
    }

    public static void updateEntity(Cliente cliente, ClienterequestDTO dto) {
        cliente.setNome(dto.nome());
        cliente.setEmail(dto.email());
        cliente.setTelefone(dto.telefone());
        cliente.setEndereco(dto.endereco());
        cliente.setDocumento(dto.documento());
    }
}
