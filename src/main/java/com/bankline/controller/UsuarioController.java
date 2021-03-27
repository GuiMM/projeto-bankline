package com.bankline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bankline.dto.LoginDto;
import com.bankline.dto.Sessao;
import com.bankline.dto.UsuarioDto;
import com.bankline.exception.BusinessException;
import com.bankline.model.Usuario;
import com.bankline.service.UsuarioService;
import com.google.gson.Gson;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	
	@PostMapping("/cadastro")
	public ResponseEntity<String> post(@RequestBody UsuarioDto usuario) {
		Gson gson = new Gson();
		try {
			usuarioService.CriaUsuario(usuario);
			return ResponseEntity.status(HttpStatus.CREATED).body(gson.toJson("Usuario cadastrado com sucesso!"));
		} catch (BusinessException e) {
			return ResponseEntity.status(e.getHttpStatus()).body(gson.toJson(e.getMessage()));
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(gson.toJson("Ocorreu um erro ao cadastrar um usuário"));
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> post(@RequestBody LoginDto login) {
		
		Gson gson = new Gson();
		try {
			Sessao response = usuarioService.Login(login);
			return ResponseEntity.status(HttpStatus.OK).body(response);
			
		}catch (BusinessException e) {
			return ResponseEntity.status(e.getHttpStatus()).body(gson.toJson(e.getMessage()));
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(gson.toJson(e.getMessage()));
		}
	}
	
	@PatchMapping(path ="/alterar-senha/{login}")
	public ResponseEntity<?> alterarSenha(@PathVariable String login, @RequestParam ("senha") String senha) {
		Gson gson = new Gson();
		try {
			usuarioService.atualizarSenha(senha,login);
			return ResponseEntity.status(HttpStatus.OK).body(gson.toJson("Senha modificada com sucesso!"));
		}catch (BusinessException e) {
			return ResponseEntity.status(e.getHttpStatus()).body(gson.toJson(e.getMessage()));
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(gson.toJson("Ocorreu um erro ao recadastrar a senha"));
		}
	}
	
		

}
