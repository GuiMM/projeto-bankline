package repository;

import java.util.List;

import model.Usuario;

public class UsuarioRepository extends AbstractRepository<Usuario> implements Repository<Usuario> {
	//ContaRepository contaRepository;
	
	public UsuarioRepository() {
		//contaRepository = new ContaRepository();
	}
	//ACID
	@Override
	public List<Usuario> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario find(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
}
