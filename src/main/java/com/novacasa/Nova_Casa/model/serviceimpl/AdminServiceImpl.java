package com.novacasa.Nova_Casa.model.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.novacasa.Nova_Casa.model.entidy.Usuario;
import com.novacasa.Nova_Casa.model.exception.ErroAutenticacao;
import com.novacasa.Nova_Casa.model.exception.RegraNegocioException;
import com.novacasa.Nova_Casa.model.repository.AdminRepository;
import com.novacasa.Nova_Casa.model.service.AdminService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminRepository repository;

	@Override
	public Usuario salvarAdmin(Usuario usuario) {
		validarEmail(usuario.getEmail());
		return repository.save(usuario);
	}

	@Override
	public void validarEmail(String email) {
		boolean existe =  repository.existsByEmail(email);
		if(existe) {
			throw new RegraNegocioException("Já existe um usuário cadastrado com este email.");
			}
	}

	@Override
	public Optional<Usuario> obterPorId(Long id) {
        return repository.findById(id);

	}

	@Override
	public Usuario autenticar(String email, String senha) {
		// TODO Auto-generated method stub
		return null;
	}


	/*@Override
	public void atualizarStatus(Integer id, StatusAdmin status) {
		repository.findById(id)
		.map(admin -> {
			admin.setStatus(status);
			return repository.save(admin);
		}).orElseThrow(() -> new UsuarioNaoEncontradoException());
	}
	*/
}
