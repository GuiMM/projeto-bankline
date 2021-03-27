package com.bankline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankline.dto.PlanoContaDto;
import com.bankline.exception.BusinessException;
import com.bankline.model.PlanoConta;
import com.bankline.model.enums.TipoMovimentoEnum;
import com.bankline.service.PlanoContaService;
import com.google.gson.Gson;

@RestController
@RequestMapping("/planoconta")
public class PlanoContaController {

	@Autowired
	PlanoContaService planoContaService;
	
	@PostMapping(path ="/{login}")
	public void postPlanoConta(@PathVariable("login") String login,@RequestBody PlanoContaDto dto){
		planoContaService.cadastroPlanoConta(dto, login);
	}
	
	@GetMapping(path = "/{login}")
	public ResponseEntity<?> ListaPlanoDeConta(@PathVariable ("login") String login){
		Gson gson = new Gson();
		try {
			List<PlanoContaDto> resultado =  planoContaService.ListarPlanosDeContas(login);
			return ResponseEntity.status(HttpStatus.OK).body(resultado);
		} catch (BusinessException e) {
			return ResponseEntity.status(e.getHttpStatus()).body(gson.toJson(e.getMessage()));
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(gson.toJson("Ocorreu um erro ao Listar os planos de conta"));
		}
	}
	
	
}
