package com.bankline.dto;

import com.bankline.model.Usuario;
import com.bankline.model.enums.TipoMovimentoEnum;

public class PlanoContaDto {
	private String nomeDescricao; 
	private boolean padrao;
	private TipoMovimentoEnum tipoMovimento;
	
	
	
	public PlanoContaDto(String nome, boolean padrao, TipoMovimentoEnum tipoMovimento, String login) {
		this.nomeDescricao = nome;
		this.padrao = padrao;
		this.tipoMovimento = tipoMovimento;
	}
	
	public String getNome() {
		return nomeDescricao;
	}
	public void setNome(String nome) {
		this.nomeDescricao = nome;
	}
	public boolean isPadrao() {
		return padrao;
	}
	public void setPadrao(boolean padrao) {
		this.padrao = padrao;
	}
	public TipoMovimentoEnum getTipoMovimento() {
		return tipoMovimento;
	}
	public void setTipoMovimento(TipoMovimentoEnum tipoMovimento) {
		this.tipoMovimento = tipoMovimento;
	}
	
}
