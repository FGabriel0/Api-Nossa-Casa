package com.novacasa.Nova_Casa.controller.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioForm {
	
	private String nome;
	private String email;
	private String senha;
}
