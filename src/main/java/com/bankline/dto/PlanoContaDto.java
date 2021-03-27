package com.bankline.dto;

import java.util.ArrayList;
import java.util.List;

import com.bankline.model.PlanoConta;
import com.bankline.model.Usuario;
import com.bankline.model.enums.TipoMovimentoEnum;

public class PlanoContaDto {
	private String nome; 
	private boolean padrao;
	private TipoMovimentoEnum tipoMovimento;

	public PlanoContaDto(String nome, TipoMovimentoEnum tipoMovimento, boolean padrao) {
		this.nome = nome;
		this.padrao = padrao;
		this.tipoMovimento = tipoMovimento;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
