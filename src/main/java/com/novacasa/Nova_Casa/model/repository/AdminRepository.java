package com.novacasa.Nova_Casa.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.novacasa.Nova_Casa.model.entidy.Usuario;

@Repository
public interface AdminRepository extends JpaRepository<Usuario,Long> {
	
	boolean existsByEmail(String email);
	
	Optional<Usuario> findByEmail(String email);
	
}
