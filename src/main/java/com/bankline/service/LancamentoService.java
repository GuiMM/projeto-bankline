package com.bankline.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankline.dto.LancamentoDto;
import com.bankline.model.*;
import com.bankline.model.enums.TipoMovimentoEnum;
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
	public void registroEntrada(LancamentoDto dto) {
		
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
		Usuario usuario = usuarioRepo.findByLogin(dto.getConta()).get();
		Conta conta = usuario.getContas().get(0);
		
		Usuario usuarioDestino = usuarioRepo.findByLogin(dto.getContaDestino()).get();
		Conta contaDestino = usuarioDestino.getContas().get(0);
		
		subtraiSaldoLancamento(dto, conta);
		adicionaSaldoLancamento(dto, contaDestino);
		
		PlanoConta planoDestino = getPlanoDestino(dto, usuarioDestino);
		
		criaLancamentoOrigem(dto, plano, conta, contaDestino);
		
		criaLancamentoDestino(dto, planoDestino, contaDestino);
		
	}

	private void subtraiSaldoLancamento(LancamentoDto dto, Conta conta) {
		conta.subtraiSaldo(dto.getValor());
		contaRepo.save(conta);
	}
	private void adicionaSaldoLancamento(LancamentoDto dto, Conta contaDestino) {
		contaDestino.somaSaldo(dto.getValor());
		contaRepo.save(contaDestino);
	}
	private PlanoConta getPlanoDestino(LancamentoDto dto, Usuario usuarioDestino) {
		String nomePlanoTransferenciaDestino = "Transferencia de: " + dto.getConta() + "-->" + dto.getContaDestino();
		ArrayList<PlanoConta> planosDestino = (ArrayList<PlanoConta>) planoContaRepo.findByNome(nomePlanoTransferenciaDestino);
		PlanoConta planoDestino = planosDestino.isEmpty() ? criaPlanoContaTransferencia(usuarioDestino, nomePlanoTransferenciaDestino) : planosDestino.get(0);
		
		return planoDestino;
	}
	private void criaLancamentoDestino(LancamentoDto dto, PlanoConta planoDestino, Conta contaDestino) {
		Lancamento lancamentoDestino = new Lancamento();
		lancamentoDestino.setPlanoConta(planoDestino);
		lancamentoDestino.setDescricao(dto.getDescricao());
		lancamentoDestino.setValor(dto.getValor());
		lancamentoDestino.setDate(dto.getData());
		lancamentoDestino.setConta(contaDestino);
		lancamentoRepo.save(lancamentoDestino);
		
	}
	private void criaLancamentoOrigem(LancamentoDto dto, PlanoConta plano, Conta conta, Conta contaDestino) {
		Lancamento lancamentoOrigem = new Lancamento();
		lancamentoOrigem.setPlanoConta(plano);
		lancamentoOrigem.setDescricao(dto.getDescricao());
		lancamentoOrigem.setValor(dto.getValor());
		lancamentoOrigem.setDate(dto.getData());
		lancamentoOrigem.setConta(conta);
		lancamentoOrigem.setDestino(contaDestino);
		lancamentoRepo.save(lancamentoOrigem);
		
	}
	private PlanoConta criaPlanoContaTransferencia(Usuario usuario, String nomePlanoTransferenciaDestino) {
		
		PlanoConta contaParaSalvar = new PlanoConta();
		contaParaSalvar.setNome(nomePlanoTransferenciaDestino);
		contaParaSalvar.setPadrao(false);
		contaParaSalvar.setTipoMovimento(TipoMovimentoEnum.TU);
		contaParaSalvar.setUsuario(usuario);
		
		PlanoConta conta = planoContaRepo.save(contaParaSalvar);
		
		return conta;
	}
	private void transfereEntreConta(LancamentoDto dto, PlanoConta plano) {
		// TODO Auto-generated method stub
	}

	private void registraCredito(LancamentoDto dto, PlanoConta plano) {
		// TODO Auto-generated method stub
		
	}

	private void registraDebito(LancamentoDto dto, PlanoConta plano) {
		// TODO Auto-generated method stub
		
	}
}