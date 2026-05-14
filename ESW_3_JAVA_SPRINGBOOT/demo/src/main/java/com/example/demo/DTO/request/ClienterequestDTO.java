/*  Autor: Caio Felipe Braga de Oliveira
    Data: 06/05/2026
    Entidade: Cliente
*/

package com.example.demo.DTO.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ClienterequestDTO(
        @NotBlank(message = "Nome não pode vir vazio")
        String nome,

        @NotBlank(message = "Telefone não pode vir vazio")
        String telefone,

        @NotBlank(message = "Email não pode vir vazio")
        @Email
        String email,

        String endereco,

        @NotBlank(message = "Documento não pode vir vazio")
        int documento
) {
}
