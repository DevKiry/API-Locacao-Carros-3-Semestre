/*
Autor: Arthur 
*/
package com.example.demo.controller;

import com.example.demo.DTO.request.CarroRequestDTO;
import com.example.demo.DTO.response.CarroResponseDTO;
import com.example.demo.service.CarroService;
import com.example.demo.service.Utils.ApiResponse;
import com.example.demo.service.Utils.ErrorResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carros")
@RequiredArgsConstructor
public class CarroController {

    private final CarroService carroService;

    // POST /api/carros
    @PostMapping
    public ResponseEntity<ApiResponse<CarroResponseDTO>> criar(@Valid @RequestBody CarroRequestDTO dto) {
        try {
            CarroResponseDTO response = carroService.criar(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(response));
        } catch (RuntimeException e) {
            ErrorResponse error = new ErrorResponse("CONFLICT", e.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiResponse<>(error));
        }
    }

    // GET /api/carros
    @GetMapping
    public ResponseEntity<ApiResponse<List<CarroResponseDTO>>> listarTodos() {
        List<CarroResponseDTO> response = carroService.listarTodos();
        return ResponseEntity.ok(new ApiResponse<>(response));
    }

    // GET /api/carros/disponiveis
    @GetMapping("/disponiveis")
    public ResponseEntity<ApiResponse<List<CarroResponseDTO>>> listarDisponiveis() {
        List<CarroResponseDTO> response = carroService.listarDisponiveis();
        return ResponseEntity.ok(new ApiResponse<>(response));
    }

    // GET /api/carros/{id}
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CarroResponseDTO>> buscarPorId(@PathVariable Long id) {
        try {
            CarroResponseDTO response = carroService.buscarPorId(id);
            return ResponseEntity.ok(new ApiResponse<>(response));
        } catch (RuntimeException e) {
            ErrorResponse error = new ErrorResponse("NOT_FOUND", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(error));
        }
    }

    // PUT /api/carros/{id}
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<CarroResponseDTO>> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody CarroRequestDTO dto) {
        try {
            CarroResponseDTO response = carroService.atualizar(id, dto);
            return ResponseEntity.ok(new ApiResponse<>(response));
        } catch (RuntimeException e) {
            ErrorResponse error = new ErrorResponse("NOT_FOUND", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(error));
        }
    }

    // DELETE /api/carros/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deletar(@PathVariable Long id) {
        try {
            carroService.deletar(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            ErrorResponse error = new ErrorResponse("NOT_FOUND", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(error));
        }
    }
}
