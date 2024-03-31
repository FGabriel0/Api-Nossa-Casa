package com.novacasa.Nova_Casa.controller.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PontoVendaDTO {
	
	private Long id;
	
	private Integer codigo;
	
	private String nome;
	
	private Boolean ativo;
	
	private LocalDateTime dataCriacao;
	
	private UsuarioDTO usuarioCriacao;
	
}
