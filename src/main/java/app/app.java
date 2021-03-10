package app;

import repository.PlanoContaRepository;
import repository.UsuarioRepository;
import model.Conta;
import model.PlanoConta;
import model.Usuario;
import model.enums.ContaTipoEnum;
import model.enums.TipoMovimentoEnum;

public class app {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UsuarioRepository repository = new UsuarioRepository();
		PlanoContaRepository planoContaRepository = new PlanoContaRepository();
		
//		Usuario usuario = new Usuario();
		
//		usuario.setLogin("renato123");
//		usuario.setSenha("111");
//		usuario.setNome("luis");
//		usuario.setCpf("11122233356");
//		usuario.setConta(new Conta("renato123", ContaTipoEnum.BANCO));
		
//		repository.save(usuario);
		
		
		PlanoConta planoConta = new PlanoConta();
		Usuario usuario = repository.find(6);
		planoConta.setNome("Despesas");
		planoConta.setPadrao(true);
		planoConta.setUsuario(usuario);
		planoConta.setTipoMovimento(TipoMovimentoEnum.R);
		
		planoContaRepository.save(planoConta);
		
	}

}
