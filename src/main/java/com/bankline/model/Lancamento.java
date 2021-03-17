package com.bankline.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.sun.istack.NotNull;

@Entity
@Table(name = "lancamento")
public class Lancamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	private Double valor;
	private String descricao;
	@OneToOne
	private PlanoConta planoConta;
	@OneToOne
	private Conta conta;
	@OneToOne
	private Conta destino;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Conta getOrigem() {
		return conta;
	}
	public void setConta(Conta origem) {
		this.conta = origem;
	}
	public Conta getDestino() {
		return destino;
	}
	public void setDestino(Conta destino) {
		this.destino = destino;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public PlanoConta getPlanoConta() {
		return planoConta;
	}
	public void setPlanoConta(PlanoConta planoConta) {
		this.planoConta = planoConta;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
