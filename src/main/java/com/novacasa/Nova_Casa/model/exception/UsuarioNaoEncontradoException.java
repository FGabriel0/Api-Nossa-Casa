package com.novacasa.Nova_Casa.model.exception;

public class UsuarioNaoEncontradoException extends RuntimeException {

	public UsuarioNaoEncontradoException() {
		super("Usuário não encontrado");
	}
}
