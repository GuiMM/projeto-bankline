package com.bankline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankline.dto.LoginDto;
import com.bankline.dto.Sessao;
import com.bankline.model.Usuario;
import com.bankline.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	
	@PostMapping("/cadastro")
	public void post(@RequestBody Usuario usuario) throws Exception {
		usuarioService.CriaUsuario(usuario);
	}
	
	@PostMapping("/login")
	public Sessao post(@RequestBody LoginDto login) throws Exception {
		return usuarioService.Login(login);
	}
	
	@PutMapping(path ="/alterar-senha/{login}")
	public void alterarSenha(@PathVariable String login, @RequestBody Usuario usuario) {
		
		 usuarioService.atualizarSenha(usuario,login);
	}
	
		

}
