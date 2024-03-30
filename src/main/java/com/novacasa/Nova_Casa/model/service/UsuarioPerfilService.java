package com.novacasa.Nova_Casa.model.service;

import java.util.Optional;

import com.novacasa.Nova_Casa.dto.UsuarioPerfilDTO;
import com.novacasa.Nova_Casa.model.entidy.UsuarioPerfil;

public interface UsuarioPerfilService {

	UsuarioPerfil salvar(UsuarioPerfilDTO dto);
	
	Optional<UsuarioPerfil> obterPorId(Long id);

}