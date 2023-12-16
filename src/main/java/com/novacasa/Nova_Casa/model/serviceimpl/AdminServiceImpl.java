package com.novacasa.Nova_Casa.model.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.novacasa.Nova_Casa.model.entidy.Admin;
import com.novacasa.Nova_Casa.model.exception.ErroAutenticacao;
import com.novacasa.Nova_Casa.model.exception.RegraNegocioException;
import com.novacasa.Nova_Casa.model.repository.AdminRepository;
import com.novacasa.Nova_Casa.model.service.AdminService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
	
	private AdminRepository repository;


	@Override
	public Admin autenticar(String email, String senha) {
		Optional<Admin> admin = repository.findByEmail(email);
		
		if(!admin.isPresent()) {
			throw new ErroAutenticacao("Usuário não encontrado para o email digitado");
		}
		
		if(!admin.get().getSenha().equals(senha)) {
			throw new ErroAutenticacao("Senha inválida.");

		}
		return admin.get();
	}


	@Override
	public Admin salvarAdmin(Admin admin) {
		validarEmail(admin.getEmail());
		return repository.save(admin);
	}

	@Override
	public void validarEmail(String email) {
		boolean existe =  repository.existsByEmail(email);
		if(existe) {
			throw new RegraNegocioException("Já existe um usuário cadastrado com este email.");
			}
	}

	@Override
	public Optional<Admin> obterPorId(Long id) {
        return repository.findById(id);

	}
	
}
