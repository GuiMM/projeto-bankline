package service;

import dto.UsuarioDto;
import model.enums.ContaTipoEnum;

import java.util.ArrayList;

import dto.ContaDto;
import repository.UsuarioRepository;

public class UsuarioService {
	
	UsuarioRepository usuarioRepository;
	
	public UsuarioService() {
		usuarioRepository = new UsuarioRepository();
	}
	
	public void create(UsuarioDto dto) {
		
		if(validaCampos(dto))
			throw new RuntimeException(); //Criar uma exception personalizada para isso.
		
		criaContasDefault(dto);
		
		usuarioRepository.create(dto);
	}
	
	private void criaContasDefault(UsuarioDto dto) {
		ArrayList<ContaDto> contasDefault = new ArrayList<ContaDto>();
		contasDefault.add(new ContaDto(ContaTipoEnum.BANCO, dto));
		contasDefault.add(new ContaDto(ContaTipoEnum.CREDITO, dto));
		
		dto.setContas(contasDefault);
	}

	private boolean validaCampos(UsuarioDto dto) {
		
		if(!validaLogin(dto.getLogin()))
			return false;
		
		if(!validaCpf(dto.getCpf()))
			return false;
		
		return true;
	}

	/*
	 * Valida Cpf sobre os seguintes aspectos:
	 * não pode já existir CPF igual no banco.
	 * */
	private boolean validaCpf(String cpf) {
		return false;
	}

	/*
	 * Valida login sobre os seguintes aspectos:
	 * pode conter letras e numeros com no maximo 20 caracteres e 
	 * não pode já existir login igual no banco.
	 * */
	private boolean validaLogin(String login) {
		return false;
	}
}
