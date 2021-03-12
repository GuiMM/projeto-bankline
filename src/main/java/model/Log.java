package model;

import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Embeddable
public class Log {

	private Date dataInclusao;
	private Date dataAlteracao;
	
	public Date getDataInclusao() {
		return dataInclusao;
	}
	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}
	public Date getDataAlteracao() {
		return dataAlteracao;
	}
	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}
	
	@PrePersist
	private void persist() {
		this.dataInclusao = new Date();
		
	}
	
	@PreUpdate
	private void update() {
		this.setDataAlteracao(new Date());
		
	}
	
}
