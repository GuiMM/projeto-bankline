package com.bankline.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankline.dto.DashboardRequestDto;
import com.bankline.dto.DashboardResultDto;
import com.bankline.service.DashboardService;

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
	public DashboardResultDto dashboardList(@PathVariable ("login") String login, @PathVariable ("dataInicio") String dataInicio,
			@PathVariable ("dataFim") String dataFim) throws ParseException {
		dashboardRequestDto.setLogin(login);
		dashboardRequestDto.setDataInicio(dataInicio);
		dashboardRequestDto.setDataFim(dataFim);
		return dashboardService.getDashboard(dashboardRequestDto);
	}
}
