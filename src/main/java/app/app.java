package app;

import repository.UsuarioRepository;
import model.Conta;
import model.Usuario;
import model.enums.ContaTipoEnum;

public class app {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UsuarioRepository repository = new UsuarioRepository();
		
		Usuario usuario = new Usuario();
		
		
		usuario.setLogin("renato123");
		usuario.setSenha("111");
		usuario.setNome("luis");
		usuario.setCpf("11122233356");
		usuario.setConta(new Conta("renato123", ContaTipoEnum.BANCO));
		
		repository.save(usuario);
	}

}
