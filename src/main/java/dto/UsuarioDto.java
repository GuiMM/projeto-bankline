package dto;

import java.util.List;


public class UsuarioDto {
	private String login;
	private String senha;
	private String nome;
	private String cpf;
	private List<ContaDto> contas; 
	
	public List<ContaDto> getContas() {
		return contas;
	}
	public void setContas(List<ContaDto> contas) {
		this.contas = contas;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
