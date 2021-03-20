package com.bankline.dto;

import com.bankline.model.enums.ContaTipoEnum;

public class ContaDto {
	private Integer id;
	private String numero;
	private Double saldo;
	private ContaTipoEnum tipo;
	
	
	public ContaDto(Integer id, String numero, Double saldo, ContaTipoEnum tipo) {
		this.id = id;
		this.numero = numero;
		this.saldo = saldo;
		this.tipo = tipo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	public ContaTipoEnum getTipo() {
		return tipo;
	}
	public void setTipo(ContaTipoEnum tipo) {
		this.tipo = tipo;
	}
	
}
