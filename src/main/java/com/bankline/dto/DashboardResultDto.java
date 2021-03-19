package com.bankline.dto;

import java.util.ArrayList;
import java.util.List;

import com.bankline.model.Conta;
import com.bankline.model.Lancamento;

public class DashboardResultDto {
	private Conta conta;
	private List<LancamentoDto> ContaDebitoLancamentos;
	
	public DashboardResultDto() {
		ContaDebitoLancamentos = new ArrayList<LancamentoDto>();
	}
	
	public Conta getConta() {
		return conta;
	}
	public void setConta(Conta conta) {
		this.conta = conta;
	}
	public List<LancamentoDto> getContaDebitoLancamentos() {
		return ContaDebitoLancamentos;
	}
	public void setContaDebitoLancamentos(List<LancamentoDto> contaDebitoLancamentos) {
		ContaDebitoLancamentos = contaDebitoLancamentos;
	}
	
}
