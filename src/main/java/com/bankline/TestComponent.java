package com.bankline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bankline.model.Usuario;
import com.bankline.repository.UsuarioRepository;
import com.bankline.service.LancamentoService;

@Component
public class TestComponent {
	
	@Autowired
	private UsuarioRepository repo;
	
	@Autowired
	private LancamentoService serv;
	
	public void testUsuario() {
		Usuario user = new Usuario();
		user.setLogin("gsoteste");
		user.setSenha("senha");
		user.setCpf("11111111");
		user.setNome("Gleyson");
		repo.save(user);

		System.out.println("FUNCIONADO");
		
		//serv.registerEntry(null);
	}
}
