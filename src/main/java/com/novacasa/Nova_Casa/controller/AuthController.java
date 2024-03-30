package com.novacasa.Nova_Casa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.novacasa.Nova_Casa.dto.AuthDTO;
import com.novacasa.Nova_Casa.enums.ResponseStatusEnum;
import com.novacasa.Nova_Casa.form.AuthForm;
import com.novacasa.Nova_Casa.model.entidy.Usuario;
import com.novacasa.Nova_Casa.model.serviceimpl.AuthServiceImpl;
import com.novacasa.Nova_Casa.response.Response;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private AuthServiceImpl service;
		
		
	@PostMapping("/login")
	  public ResponseEntity<Response<AuthDTO>> authToken(
	      @RequestBody @Valid AuthForm form
	  ) {
	      return ResponseEntity.ok(
	          new Response<AuthDTO>(ResponseStatusEnum.SUCCESS, service.authenticate(form))
	      );
	  }
	
	
	
	

}
