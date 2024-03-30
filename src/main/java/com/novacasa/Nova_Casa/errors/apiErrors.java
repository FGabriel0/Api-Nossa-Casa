package com.novacasa.Nova_Casa.errors;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;

public class apiErrors {

	@Getter
	private List<String> errors;

	public apiErrors(String msgError) {
		this.errors = Arrays.asList(msgError);
	}
	
	public apiErrors(List<String> errors) {
		this.errors = errors;
	}
	
}
