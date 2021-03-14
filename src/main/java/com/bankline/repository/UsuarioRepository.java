package com.bankline.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.bankline.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	public Optional <Usuario> findByLogin(String login);
	public boolean existsByLogin(String login);
}
