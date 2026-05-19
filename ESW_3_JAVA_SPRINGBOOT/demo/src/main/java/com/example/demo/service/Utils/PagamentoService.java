/*
 * Autor...: João Victor Rantin Silvério
 * RA......: 252657-2024
 * Data....: 18/05/2026
 * Objetivo: Criar a service da entidade Pagamento
 */

package com.example.demo.service.Utils;

import com.example.demo.DTO.request.PagamentoRequestDTO;
import com.example.demo.Entities.Pagamento;
import com.example.demo.Entities.Reserva;
import com.example.demo.Repository.IPagamentoRepository;
import com.example.demo.Repository.ReservaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PagamentoService {
    //Declaração de atributos
    private final IPagamentoRepository pagamentoRepository;
    private final ReservaRepository reservaRepository;

    public void registrarPagamento (PagamentoRequestDTO pagamentoRequestDTO) {
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
        pagamentoRepository.save(pagamento);
    }

    public void alterarPagamento(PagamentoRequestDTO pagamentoRequestDTO) {
        Pagamento pagamento = pagamentoRepository.findById(pagamentoRequestDTO.id())
                .orElseThrow(() -> new RuntimeException("Pagamento não encontrado"));

        if(pagamento.getStatus().equals("PAGO")) {
            throw new RuntimeException("Esse pagamento já fo confirmado!");
        }

        pagamento.setStatus("PAGO");
        pagamentoRepository.save(pagamento)
    }
}
