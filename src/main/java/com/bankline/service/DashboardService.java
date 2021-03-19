package com.bankline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankline.dto.DashboardRequestDto;
import com.bankline.dto.DashboardResultDto;
import com.bankline.dto.LancamentoDto;
import com.bankline.model.Conta;
import com.bankline.model.Lancamento;
import com.bankline.model.Usuario;
import com.bankline.repository.LancamentoRepository;
import com.bankline.repository.UsuarioRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper; 
import com.fasterxml.jackson.databind.ObjectWriter; 

@Service
public class DashboardService {

	@Autowired
	UsuarioRepository usuarioRepo;
	
	@Autowired
	LancamentoRepository lancamentoRepository;
	
	public DashboardResultDto getDashboard(DashboardRequestDto dto) {
		DashboardResultDto dashboardResult = new DashboardResultDto();
		
		Usuario usuario = usuarioRepo.findByLogin(dto.getLogin()).get();
		Conta conta = usuario.getContas().get(0);
		System.out.println(" inicio: "+dto.getDataInicio()+" fim: "+ dto.getDataFim());
		List<LancamentoDto> lancamentos = lancamentoRepository
										.findByContaIdAndDateBetween(conta.getId(), dto.getDataInicio(), dto.getDataFim());
		
		
		dashboardResult.setContaDebitoLancamentos(lancamentos);
		return dashboardResult;
	}
}
