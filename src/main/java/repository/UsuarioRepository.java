package repository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.Usuario;

public class UsuarioRepository extends AbstractRepository<Usuario> implements Repository<Usuario> {
	
	public Boolean validarLogin(String login, String senha) {
		Boolean possue = false;
		TypedQuery<Usuario> query = em.createQuery(
				"SELECT u FROM Usuario u WHERE u.login = :login AND u.senha = :senha", Usuario.class);
		query.setParameter("login", login);
		query.setParameter("senha", senha);
		try {
			query.getSingleResult();
			possue = true;
		}catch(NoResultException e) {
			e.getStackTrace();
		}
		return possue;
	}
}
