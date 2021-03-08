package model;

import model.enums.ContaTipoEnum;

public class Conta {
	private Integer id;
	private String numero;
	
	private Double saldo;
	private ContaTipoEnum tipo;
	private Usuario usuario;
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
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
