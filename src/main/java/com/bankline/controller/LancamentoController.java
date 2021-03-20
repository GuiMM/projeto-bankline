package com.bankline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankline.dto.LancamentoDto;
import com.bankline.exception.SaldoInsuficienteException;
import com.bankline.service.LancamentoService;

@RequestMapping("/lancamento")
@RestController
public class LancamentoController {

	@Autowired
	LancamentoService lancamentoService;
	
	@PostMapping("/")
	public void lancamentoCadastro(@RequestBody LancamentoDto lancamentoDto) throws SaldoInsuficienteException{
		lancamentoService.registroEntrada(lancamentoDto);
	}
	
	
}