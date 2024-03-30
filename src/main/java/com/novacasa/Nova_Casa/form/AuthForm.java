package com.novacasa.Nova_Casa.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthForm {
	
	
	@NotEmpty(message = "campo email obrigatório")
	@Email(message = "Email inválido")
	private String email;
			
	@NotEmpty(message = "campo senha obrigatório")
	private String password;
}
