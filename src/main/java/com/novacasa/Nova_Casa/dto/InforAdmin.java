package com.novacasa.Nova_Casa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InforAdmin {
	
	private Integer codigo;
	private String nome;
	private String email;
	private String status;
	private String data_cadastro;
}
