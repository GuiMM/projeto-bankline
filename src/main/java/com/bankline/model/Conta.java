package com.bankline.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.bankline.model.enums.ContaTipoEnum;
import com.sun.istack.NotNull;

@Entity
@Table(name = "conta")
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String numero;
	private Double saldo;
	
	@OneToOne
	private Usuario usuario;
	
	@Enumerated(EnumType.STRING)
	private ContaTipoEnum tipo;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
	public void somaSaldo(Double valorLancamento) {
		this.saldo += valorLancamento;
	}
	public void subtraiSaldo(Double valorLancamento) {
		this.saldo -= valorLancamento;
	}
	
	public Conta(String nomeUsuario) {
		this(nomeUsuario, ContaTipoEnum.BANCO);
	}
	
	public Conta(String numero, ContaTipoEnum tipo) {
		this.numero = numero;
		this.tipo = tipo;
		this.saldo = 0.0;
	}
	
	public Conta(){}
	

}
