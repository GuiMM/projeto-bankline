package com.bankline.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankline.dto.PlanoContaDto;
import com.bankline.model.PlanoConta;
import com.bankline.model.Usuario;
import com.bankline.repository.PlanoContaRepository;
import com.bankline.repository.UsuarioRepository;

@Service
public class PlanoContaService {

	@Autowired
	PlanoContaRepository planoContaRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public void cadastroPlanoConta(PlanoContaDto dto, String login) {
		Usuario usuario = usuarioRepository.findByLogin(login).get();
		PlanoConta planoConta = new PlanoConta();
		planoConta.setUsuario(usuario);
		planoConta.setNome(dto.getNome());
		planoConta.setPadrao(dto.isPadrao());
		planoConta.setTipoMovimento(dto.getTipoMovimento());
		planoContaRepository.save(planoConta);
		
	}
	
	public List<PlanoContaDto> ListarPlanosDeContas(String login){
		List<PlanoContaDto> planoContaDto = new ArrayList<PlanoContaDto>();
		planoContaDto = planoContaRepository.findByPlanoContaDto(login);
		return planoContaDto;	
	}
}
