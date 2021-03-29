package com.bankline;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
    public CommandLineRunner run(TestComponent t) throws Exception {
        return args -> {
        	//t.testUsuario();
        	t.testLancamentoCredito();
        	t.testLancamentoCredito();
        	t.testLancamentoTransferencia();
        	t.testLancamentoTransferencia();

        	t.testDashboard();
        };
    }
}
