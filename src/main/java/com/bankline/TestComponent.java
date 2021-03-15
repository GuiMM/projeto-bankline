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
	private UsuarioService serv;
	
	public void testUsuario() throws Exception {
		Usuario user = new Usuario();
		user.setLogin("Adalberto");
		user.setSenha("senha");
		user.setCpf("11112111");
		user.setNome("Adalberto");
		serv.CriaUsuario(user);
		
//		Usuario user2 = new Usuario();
//		user.setLogin("Eduardo");
//		user.setSenha("senha");
//		user.setCpf("22222222");
//		user.setNome("Eduardo");
//		serv.CriaUsuario(user2);

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
