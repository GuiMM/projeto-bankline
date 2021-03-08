package dto;

import model.enums.ContaTipoEnum;

public class ContaDto {
	private Integer id;
	private String numero;
	
	private Double saldo;
	private ContaTipoEnum tipo;
	private UsuarioDto usuario;
	
	public ContaDto(ContaTipoEnum tipo, UsuarioDto usuario) {
		this.numero = usuario.getNome() + tipo.name();
		saldo = 0.0;
		this.usuario = usuario;
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
	public UsuarioDto getUsuarioId() {
		return usuario;
	}
	public void setUsuarioId(UsuarioDto usuario) {
		this.usuario = usuario;
	}
}
