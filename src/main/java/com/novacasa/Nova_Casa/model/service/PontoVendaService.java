package com.novacasa.Nova_Casa.model.service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.novacasa.Nova_Casa.controller.dto.PontoVendaDTO;
import com.novacasa.Nova_Casa.model.entidy.PontoVenda;
import com.novacasa.Nova_Casa.model.repository.PontoVendaRepository;

@Service
public class PontoVendaService {
	
	private static final ModelMapper modelMapper = new ModelMapper();
	
	@Autowired
	private PontoVendaRepository repository;
	
	public List<PontoVenda> buscarTodos(){
		return repository.findAll();
	}
	
	public Optional<PontoVenda> buscarPorCodigo(Integer codigo) {
		return repository.findByCodigo(codigo);
	}
	
	public List<PontoVenda> buscarTodosAtivos() {
		return repository.findByAtivoTrue();
	}

	public List<PontoVendaDTO> buscarTodosAtivosDTO() {
		List<PontoVenda> list = repository.findByAtivoTrue();
		if(list != null) {
			Type type = new TypeToken<List<PontoVendaDTO>>() {}.getType();
			List<PontoVendaDTO> listDTO = modelMapper.map(list, type);
			return listDTO;
		}
		return null;
	}
	
	public Optional<PontoVenda> buscarPorId(Long id) {
		return repository.findById(id);
	}

	public PontoVendaDTO buscarPorIdDTO(Long id) {
		Optional<PontoVenda> pontoVenda = repository.findById(id);
		if(pontoVenda.isPresent()) {
			return modelMapper.map(pontoVenda, PontoVendaDTO.class);
		}
		return null;
	}

}
