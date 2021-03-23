package com.bankline.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.bankline.security.jwt.JWTAuthorizationFilter;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter{
	private static final String[] SWAGGER_WHITELIST = {
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**",
            "/h2-console/**"
	};
	
	//Basic Auth com usuario em memoria e sem criptografia
	/*
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		  auth.inMemoryAuthentication().withUser("user").password("{noop}123").roles("ADMIN");
	}
	*/ 
	
	//QUANDO QUISER BUSCAR O USARIO DO BANCO DE DADOS
	@Autowired
	private UserDetailsService userDetailService;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Bean
	PasswordEncoder getEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailService).passwordEncoder(encoder);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable()
		//LIBERANDO A API MANUALMENTE
		.authorizeRequests().antMatchers("**").permitAll();
		//NECESSARIO PARA HABILITAR O JWT, ALEM DAS DEPENDENCIAS pom.xml
//		.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
//		.authorizeRequests()
//		.antMatchers(SWAGGER_WHITELIST).permitAll()
		
		//BASIC AUTH
		//.anyRequest().authenticated().and().httpBasic()
		
		//AUTENTICACAO STATELESS
//		.anyRequest().authenticated()
//		.and()
//        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		;
	}
	
	
}

