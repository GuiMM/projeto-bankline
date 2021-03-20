package com.bankline.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
		
		List<LancamentoDto> lancamentos = lancamentoRepository
										.findByContaIdAndDateBetween(conta.getId());
		
		List<LancamentoDto> lancamentosFiltered = filterLancamentosDate(dto, lancamentos);
		
				
		DashboardResultDto dashboardResult = new DashboardResultDto();
		dashboardResult.setConta(new ContaDto(conta.getId(), conta.getNumero(), conta.getSaldo(), conta.getTipo()));
		dashboardResult.setContaDebitoLancamentos(lancamentosFiltered);
		return dashboardResult;
	}

	private List<LancamentoDto> filterLancamentosDate(DashboardRequestDto dto, List<LancamentoDto> lancamentos) throws ParseException {

		List<LancamentoDto> lancamentosFiltered = new ArrayList<LancamentoDto>();
		
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
		Calendar dataInicio = Calendar.getInstance();
		Calendar dataFim = Calendar.getInstance();
		dataInicio.setTime(formato.parse(dto.getDataInicio())); 
		dataFim.setTime(formato.parse(dto.getDataFim()));
		
		for(int i =0; i< lancamentos.size(); i++)
		{
			if( lancamentos.get(i).getData().after(dataInicio)  && lancamentos.get(i).getData().before(dataFim) )
				lancamentosFiltered.add(lancamentos.get(i));
		}
		
		return lancamentosFiltered;
	}
}
