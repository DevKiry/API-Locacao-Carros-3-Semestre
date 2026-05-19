/*
    Autor: GUstavo Shinozaki de Freitas
*/

package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.request.ManutencaoDTO;
import com.example.demo.DTO.response.ManutencaoresponseDTO;
import com.example.demo.service.Utils.ManutencaoService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/manutencoes")
public class ManutencaoController {

    private final ManutencaoService manutencaoService;

    public ManutencaoController(
            ManutencaoService manutencaoService
    ) {
        this.manutencaoService = manutencaoService;
    }

    // Cria
    @PostMapping
    public ManutencaoresponseDTO criar(
            @RequestBody ManutencaoDTO dto
    ) {
        return manutencaoService.criar(dto);
    }

    // Lista
    @GetMapping
    public List<ManutencaoresponseDTO> listar() {
        return manutencaoService.listar();
    }

    // Busca por id
    @GetMapping("/{id}")
    public ManutencaoresponseDTO buscarPorId(
            @PathVariable Long id
    ) {
        return manutencaoService.buscarPorId(id);
    }

    // Atualiza status
    @PatchMapping("/{id}/status")
    public ManutencaoresponseDTO atualizarStatus(

        @PathVariable Long id,
        @RequestBody String status

    ) {
        return manutencaoService.atualizarStatus(id, status);
    }

    // Deleta
    @DeleteMapping("/{id}")
    public void deletar(
            @PathVariable Long id
    ) {
        manutencaoService.deletar(id);
    }
}