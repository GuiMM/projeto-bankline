package com.bankline.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bankline.model.PlanoConta;
import com.bankline.model.Usuario;

public interface PlanoContaRepository extends JpaRepository<PlanoConta, Integer> {
	public List<PlanoConta> findByUsuario(Integer id);
	public List<PlanoConta> findByNome(String nome);
	

	public Optional<PlanoConta> findById(Integer id);
}
