package com.bankline;

import java.text.ParseException;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bankline.dto.DashboardRequestDto;
import com.bankline.dto.DashboardResultDto;
import com.bankline.dto.LancamentoDto;
import com.bankline.model.Usuario;
import com.bankline.service.DashboardService;
import com.bankline.service.LancamentoService;
import com.bankline.service.UsuarioService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@Component
public class TestComponent {
	
	@Autowired
	private UsuarioService serv;
	
	@Autowired
	private LancamentoService lancService;
	
	@Autowired
	private DashboardService dashboardService;
	
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
		lancamentoDto.setData(Calendar.getInstance());
		lancamentoDto.setPlanoContaId(6);
		lancService.registroEntrada(lancamentoDto);
		
		System.out.println("FUNCIONADO LANCAMENTO");
		
	}
	
	public void testDashboard() throws ParseException {
		DashboardRequestDto dto = new DashboardRequestDto();
		dto.setLogin("Eduardo");
		dto.setDataInicio("2021-02-25");
		dto.setDataFim("2021-04-20");
		DashboardResultDto lancamentos = dashboardService.getDashboard(dto);
		
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		try {
			String json = ow.writeValueAsString(lancamentos);
			System.out.println(json);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
