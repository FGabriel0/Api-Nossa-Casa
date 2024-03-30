package com.novacasa.Nova_Casa.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.novacasa.Nova_Casa.errors.apiErrors;
import com.novacasa.Nova_Casa.model.exception.RegraNegocioException;
import com.novacasa.Nova_Casa.model.exception.UsuarioNaoEncontradoException;

//Tratamento de Erros
@RestControllerAdvice
public class ApplicationControllerAdvice {

	@ExceptionHandler(RegraNegocioException.class)//Vai marcar o método como tratante de erro
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public apiErrors handlerRegraNegocioException(RegraNegocioException ex) {
		String mensagemError = ex.getMessage();
		return new apiErrors(mensagemError);
	}
	
	@ExceptionHandler(UsuarioNaoEncontradoException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public apiErrors handlerPedidoNotFoundException(UsuarioNaoEncontradoException ex) {
		return new apiErrors(ex.getMessage());
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public apiErrors handlerMethodNotValidExecption(MethodArgumentNotValidException ex) {
		List<String> errors = ex.getBindingResult().getAllErrors()
		.stream()
		.map(erro -> erro.getDefaultMessage())
			.collect(Collectors.toList());
		
		return new apiErrors(errors);
	}
}
