package com.novacasa.Nova_Casa.controller.form;

import com.novacasa.Nova_Casa.model.entidy.PontoVenda;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PontoVendaForm {
	
	private Integer codigo;
	
	private String nome;
	
	public PontoVenda getModel(){
		return PontoVenda.builder()
			.codigo(codigo)
			.nome(nome)
			.build();
	}
	

}
