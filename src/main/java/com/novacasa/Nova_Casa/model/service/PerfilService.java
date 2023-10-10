package com.novacasa.Nova_Casa.model.service;

import java.util.List;
import java.util.Optional;

import com.novacasa.Nova_Casa.model.entidy.Perfil;

public interface PerfilService {

	List<Perfil> listarTodos();
	
	Perfil salvar(Perfil perfil);
	
	Perfil atualizarPerfil(Long id, Perfil novoPerfil);
	
	void excluirPerfil(Long id);
	
	Optional<Perfil> obterPorId(Long id);
}
