package com.transicao.orcamentos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;

public class OrcamentoRequestDTO {

    @NotBlank(message = "O nome do cliente é obrigatório.")
    private String cliente;

    @NotBlank(message = "A descrição do orçamento é obrigatória.")
    private String descricao;

    @NotNull(message = "O valor total é obrigatório.")
    @Positive(message = "O valor total deve ser maior que zero.")
    private BigDecimal valorTotal;

    private String status;

    public OrcamentoRequestDTO() {
    }

    public OrcamentoRequestDTO(String cliente, String descricao, BigDecimal valorTotal, String status) {
        this.cliente = cliente;
        this.descricao = descricao;
        this.valorTotal = valorTotal;
        this.status = status;
    }

    public String getCliente() { return cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public BigDecimal getValorTotal() { return valorTotal; }
    public void setValorTotal(BigDecimal valorTotal) { this.valorTotal = valorTotal; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}