/*
 * Autor...: João Victor Rantin Silvério
 * RA......: 252657-2024
 * Data....: 18/05/2026
 * Objetivo: Criar a service da entidade Pagamento
 */

package com.example.demo.service.Utils;

import com.example.demo.DTO.request.PagamentoRequestDTO;
import com.example.demo.DTO.response.PagamentoResponseDTO;
import com.example.demo.Entities.Pagamento;
import com.example.demo.Entities.Reserva;
import com.example.demo.Repository.IPagamentoRepository;
import com.example.demo.Repository.ReservaRepository;

import com.example.demo.mapper.PagamentoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PagamentoService {
    //Declaração de atributos
    private final IPagamentoRepository pagamentoRepository;
    private final ReservaRepository reservaRepository;

    //Registra os pagamentos
    public PagamentoResponseDTO registrarPagamento (PagamentoRequestDTO pagamentoRequestDTO) {
        //Verifica se a reserva foi efetuada
        Reserva reserva = reservaRepository.findById(pagamentoRequestDTO.id())
                .orElseThrow(() -> new RuntimeException("Reserva não encontrada!"));

        //Cria o pagamento
        Pagamento pagamento = new Pagamento();
        pagamento.setReserva(reserva);
        pagamento.setValor(pagamentoRequestDTO.valor());
        pagamento.setFormaPagamento(pagamentoRequestDTO.formaPagamento());
        pagamento.setStatus("PENDENTE");

        //Salva o pagamento
        return PagamentoMapper.toResponse(pagamentoRepository.save(pagamento));
    }

    //Altera o status do pagamento para pago
    public PagamentoResponseDTO alterarPagamento(PagamentoRequestDTO pagamentoRequestDTO) {
        Pagamento pagamento = pagamentoRepository.findById(pagamentoRequestDTO.id())
                .orElseThrow(() -> new RuntimeException("Pagamento não encontrado"));

        if(pagamento.getStatus().equals("PAGO")) {
            throw new RuntimeException("Esse pagamento já fo confirmado!");
        }

        pagamento.setStatus("PAGO");
        return PagamentoMapper.toResponse(pagamentoRepository.save(pagamento));
    }

    //Lista todos os pagamentos
    public List<PagamentoResponseDTO> listarPagamentos() {
        return pagamentoRepository.findAll()
                .stream()
                .map(PagamentoMapper::toResponse)
                .collect(Collectors.toList());
    }

    //Busca o pagamento por ID
    public PagamentoResponseDTO buscarPorID(Long id) {
        Pagamento pagamento = pagamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pagamento não encontrado!"));

        return PagamentoMapper.toResponse(pagamento);
    }

    //Deleta o pagamento
    public void deletarPagamento(Long id) {
        if(!pagamentoRepository.existsById(id)) {
            throw new RuntimeException("Pagamento não encontrado!");
        }
    }

}
