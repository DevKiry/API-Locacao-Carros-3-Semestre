/*
    Autor: Caio Felipe Braga de Oliveira
    Data: 06/05/2026
    Service: Cliente
*/
package com.example.demo.service;
 
import com.example.demo.DTO.request.ClienteRequestDTO;
import com.example.demo.DTO.response.ClienteResponseDTO;
import com.example.demo.Entities.Cliente;
import com.example.demo.Repository.ClienteRepository;
import com.example.demo.mapper.ClienteMapper;
 
import org.springframework.stereotype.Service;
 
import java.util.List;
import java.util.stream.Collectors;
 
@Service
public class ClienteService {
 
    private final ClienteRepository clienteRepository;
 
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ClienteResponseDTO criar(ClienteRequestDTO dto) {
        if (clienteRepository.existsByEmail(dto.email())) {
            throw new IllegalArgumentException("Já existe um cliente com o e-mail informado.");
        }
        if (clienteRepository.existsByDocumento(dto.documento())) {
            throw new IllegalArgumentException("Já existe um cliente com o documento informado.");
        }
 
        Cliente cliente = ClienteMapper.toEntity(dto);
        Cliente salvo = clienteRepository.save(cliente);
        return ClienteMapper.toResponse(salvo);
    }
 
    public List<ClienteResponseDTO> listarTodos() {
        return clienteRepository.findAll()
                .stream()
                .map(ClienteMapper::toResponse)
                .collect(Collectors.toList());
    }
 
    public ClienteResponseDTO buscarPorId(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado com ID: " + id));
        return ClienteMapper.toResponse(cliente);
    }
 
    public ClienteResponseDTO atualizar(Long id, ClienteRequestDTO dto) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado com ID: " + id));
 
        clienteRepository.findByEmail(dto.email()).ifPresent(existente -> {
            if (!existente.getId().equals(id)) {
                throw new IllegalArgumentException("Já existe outro cliente com o e-mail informado.");
            }
        });
 
        clienteRepository.findByDocumento(dto.documento()).ifPresent(existente -> {
            if (!existente.getId().equals(id)) {
                throw new IllegalArgumentException("Já existe outro cliente com o documento informado.");
            }
        });
 
        ClienteMapper.updateEntity(cliente, dto);
        Cliente atualizado = clienteRepository.save(cliente);
        return ClienteMapper.toResponse(atualizado);
    }
 
    public void deletar(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new IllegalArgumentException("Cliente não encontrado com ID: " + id);
        }
        clienteRepository.deleteById(id);
    }
}
 