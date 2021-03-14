package com.bankline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bankline.model.Usuario;
import com.bankline.repository.UsuarioRepository;
import com.bankline.service.LancamentoService;
import com.bankline.service.UsuarioService;

@Component
public class TestComponent {
	
	@Autowired
	private UsuarioRepository repo;
	
	@Autowired
	private LancamentoService serv;
	
	@Autowired
	private UsuarioService useServ;
	
	public void testUsuario() throws Exception {
		Usuario user = new Usuario();
		user.setLogin("gsoteste");
		user.setSenha("senha");
		user.setCpf("11111165418");
		user.setNome("Gleyson");
		useServ.save(user);

		System.out.println("FUNCIONADO");
		
		//serv.registerEntry(null);
	}
}
