package com.example.demo.mapper;

import com.example.demo.DTO.request.PagamentoRequestDTO;
import com.example.demo.DTO.response.PagamentoResponseDTO;
import com.example.demo.Entities.Pagamento;

public class PagamentoMapper {
    public static Pagamento toEntity(PagamentoRequestDTO dto) {
        Pagamento pagamento = new Pagamento();

        pagamento.setValor(dto.valor());

        pagamento.setFormaPagamento(dto.formaPagamento());

        return pagamento;
    }

    public static PagamentoResponseDTO toResponse(Pagamento pagamento) {

        return new PagamentoResponseDTO(
                pagamento.getId(),
                pagamento.getValor(),
                pagamento.getDataPagamento(),
                pagamento.getStatus(),
                pagamento.getFormaPagamento()
        );
    }

}
