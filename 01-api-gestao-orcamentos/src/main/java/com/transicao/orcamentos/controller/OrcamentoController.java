package com.transicao.orcamentos.controller;

import com.transicao.orcamentos.model.Orcamento;
import com.transicao.orcamentos.repository.OrcamentoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orcamentos")
public class OrcamentoController {

    private final OrcamentoRepository repository;

    // Injeção de dependência via construtor
    public OrcamentoController(OrcamentoRepository repository) {
        this.repository = repository;
    }

    // GET: Listar todos do Banco
    @GetMapping
    public List<Orcamento> listarTodos() {
        return repository.findAll();
    }

    // GET: Buscar por ID no Banco
    @GetMapping("/{id}")
    public Orcamento buscarPorId(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    // POST: Salvar no Banco
    @PostMapping
    public Orcamento criar(@RequestBody Orcamento novoOrcamento) {
        if (novoOrcamento.getStatus() == null) {
            novoOrcamento.setStatus("PENDENTE");
        }
        return repository.save(novoOrcamento);
    }
}