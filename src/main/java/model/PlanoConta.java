package model;

import model.enums.TipoMovimentoEnum;

public class PlanoConta {
	private String nome; // R / D / TU / TC
	private Usuario usuario;
	private boolean padrao;
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
	
	
}
