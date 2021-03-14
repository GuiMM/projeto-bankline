package com.bankline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.bankline.model.Usuario;
import com.bankline.repository.UsuarioRepository;
import com.bankline.utils.CpfUtils;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private CpfUtils cpfUtils;
	
	@Bean
	public CpfUtils cpUtils() {
		return new CpfUtils();
	}
	public void save(Usuario usuario) throws Exception {
		
		
		if(validateUsuer(usuario))
			throw new Exception("campos Errados ou duplicados");
		
		usuarioRepository.save(usuario);
	}

	private Boolean validateUsuer(Usuario usuario) throws Exception{
		
		return validateCpf(usuario); //& validateUserName(usuario);
	}

	private boolean validateUserName(Usuario usuario) throws Exception{
		// TODO Auto-generated method stub
		return false;
	}

	private boolean validateCpf(Usuario usuario) throws Exception{
		if (cpfUtils.validarCPF(usuario.getCpf()))
			return true;
		if (usuarioRepository.existsByCpf(usuario.getCpf()))
			return true;

		return false;
	}

}
