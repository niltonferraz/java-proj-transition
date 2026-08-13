package com.transicao.orcamentos.service;

import com.transicao.orcamentos.dto.OrcamentoRequestDTO;
import com.transicao.orcamentos.dto.OrcamentoResponseDTO;
import com.transicao.orcamentos.exception.ResourceNotFoundException;
import com.transicao.orcamentos.model.Orcamento;
import com.transicao.orcamentos.repository.OrcamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrcamentoService {

    private final OrcamentoRepository repository;

    public OrcamentoService(OrcamentoRepository repository) {
        this.repository = repository;
    }

    public List<OrcamentoResponseDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(OrcamentoResponseDTO::new)
                .toList();
    }

    public OrcamentoResponseDTO buscarPorId(Long id) {
        Orcamento entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Orçamento não encontrado para o ID: " + id));
        return new OrcamentoResponseDTO(entity);
    }

    public OrcamentoResponseDTO criar(OrcamentoRequestDTO dto) {
        Orcamento entity = new Orcamento();
        entity.setCliente(dto.getCliente());
        entity.setDescricao(dto.getDescricao());
        entity.setValorTotal(dto.getValorTotal());
        entity.setStatus(dto.getStatus() == null || dto.getStatus().isBlank() ? "PENDENTE" : dto.getStatus());

        Orcamento salvo = repository.save(entity);
        return new OrcamentoResponseDTO(salvo);
    }

    public OrcamentoResponseDTO atualizar(Long id, OrcamentoRequestDTO dto) {
        Orcamento entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Orçamento não encontrado para o ID: " + id));

        entity.setCliente(dto.getCliente());
        entity.setDescricao(dto.getDescricao());
        entity.setValorTotal(dto.getValorTotal());
        if (dto.getStatus() != null && !dto.getStatus().isBlank()) {
            entity.setStatus(dto.getStatus());
        }

        Orcamento atualizado = repository.save(entity);
        return new OrcamentoResponseDTO(atualizado);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Orçamento não encontrado para o ID: " + id);
        }
        repository.deleteById(id);
    }
}