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
	
	public Conta(String nomeUsuario) {
		this.numero = nomeUsuario;
		this.tipo = ContaTipoEnum.BANCO;
		this.saldo = 0.0;
	}
	
	
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
	
	public Conta(String numero, ContaTipoEnum tipo) {
		this.numero = numero;
		this.tipo = tipo;
		this.saldo = 0.0;
	}
	
	public Conta(){}
	
//	@Override
//	public String toString() {
//		return "Conta [id=" + id + ", numero=" + numero + ", saldo=" + saldo + ", usuario=" + usuario + ", tipo=" + tipo
//				+ "]";
//	}
}
