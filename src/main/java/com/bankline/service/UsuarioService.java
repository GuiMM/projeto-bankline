package com.bankline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
		if(!validateUsuer(usuario))
			throw new Exception("campos Errados ou duplicados");
		
		
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

	private Boolean validateUsuer(Usuario usuario) throws Exception{
		return validateCpf(usuario); //& validateUserName(usuario);
	}

	private boolean validateUserName(Usuario usuario) throws Exception{
		// TODO Auto-generated method stub
		return true;
	}

	private boolean validateCpf(Usuario usuario) throws Exception{
		if (cpfUtils.validarCPF(usuario.getCpf()))
			return false;
		if (usuarioRepository.existsByCpf(usuario.getCpf()))
			return false;

		return true;
	}

}
