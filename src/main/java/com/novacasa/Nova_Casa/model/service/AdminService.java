package com.novacasa.Nova_Casa.model.service;

import java.util.Optional;

import com.novacasa.Nova_Casa.model.entidy.Admin;

public interface AdminService {
	
	Admin autenticar(String email,String senha);
	
	Admin salvarAdmin(Admin admin);
	
	void validarEmail(String email);
	
	 Optional<Admin> obterPorId(Long id);

}
