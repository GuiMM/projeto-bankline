package com.bankline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bankline.model.Usuario;
import com.bankline.repository.UsuarioRepository;
import com.bankline.service.UsuarioService;

@Component
public class TestComponent {
	
	
	@Autowired
	private UsuarioService usuServ;
	
	public void testUsuario() throws Exception {
		Usuario user = new Usuario();
		user.setLogin("gsoteste");
		user.setSenha("senha");
		user.setCpf("22222223333");
		user.setNome("Gleyson");
		usuServ.save(user);

		System.out.println("FUNCIONADO");
	}
}
