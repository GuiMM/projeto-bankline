package com.bankline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankline.dto.LancamentoDto;
import com.bankline.model.PlanoConta;
import com.bankline.repository.PlanoContaRepository;


@Service
public class LancamentoService {
	
	@Autowired
	PlanoContaRepository planoContaRepo;
	
	@Transactional
	public void registerEntry(LancamentoDto dto) {
		
		PlanoConta plano = planoContaRepo.getOne(dto.getPlanoContaId());
		
		switch(plano.getTipoMovimento().name()) {
			case("D"):
				registraDebito(dto);
				break;
			case("C"):
				registraCredito(dto);
				break;
			case("TC"):
				transfereEntreConta(dto);
				break;
			case("TU"):
				transfereEntreUsuario(dto);
				break;
		}
		
		
	}

	private void transfereEntreUsuario(LancamentoDto dto) {
		// TODO Auto-generated method stub
		
	}

	private void transfereEntreConta(LancamentoDto dto) {
		// TODO Auto-generated method stub
		
	}

	private void registraCredito(LancamentoDto dto) {
		// TODO Auto-generated method stub
		
	}

	private void registraDebito(LancamentoDto dto) {
		// TODO Auto-generated method stub
		
	}
}