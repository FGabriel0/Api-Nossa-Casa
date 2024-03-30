package com.novacasa.Nova_Casa.model.service;

import java.util.Optional;

import com.novacasa.Nova_Casa.model.entidy.Usuario;

public interface AdminService {
	
	Usuario autenticar(String email,String senha);
	
	Usuario salvarAdmin(Usuario usuario);
	
	void validarEmail(String email);
	
	Optional<Usuario> obterPorId(Long id);
	


}
