package com.bankline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankline.exception.CampoDuplicadoException;
import com.bankline.exception.CampoInvalidoException;
import com.bankline.model.Conta;
import com.bankline.model.PlanoConta;
import com.bankline.model.Usuario;
import com.bankline.model.enums.TipoMovimentoEnum;
import com.bankline.repository.PlanoContaRepository;
import com.bankline.repository.UsuarioRepository;
import com.bankline.utils.CpfUtils;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private PlanoContaRepository planoContaRepository;

	@Autowired
	private CpfUtils cpfUtils;
	
	@Bean
	public CpfUtils cpUtils() {
		return new CpfUtils();
	}
	@Transactional
	public void CriaUsuario(Usuario usuario) throws Exception {
		
		usuario.setCpf(cpfUtils.formatarCpf(usuario.getCpf()));
		validateUser(usuario);
		
		usuario.addContas(new Conta(usuario.getLogin()));
		salvaPlanoContasDefault(usuario);
		usuarioRepository.save(usuario);
	}
	
	@Transactional
	private void salvaPlanoContasDefault(Usuario usuario) {
		PlanoConta planoContaR = new PlanoConta();
		PlanoConta planoContaD = new PlanoConta();
		PlanoConta planoContaTU = new PlanoConta();
		
		planoContaD.setPadrao(true);
		planoContaD.setUsuario(usuario);
		planoContaD.setNome("Despesas");
		planoContaD.setTipoMovimento(TipoMovimentoEnum.D);
		
		planoContaR.setPadrao(true);
		planoContaR.setUsuario(usuario);
		planoContaR.setNome("Receitas");
		planoContaR.setTipoMovimento(TipoMovimentoEnum.R);

		planoContaTU.setPadrao(true);
		planoContaTU.setUsuario(usuario);
		planoContaTU.setNome("Transferencias entre usuarios");
		planoContaTU.setTipoMovimento(TipoMovimentoEnum.TU);


		planoContaRepository.save(planoContaR);
		planoContaRepository.save(planoContaD);
		planoContaRepository.save(planoContaTU);
		
	}

	private void validateUser(Usuario usuario) throws Exception{
		validateUserName(usuario);
		validateCpf(usuario); 
	}

	private void validateUserName(Usuario usuario) throws Exception{
		if(usuario.getLogin().length() > 20)
			throw new CampoInvalidoException("login inválido!");
		if(usuarioRepository.existsByLogin(usuario.getLogin()))
			throw new CampoDuplicadoException("login já existe na base de dados!");
				
	}

	private void validateCpf(Usuario usuario) throws Exception{
		if (cpfUtils.validarCPF(usuario.getCpf()))
			throw new CampoInvalidoException("CPF inválido!");
		if (usuarioRepository.existsByCpf(usuario.getCpf()))
			throw new CampoDuplicadoException("CPF já existe na base de dados!");

	}

}
