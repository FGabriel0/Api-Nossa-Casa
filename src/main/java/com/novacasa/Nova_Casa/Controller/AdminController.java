package com.novacasa.Nova_Casa.Controller;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.novacasa.Nova_Casa.dto.AdminDTO;
import com.novacasa.Nova_Casa.model.entidy.Admin;
import com.novacasa.Nova_Casa.model.exception.ErroAutenticacao;
import com.novacasa.Nova_Casa.model.exception.RegraNegocioException;
import com.novacasa.Nova_Casa.model.service.AdminService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor

public class AdminController {
	private final AdminService service;
	
	@PostMapping("/autenticar")
	public ResponseEntity autenticar( @RequestBody AdminDTO dto ) {
		try {
			Admin adminAutenticado = service.autenticar(dto.getEmail(), dto.getSenha());
			return ResponseEntity.ok(adminAutenticado);
		}catch (ErroAutenticacao e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PostMapping
	public ResponseEntity salvar( @RequestBody AdminDTO dto ) {
		
		Admin admin = Admin.builder()
					.nome(dto.getNome())
					.email(dto.getEmail())
					.senha(dto.getSenha()).build();
		
		try {
			Admin adminSalvo = service.salvarAdmin(admin);
			return new ResponseEntity(adminSalvo, HttpStatus.CREATED);
		}catch (RegraNegocioException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
	}
	

}
