package com.example.tdd;

import static org.junit.Assert.assertThrows;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.bankline.dto.LancamentoDto;
import com.bankline.exception.SaldoInsuficienteException;
import com.bankline.model.Conta;
import com.bankline.model.PlanoConta;
import com.bankline.model.Usuario;
import com.bankline.model.enums.TipoMovimentoEnum;
import com.bankline.repository.ContaRepository;
import com.bankline.repository.LancamentoRepository;
import com.bankline.repository.PlanoContaRepository;
import com.bankline.repository.UsuarioRepository;
import com.bankline.service.LancamentoService;

@RunWith(SpringRunner.class)
public class LancamentoServiceTest {

	@Bean
	public LancamentoService lancamentoService() {
		return new LancamentoService();
	}
	
	@Autowired
	private LancamentoService lancamentoService;
	

	@MockBean
	private UsuarioRepository usuarioRepository;
	
	@MockBean
	private PlanoContaRepository planoContaRepository;
	
	@MockBean
	private ContaRepository contaRepository;
	
	@MockBean
	private LancamentoRepository lancamentoRepository;
	
	@Test
	public void transferenciaTest() {
		System.out.println("alou");
		LancamentoDto lancamentoDto = new LancamentoDto();
		lancamentoDto.setConta("Eduardo");
		lancamentoDto.setContaDestino("Monica");
		lancamentoDto.setValor(60.0);
		lancamentoDto.setDescricao("Transferencia Pix");
		lancamentoDto.setData(new Date());
		lancamentoDto.setPlanoContaId(6);
		
		assertThrows(SaldoInsuficienteException.class, () -> lancamentoService.registroEntrada(lancamentoDto));

		
	}
	
	@Before
	public void setup() {
		System.out.println("alou");
		
		Usuario userMonica = new Usuario();
		userMonica.setLogin("Monica");
		userMonica.setSenha("senha");
		userMonica.setCpf("11111111");
		userMonica.setNome("Monica");
		
		List<Conta> contasMonica = new ArrayList<Conta>();
		contasMonica.add(new Conta(userMonica.getLogin()));
		userMonica.setContas(contasMonica);
		
		Mockito.when(usuarioRepository.findByLogin(userMonica.getLogin())).thenReturn(java.util.Optional.of(userMonica));
		
		Usuario userEduardo = new Usuario();
		userEduardo.setLogin("Eduardo");
		userEduardo.setSenha("senha");
		userEduardo.setCpf("22222222");
		userEduardo.setNome("Eduardo");
		
		List<Conta> contasEduardo = new ArrayList<Conta>();
		contasEduardo.add(new Conta(userEduardo.getLogin()));
		userEduardo.setContas(contasEduardo);
		
		Mockito.when(usuarioRepository.findByLogin(userEduardo.getLogin())).thenReturn(java.util.Optional.of(userEduardo));
		
		
		PlanoConta planoConta = new PlanoConta();
		planoConta.setNome("Transferencia");
		planoConta.setUsuario(userMonica);
		planoConta.setTipoMovimento(TipoMovimentoEnum.TU);
		
		Mockito.when(planoContaRepository.getOne(6)).thenReturn(planoConta);
	}
	
}
