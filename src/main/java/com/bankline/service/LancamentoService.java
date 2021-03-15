package com.bankline.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankline.dto.LancamentoDto;
import com.bankline.model.*;
import com.bankline.repository.ContaRepository;
import com.bankline.repository.LancamentoRepository;
import com.bankline.repository.PlanoContaRepository;
import com.bankline.repository.UsuarioRepository;


@Service
public class LancamentoService {
	
	@Autowired
	PlanoContaRepository planoContaRepo;
	@Autowired
	ContaRepository contaRepo;
	@Autowired
	UsuarioRepository usuarioRepo;
	
	@Autowired
	LancamentoRepository lancamentoRepo;
	
	@Transactional
	public void registerEntry(LancamentoDto dto) {
		
		PlanoConta plano = planoContaRepo.getOne(dto.getPlanoContaId());
		
		switch(plano.getTipoMovimento().name()) {
			case("D"):
				registraDebito(dto, plano);
				break;
			case("C"):
				registraCredito(dto,plano);
				break;
			case("TC"):
				transfereEntreConta(dto, plano);
				break;
			case("TU"):
				transfereEntreUsuario(dto, plano);
				break;
		}
		
	}
	@Transactional
	private void transfereEntreUsuario(LancamentoDto dto, PlanoConta plano) {
		Optional<Usuario> usuario = usuarioRepo.findByLogin(dto.getConta());
		Conta conta = usuario.get().getContas().get(0);
		
		Optional<Usuario> usuarioDestino = usuarioRepo.findByLogin(dto.getConta());
		ArrayList<PlanoConta> planos = (ArrayList<PlanoConta>) planoContaRepo.findByUsuario(usuarioDestino.get());
		Conta contaDestino = usuarioDestino.get().getContas().get(0);
		
		Lancamento lancamentoOrigem = new Lancamento();
		lancamentoOrigem.setPlanoConta(plano);
		lancamentoOrigem.setDate(dto.getData());
		lancamentoOrigem.setConta(conta);
		lancamentoOrigem.setDestino(contaDestino);
		lancamentoRepo.save(lancamentoOrigem);
		
		Lancamento lancamentoDestino = new Lancamento();
		lancamentoDestino.setPlanoConta(plano);
		lancamentoDestino.setDate(dto.getData());
		lancamentoDestino.setConta(contaDestino);
		lancamentoRepo.save(lancamentoDestino);
		
		
		
	}

	private void transfereEntreConta(LancamentoDto dto, PlanoConta plano) {
		
		
	}

	private void registraCredito(LancamentoDto dto, PlanoConta plano) {
		// TODO Auto-generated method stub
		
	}

	private void registraDebito(LancamentoDto dto, PlanoConta plano) {
		// TODO Auto-generated method stub
		
	}
}