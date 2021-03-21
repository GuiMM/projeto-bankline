package com.example.tdd;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import com.bankline.service.LancamentoService;

@TestConfiguration
public class TestBeans {

	@Bean
	public LancamentoService lancamentoService() {
		System.out.println("PEGOU O BEANS");
		return new LancamentoService();
	}
}
