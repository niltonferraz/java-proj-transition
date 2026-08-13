package com.transicao.orcamentos.dto;

import com.transicao.orcamentos.model.Orcamento;
import java.math.BigDecimal;

public class OrcamentoResponseDTO {

    private Long id;
    private String cliente;
    private String descricao;
    private BigDecimal valorTotal;
    private String status;

    public OrcamentoResponseDTO() {
    }

    public OrcamentoResponseDTO(Orcamento entity) {
        this.id = entity.getId();
        this.cliente = entity.getCliente();
        this.descricao = entity.getDescricao();
        this.valorTotal = entity.getValorTotal();
        this.status = entity.getStatus();
    }

    public Long getId() { return id; }
    public String getCliente() { return cliente; }
    public String getDescricao() { return descricao; }
    public BigDecimal getValorTotal() { return valorTotal; }
    public String getStatus() { return status; }
}