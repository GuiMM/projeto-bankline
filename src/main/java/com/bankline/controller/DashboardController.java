package com.bankline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankline.dto.DashboardRequestDto;
import com.bankline.dto.DashboardResultDto;
import com.bankline.exception.BusinessException;
import com.bankline.service.DashboardService;
import com.google.gson.Gson;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

	@Autowired
	DashboardService dashboardService;
	@Autowired
	DashboardRequestDto dashboardRequestDto;

	@Bean
	public DashboardRequestDto dashboardRequestDto() {
		return new DashboardRequestDto();
	}

	@GetMapping("/{login}/{dataInicio}/{dataFim}")
	public ResponseEntity<?> dashboardList(@PathVariable String login, @PathVariable String dataInicio,
			@PathVariable String dataFim) {
		
		Gson gson = new Gson();
		dashboardRequestDto.setLogin(login);
		dashboardRequestDto.setDataInicio(dataInicio);
		dashboardRequestDto.setDataFim(dataFim);
		try {
			DashboardResultDto result = dashboardService.getDashboard(dashboardRequestDto);
			return ResponseEntity.status(HttpStatus.OK).body(result);
		} catch (BusinessException e) {
			return ResponseEntity.status(e.getHttpStatus()).body(gson.toJson(e.getMessage()));
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(gson.toJson("Ocorreu um erro ao recuperar o extrato de lançamentos"));
		}
	}
}
