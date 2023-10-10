package com.novacasa.Nova_Casa.model.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.novacasa.Nova_Casa.model.entidy.Perfil;
import com.novacasa.Nova_Casa.model.exception.RegraNegocioException;
import com.novacasa.Nova_Casa.model.repository.PerfilRepository;
import com.novacasa.Nova_Casa.model.service.PerfilService;

@Service
@Transactional
public class PerfilServiceImpl implements PerfilService {
	
	private final PerfilRepository repository;
	
	 @Autowired
	  public PerfilServiceImpl(PerfilRepository repository) {
	        this.repository = repository;
	    }

	@Override
	public List<Perfil> listarTodos() {
		return repository.findAll();
	}

	@Override
	public Perfil salvar(Perfil perfil) {
		return repository.save(perfil);
	}

	@Override
	public Perfil atualizarPerfil(Long id, Perfil novoPerfil) {
		Optional<Perfil> perfilOptional = repository.findById(id);

        if (perfilOptional.isPresent()) {
            Perfil perfil = perfilOptional.get();
            perfil.setDescricao(novoPerfil.getDescricao());
            perfil.setRole(novoPerfil.getRole());
            perfil.setAtivo(novoPerfil.isAtivo());
            
            return repository.save(perfil);
        } else {
            throw new RegraNegocioException("Perfil não encontrado");
        }
	}

	@Override
	public void excluirPerfil(Long id) {
		repository.deleteById(id);
		
	}

	@Override
	public Optional<Perfil> obterPorId(Long id) {
		return repository.findById(id);
	}

}
