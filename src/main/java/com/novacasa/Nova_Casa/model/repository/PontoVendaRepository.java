package com.novacasa.Nova_Casa.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.novacasa.Nova_Casa.model.entidy.PontoVenda;

@Repository
public interface PontoVendaRepository extends JpaRepository<PontoVenda, Long> {

	Optional<PontoVenda> findByCodigo(Integer codigo);
	
	List<PontoVenda> findByAtivoTrue();

}
