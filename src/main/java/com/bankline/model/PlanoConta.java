package com.bankline.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.bankline.model.enums.TipoMovimentoEnum;

@Entity
@Table(name = "plano_conta")
public class PlanoConta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome; 
	
	@OneToOne
	private Usuario usuario;
	private boolean padrao;
	@Enumerated(EnumType.STRING)
	private TipoMovimentoEnum tipoMovimento;
	
	public TipoMovimentoEnum getTipoMovimento() {
		return tipoMovimento;
	}
	public void setTipoMovimento(TipoMovimentoEnum tipoMovimento) {
		this.tipoMovimento = tipoMovimento;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public boolean isPadrao() {
		return padrao;
	}
	public void setPadrao(boolean padrao) {
		this.padrao = padrao;
	}
	
	public PlanoConta() {}
}
