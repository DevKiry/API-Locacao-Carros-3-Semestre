/*
    Autor: Caio Felipe Braga de Oliveira
    Data: 06/05/2026
    Controller: Cliente
*/
package com.example.demo.controller;

import com.example.demo.DTO.request.ClienterequestDTO;
import com.example.demo.DTO.response.ClienteresponseDTO;
import com.example.demo.service.Utils.ClienteService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<ClienteresponseDTO> criar(@RequestBody ClienterequestDTO dto) {
        ClienteresponseDTO response = clienteService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<ClienteresponseDTO>> listarTodos() {
        List<ClienteresponseDTO> clientes = clienteService.listarTodos();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteresponseDTO> buscarPorId(@PathVariable Long id) {
        ClienteresponseDTO cliente = clienteService.buscarPorId(id);
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteresponseDTO> atualizar(
            @PathVariable Long id,
            @RequestBody ClienterequestDTO dto) {
        ClienteresponseDTO atualizado = clienteService.atualizar(id, dto);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        clienteService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
