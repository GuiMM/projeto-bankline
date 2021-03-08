package repository;

import dto.UsuarioDto;

public class UsuarioRepository {
	ContaRepository contaRepository;
	
	public UsuarioRepository() {
		contaRepository = new ContaRepository();
		
	}

	public void create(UsuarioDto dto) {
		
		contaRepository.bulkCreate(dto.getContas());
		
	}
}
