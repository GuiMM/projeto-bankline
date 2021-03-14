package com.bankline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bankline.model.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Integer>{

}
