package com.bankline.repository;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bankline.dto.LancamentoDto;
import com.bankline.dto.PlanoContaDto;
import com.bankline.model.PlanoConta;
import com.bankline.model.Usuario;

@Repository
public interface PlanoContaRepository extends JpaRepository<PlanoConta, Integer> {
	public List<PlanoConta> findByUsuario(Integer id);
	public List<PlanoConta> findByNome(String nome);
	public Optional<PlanoConta> findById(Integer id);
	
	
	@Query(value = "SELECT new com.bankline.dto.PlanoContaDto (pl.nome, pl.tipo_movimento, pl.padrao) "
			+ "FROM plano_conta Pl"
			+ " JOIN pl.usuario usu"
			+ " WHERE pl.usuario_id = usu.id"
			+ " AND usu.login = :login")   
	public List<PlanoContaDto> findByPlanoContaDto(@Param("login")String Login);

}
