package com.novacasa.Nova_Casa.model.service;

import java.util.Optional;

import com.novacasa.Nova_Casa.controller.form.UsuarioPerfilForm;
import com.novacasa.Nova_Casa.model.entidy.UsuarioPerfil;

public interface UsuarioPerfilService {

	UsuarioPerfil salvar(UsuarioPerfilForm dto);
	
	Optional<UsuarioPerfil> obterPorId(Long id);

}