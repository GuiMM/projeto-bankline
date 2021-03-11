package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String login;

	private String senha;
	private String nome;
	private String cpf;
	private String telefone;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.PERSIST)
	private List<Conta> contas = new ArrayList<Conta>();
	
	
	public void addContas(Conta conta) {
		conta.setUsuario(this);
		contas.add(conta);
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}

	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public List<Conta> getContas() {
		return contas;
	}
	public void setContas(List<Conta> contas) {
		this.contas = contas;
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
	
	public Usuario() {}
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", login=" + login + ", senha=" + senha + ", nome=" + nome + ", cpf=" + cpf
				+ ", telefone=" + telefone + ", contas=" + contas + "]";
	}
}
