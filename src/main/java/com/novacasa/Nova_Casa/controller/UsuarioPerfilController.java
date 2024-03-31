package com.novacasa.Nova_Casa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.novacasa.Nova_Casa.controller.form.UsuarioPerfilForm;
import com.novacasa.Nova_Casa.model.entidy.UsuarioPerfil;
import com.novacasa.Nova_Casa.model.serviceimpl.UsuarioPerfilImpl;

@RestController
@RequestMapping("/api/usuario-perfil")
public class UsuarioPerfilController {
	
	@Autowired
	private UsuarioPerfilImpl service;
		
	@PostMapping("/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	public UsuarioPerfil salvar(@RequestBody UsuarioPerfilForm dto) {	
		return service.salvar(dto); 
 
	}
				
}
