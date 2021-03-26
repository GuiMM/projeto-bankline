package com.bankline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankline.dto.LancamentoDto;
import com.bankline.exception.BusinessException;
import com.bankline.service.LancamentoService;
import com.google.gson.Gson;

@RequestMapping("/lancamento")
@RestController
public class LancamentoController {

	@Autowired
	LancamentoService lancamentoService;
	
	@PostMapping("/")
	public ResponseEntity<String> lancamentoCadastro(@RequestBody LancamentoDto lancamentoDto){
		Gson gson = new Gson();
		try {
			lancamentoService.registroEntrada(lancamentoDto);
			return ResponseEntity.status(HttpStatus.OK).body(gson.toJson("Lancamento concluido com sucesso!"));
		} catch (BusinessException e) {
			return ResponseEntity.status(e.getHttpStatus()).body(gson.toJson(e.getMessage()));
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(gson.toJson("Ocorreu um erro ao cadastrar um lançamento"));
		}
	}
	
	
}