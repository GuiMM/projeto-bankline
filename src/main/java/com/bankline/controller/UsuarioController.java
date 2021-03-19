package com.bankline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankline.model.Usuario;
import com.bankline.repository.UsuarioRepository;
import com.bankline.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	UsuarioRepository usuRepo;
	
	@PostMapping
	public void post(@RequestBody Usuario usuario) throws Exception {
		usuarioService.CriaUsuario(usuario);
		
	}
	
	
	
	
}
