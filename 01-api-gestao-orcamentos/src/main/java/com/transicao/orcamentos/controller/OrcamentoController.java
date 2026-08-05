package com.transicao.orcamentos.controller;

import com.transicao.orcamentos.model.Orcamento;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/orcamentos")
public class OrcamentoController {

    private final List<Orcamento> orcamentos = new ArrayList<>();
    private Long proximoId = 1L;

    public OrcamentoController() {
        // Dados de teste para inicializar
        orcamentos.add(new Orcamento(proximoId++, "Empresa A", "Manutenção de Software", new BigDecimal("1500.00"), "PENDENTE"));
        orcamentos.add(new Orcamento(proximoId++, "Empresa B", "Consultoria de QA", new BigDecimal("3200.00"), "APROVADO"));
    }

    // GET: Listar todos os orçamentos
    @GetMapping
    public List<Orcamento> listarTodos() {
        return orcamentos;
    }

    // POST: Cadastrar um novo orçamento
    @PostMapping
    public Orcamento criar(@RequestBody Orcamento novoOrcamento) {
        novoOrcamento.setId(proximoId++);
        if (novoOrcamento.getStatus() == null) {
            novoOrcamento.setStatus("PENDENTE");
        }
        orcamentos.add(novoOrcamento);
        return novoOrcamento;
    }

    // GET: Buscar um orçamento específico por ID
    @GetMapping("/{id}")
    public Orcamento buscarPorId(@PathVariable Long id) {
        return orcamentos.stream()
                .filter(o -> o.getId().equals(id))
                .findFirst()
                .orElse(null); // Retorna o orçamento se achar, ou null
    }
}
