package com.bankline.doc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket detalheApi() {
		
		ParameterBuilder paramBuilder = new ParameterBuilder();
		List<Parameter> params = new ArrayList<>();
		paramBuilder.name("Authorization").modelRef(new ModelRef("string"))
		.parameterType("header")
		.required(false)
		.build();
		
		
		params.add(paramBuilder.build());
		
		Docket docket = new Docket(DocumentationType.SWAGGER_2);
 
		docket
		.globalOperationParameters(params)
		.select()
		.apis(RequestHandlerSelectors.basePackage("com.bankline.controller"))
		.paths(PathSelectors.any())
		.build()
		.apiInfo(this.informacoesApi().build())
		.consumes(new HashSet<String>(Arrays.asList("application/json")))
		.produces(new HashSet<String>(Arrays.asList("application/json")));
		
		return docket;
	}
	private ApiInfoBuilder informacoesApi() {
		 
		ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
 
		apiInfoBuilder.title("Gama Educação - API");
		apiInfoBuilder.description("API Accenture Desafio Turma 7");
		apiInfoBuilder.version("1.0");
		apiInfoBuilder.termsOfServiceUrl("Termo de uso: Uso Gama Academy");
		apiInfoBuilder.license("Licença - Grupo Undefined");
		apiInfoBuilder.licenseUrl("https://gama.grupo-undefined/");
		apiInfoBuilder.contact(this.contato());
 
		return apiInfoBuilder;
 
	}
	private Contact contato() {
 
		return new Contact(
				"Gama Educação",
				"https://gama.grupo-undefined/", 
				"grupoundefined@gama.academy");
	}
}
