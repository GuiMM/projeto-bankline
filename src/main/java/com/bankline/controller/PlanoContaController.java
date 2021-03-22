package com.bankline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankline.dto.PlanoContaDto;
import com.bankline.model.PlanoConta;
import com.bankline.service.PlanoContaService;

@RestController
@RequestMapping("/planoconta")
public class PlanoContaController {

	@Autowired
	PlanoContaService planoContaService;
	
	@PostMapping(path ="/{login}")
	public void postPlanoConta(@PathVariable("login") String login,@RequestBody PlanoContaDto dto){
		planoContaService.cadastroPlanoConta(dto, login);
	}
	
	@GetMapping(path = "/{id}")
	public List<PlanoConta> buscarPlanoConta(@PathVariable ("id") Integer id){
		return planoContaService.buscarPlanoContas(id);
	}
	
	
}
