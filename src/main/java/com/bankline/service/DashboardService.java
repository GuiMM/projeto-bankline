package com.bankline.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankline.dto.ContaDto;
import com.bankline.dto.DashboardRequestDto;
import com.bankline.dto.DashboardResultDto;
import com.bankline.dto.LancamentoDto;
import com.bankline.model.Conta;
import com.bankline.model.Usuario;
import com.bankline.repository.LancamentoRepository;
import com.bankline.repository.UsuarioRepository; 

@Service
public class DashboardService {

	@Autowired
	UsuarioRepository usuarioRepo;
	
	@Autowired
	LancamentoRepository lancamentoRepository;
	
	public DashboardResultDto getDashboard(DashboardRequestDto dto) throws ParseException {
		Usuario usuario = usuarioRepo.findByLogin(dto.getLogin()).get();
		Conta conta = usuario.getContas().get(0);
		
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
		Calendar dataInicio = Calendar.getInstance();
		Calendar dataFim = Calendar.getInstance();
		dataInicio.setTime(formato.parse(dto.getDataInicio())); 
		dataFim.setTime(formato.parse(dto.getDataFim()));
		
		List<LancamentoDto> lancamentos = lancamentoRepository
				.findByContaIdAndDateBetween(conta.getId(), dataInicio, dataFim);
		
				
		DashboardResultDto dashboardResult = new DashboardResultDto();
		dashboardResult.setConta(new ContaDto(conta.getId(), conta.getNumero(), conta.getSaldo(), conta.getTipo()));
		dashboardResult.setContaDebitoLancamentos(lancamentos);
		return dashboardResult;
	}

	
}
