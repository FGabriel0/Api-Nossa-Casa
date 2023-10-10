package com.novacasa.Nova_Casa.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.novacasa.Nova_Casa.model.entidy.PerfilUsuario;

@Repository
public interface PerfilUsuarioRepository extends JpaRepository<PerfilUsuario,Long> {
	Optional<PerfilUsuario> findByIdUsuarioAndIdPerfil(Long idUsuario, Long idPerfil);

    List<PerfilUsuario> findByIdUsuario(Long idUsuario);

    @Transactional
    @Modifying
    @Query("DELETE FROM UsuarioPerfil up WHERE up.idUsuario = :idUsuario AND up.idPerfil = :idPerfil")
    void deleteByIdUsuarioAndIdPerfil(Long idUsuario, Long idPerfil);
    
}
