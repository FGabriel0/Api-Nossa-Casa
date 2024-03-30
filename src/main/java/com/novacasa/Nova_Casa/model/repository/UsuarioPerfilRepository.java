package com.novacasa.Nova_Casa.model.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.novacasa.Nova_Casa.model.entidy.Perfil;
import com.novacasa.Nova_Casa.model.entidy.Usuario;
import com.novacasa.Nova_Casa.model.entidy.UsuarioPerfil;

@Repository
public interface UsuarioPerfilRepository extends JpaRepository<UsuarioPerfil, Long> {
	


	
}
