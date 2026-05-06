package com.example.demo.DTO.response;

public record ClienteresponseDTO(
    Long id,
    String nome,
    String telefone,
    String email,
    String endereco,
    int documento
) {
}
