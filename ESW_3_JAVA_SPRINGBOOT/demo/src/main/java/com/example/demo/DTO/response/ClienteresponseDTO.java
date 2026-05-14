/*  Autor: Caio Felipe Braga de Oliveira
    Data: 06/05/2026
    Entidade: Cliente
*/
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
