package com.transicao.orcamentos.model;

import java.math.BigDecimal;

public class Orcamento {

    private Long id;
    private String cliente;
    private String descricao;
    private BigDecimal valorTotal;
    private String status; // Ex: "PENDENTE", "APROVADO", "REJEITADO"

    public Orcamento() {
    }

    public Orcamento(Long id, String cliente, String descricao, BigDecimal valorTotal, String status) {
        this.id = id;
        this.cliente = cliente;
        this.descricao = descricao;
        this.valorTotal = valorTotal;
        this.status = status;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
