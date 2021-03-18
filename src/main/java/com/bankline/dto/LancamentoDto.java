package com.bankline.dto;

import java.util.Date;

public class LancamentoDto {
	
	private String conta;
	private Date data;
	private String contaDestino;
	private String descricao;
	private Integer planoContaId;
	private Double valor;	
	
	public LancamentoDto() {}
	
	public String getConta() {
		return conta;
	}
	public void setConta(String conta) {
		this.conta = conta;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getContaDestino() {
		return contaDestino;
	}
	public void setContaDestino(String contaDestino) {
		this.contaDestino = contaDestino;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getPlanoContaId() {
		return planoContaId;
	}
	public void setPlanoContaId(Integer planoContaId) {
		this.planoContaId = planoContaId;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
}
