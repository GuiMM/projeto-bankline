package com.bankline.dto;

import java.util.ArrayList;
import java.util.List;

public class DashboardResultDto {
	private ContaDto conta;
	private List<LancamentoDto> ContaDebitoLancamentos;
	
	public DashboardResultDto() {
		ContaDebitoLancamentos = new ArrayList<LancamentoDto>();
	}
	
	public ContaDto getConta() {
		return conta;
	}
	public void setConta(ContaDto conta) {
		this.conta = conta;
	}
	public List<LancamentoDto> getContaDebitoLancamentos() {
		return ContaDebitoLancamentos;
	}
	public void setContaDebitoLancamentos(List<LancamentoDto> contaDebitoLancamentos) {
		ContaDebitoLancamentos = contaDebitoLancamentos;
	}
	
}
