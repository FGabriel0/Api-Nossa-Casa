package com.novacasa.Nova_Casa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.novacasa.Nova_Casa.controller.dto.PontoVendaDTO;
import com.novacasa.Nova_Casa.enums.ResponseStatusEnum;
import com.novacasa.Nova_Casa.model.entidy.Perfil;
import com.novacasa.Nova_Casa.model.entidy.PontoVenda;
import com.novacasa.Nova_Casa.model.service.PontoVendaService;
import com.novacasa.Nova_Casa.response.Response;

@RestController
@RequestMapping("/pontoVenda")
public class PontoVendaController {
	
	@Autowired
	private PontoVendaService service;
	
	@GetMapping
	public ResponseEntity<Response<List<PontoVendaDTO>>> buscarTodosAtivos() {
		Response<List<PontoVendaDTO>> response = new Response<>();
		try {
			response.setStatus(ResponseStatusEnum.SUCCESS);
			response.setData(service.buscarTodosAtivosDTO());
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(ResponseStatusEnum.ERROR);
			response.setMessage("Ocorreu um erro inesperado. Entre em contato com o administrador do sistema.");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Response<PontoVendaDTO>> buscarPorId(@PathVariable Long id) {
		Response<PontoVendaDTO> response = new Response<>();
		try {
			PontoVendaDTO pontoVenda = service.buscarPorIdDTO(id);
			if(pontoVenda != null) {
				response.setStatus(ResponseStatusEnum.SUCCESS);
				response.setData(pontoVenda);
				return ResponseEntity.ok(response);
			}else {
				response.setStatus(ResponseStatusEnum.ERROR);
				response.setMessage("Ponto de venda não encontrado.");
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(ResponseStatusEnum.ERROR);
			response.setMessage("Ocorreu um erro inesperado. Entre em contato com o administrador do sistema.");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}

}
