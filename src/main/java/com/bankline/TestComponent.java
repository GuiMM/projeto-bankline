package com.bankline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bankline.dto.LancamentoDto;
import com.bankline.model.Conta;
import com.bankline.model.Lancamento;
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
		useServ.CriaUsuario(user);

		System.out.println("FUNCIONADO");
		Usuario user2 = new Usuario();
		user2.setLogin("Eduardo");
		user2.setSenha("senha");
		user2.setCpf("22222222");
		user2.setNome("Eduardo");
		useServ.CriaUsuario(user2);

		System.out.println("FUNCIONADO CRIACAO USUARIO");
		
	}
	
	public void testLancamento() throws Exception {
		LancamentoDto lancamentoDto = new LancamentoDto();
		lancamentoDto.setConta("Monica");
		lancamentoDto.setContaDestino("Eduardo");
		lancamentoDto.setValor(50.0);
		lancamentoDto.setDescricao("Transferencia Pix");
		//lancamentoDto.setPlanoContaId("Monica");
		
		
		System.out.println("FUNCIONADO LANCAMENTO");
		
		//serv.registerEntry(null);
	}
}	

