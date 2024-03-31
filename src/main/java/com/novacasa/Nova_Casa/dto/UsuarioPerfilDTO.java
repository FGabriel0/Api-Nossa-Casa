package com.novacasa.Nova_Casa.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioPerfilDTO {

	//@JsonProperty("id_usuario")
	@NotNull(message = "O ID do usuário não pode ser nulo")
	private Long idUsuario;

	@NotNull(message = "O ID do perfil não pode ser nulo")
	private Long idPerfil;
}
