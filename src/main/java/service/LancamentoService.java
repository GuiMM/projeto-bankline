package service;

import dto.LancamentoDto;
import model.Conta;
import model.Lancamento;
import model.PlanoConta;
import model.TipoMovimento;

public class LancamentoService {
	public void gravar(LancamentoDto dto) {
		//CONTA DE BANCO
		Conta conta = null; //repository.buscarContaPeloId(dto.contaId);
		
		//somar o saldo ou diminior o saldo
		
		Double valor = dto.valor;
		
		PlanoConta pc = null; //dto.idPlanoConta;
		
		if(pc.getTipoMovimento() == TipoMovimento.R)
			conta.setSaldo(conta.getSaldo() + valor);
		else if(pc.getTipoMovimento() == TipoMovimento.D)
			conta.setSaldo(conta.getSaldo() - valor);
		
		//TC
		// BUSCAR A OUTRA CONTA CREDITO DESTE USUARIO
		
		
		//TU - CONTA BANCO
		Conta cd =null;//;  dto.loginDestino; //repositrio.BuscarAContaBancoUsuarioDestino(); 
		
		
		
		Lancamento lancamento = new Lancamento();
		//sets
		
		repositorio.salvarLancamento(lancamento);
		
		//spring data jpa - salve / update - salve
		repositorioConta.atualizar(conta);
		
	}
}