package com.bankline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankline.model.Usuario;
import com.bankline.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public void save(Usuario usuario) throws Exception {
		
		
		if(validateUsuer(usuario))
			throw new Exception("campos Errados ou duplicados");
		
		usuarioRepository.save(usuario);
	}

	private Boolean validateUsuer(Usuario usuario) throws Exception{
		
		return validateCpf(usuario) & validateUserName(usuario);
	}

	private boolean validateUserName(Usuario usuario) throws Exception{
		// TODO Auto-generated method stub
		return false;
	}

	private boolean validateCpf(Usuario usuario) throws Exception{
		// TODO Auto-generated method stub
		return false;
	}

}
