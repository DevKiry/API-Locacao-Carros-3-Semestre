package com.example.demo.Repository;

import com.example.demo.Entities.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPagamentoRepository extends JpaRepository<Pagamento, Long> {
    List<Pagamento> findByStatus(String status);
    List<Pagamento> findByFormaPagamento(String formaPagamento);
}
