package com.bankline.dto;

import java.util.Calendar;
import com.fasterxml.jackson.annotation.JsonFormat;

public class LancamentoDto {
	
	private String conta;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm a z", timezone="GMT")
	private Calendar data;
	private String contaDestino;
	private String descricao;
	private Integer planoContaId;
	private String tipo;
	private Double valor;
	
	public LancamentoDto() {}
	
	public LancamentoDto(String conta, String destino, Calendar data, String descricao, String tipo, Double valor) {
		this.data = data;
		this.conta = conta;
		this.contaDestino = destino;
		this.valor = valor;
		this.descricao = descricao;
		this.tipo = tipo;
	}
	
	public String getConta() {
		return conta;
	}
	public void setConta(String conta) {
		this.conta = conta;
	}
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	public String getContaDestino() {
		return contaDestino;
	}
	public void setContaDestino(String contaDestino) {
		this.contaDestino = contaDestino;
	}
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
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
