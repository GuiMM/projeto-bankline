package com.bankline;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bankline.dto.LancamentoDto;
import com.bankline.model.Usuario;
import com.bankline.service.LancamentoService;
import com.bankline.service.UsuarioService;

@Component
public class TestComponent {
	
	@Autowired
	private UsuarioService serv;
	
	@Autowired
	private LancamentoService lancService;
	
	public void testUsuario() throws Exception {
		Usuario user = new Usuario();
		user.setLogin("Monica");
		user.setSenha("senha");
		user.setCpf("11111111");
		user.setNome("Monica");
		serv.CriaUsuario(user);
		
		Usuario user2 = new Usuario();
		user2.setLogin("Eduardo");
		user2.setSenha("senha");
		user2.setCpf("22222222");
		user2.setNome("Eduardo");
		serv.CriaUsuario(user2);

		System.out.println("FUNCIONADO CRIACAO USUARIO");
		
	}
	
	public void testLancamento() throws Exception {
		LancamentoDto lancamentoDto = new LancamentoDto();
		lancamentoDto.setConta("Eduardo");
		lancamentoDto.setContaDestino("Monica");
		lancamentoDto.setValor(60.0);
		lancamentoDto.setDescricao("Transferencia Pix");
		lancamentoDto.setData(new Date());
		lancamentoDto.setPlanoContaId(6);
		lancService.registroEntrada(lancamentoDto);
		
		System.out.println("FUNCIONADO LANCAMENTO");
		
	}
}
