package com.transicao.orcamentos.repository;

import com.transicao.orcamentos.model.Orcamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrcamentoRepository extends JpaRepository<Orcamento, Long> {
    // O JpaRepository já nos dá métodos prontos como:
    // save(), findAll(), findById(), deleteById()
}
