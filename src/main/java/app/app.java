package app;

import repository.ContaRepository;
import repository.LancamentoRepository;
import repository.PlanoContaRepository;
import repository.UsuarioRepository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import model.Conta;
import model.Lancamento;
import model.PlanoConta;
import model.Usuario;
import model.enums.ContaTipoEnum;
import model.enums.TipoMovimentoEnum;

public class app {

	public static void main(String[] args) {
		UsuarioRepository repository = new UsuarioRepository();
		PlanoContaRepository planoContaRepository = new PlanoContaRepository();
		
//		Usuario usuario = new Usuario();
//		
//		usuario.setLogin("renato123");
//		usuario.setSenha("111");
//		usuario.setNome("luis");
//		usuario.setCpf("11122233356");
//		usuario.addContas(new Conta("renato123", ContaTipoEnum.BANCO));
//		
//		repository.save(usuario);
		
		
//		PlanoConta planoConta = new PlanoConta();
//		Usuario usuario = repository.find(1);
//		planoConta.setNome("boleto VIVO");
//		planoConta.setPadrao(false);
//		planoConta.setUsuario(usuario);
//		planoConta.setTipoMovimento(TipoMovimentoEnum.D);
//		planoConta.setUsuario(usuario);
//		
//		planoContaRepository.save(planoConta);
		
		Usuario usuario = repository.find(1);
		System.out.println(usuario.toString());
		ContaRepository contaRepo = new ContaRepository(); 
		LancamentoRepository lancamentoRepo = new LancamentoRepository();
		PlanoContaRepository planoDeConta = new PlanoContaRepository();
		Conta origem = contaRepo.find(1);
		GregorianCalendar calendar = new GregorianCalendar();
		Lancamento lancamento = new Lancamento();
		PlanoConta planoConta = planoDeConta.find(1);
		lancamento.setDescricao("Luz");
		lancamento.setOrigem(origem);
		lancamento.setValor(100.32);
		lancamento.setDate(calendar.getTime());
		lancamento.setPlanoConta(planoConta);
		
		lancamentoRepo.save(lancamento);
		
	}

}
