package com.novacasa.Nova_Casa.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.novacasa.Nova_Casa.controller.form.UsuarioForm;
import com.novacasa.Nova_Casa.model.entidy.Usuario;
import com.novacasa.Nova_Casa.model.exception.RegraNegocioException;
import com.novacasa.Nova_Casa.model.service.AdminService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AdminController {
    
	@Autowired
    private  AdminService service;
    
    @PostMapping("/register")
    public ResponseEntity salvar(@RequestBody UsuarioForm form) {
    	  	
        Usuario usuario = Usuario.builder()
                .nome(form.getNome())
                .email(form.getEmail())
                .senha(form.getSenha())
                .build();

        try {
            Usuario adminSalvo = service.salvarAdmin(usuario);
            return new ResponseEntity(adminSalvo, HttpStatus.CREATED);
        } catch (RegraNegocioException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}



