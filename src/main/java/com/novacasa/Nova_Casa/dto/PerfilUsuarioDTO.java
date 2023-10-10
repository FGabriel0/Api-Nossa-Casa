package com.novacasa.Nova_Casa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PerfilUsuarioDTO {
	
	private Long IdUsuario;
	private Long IdPerfil;
}
