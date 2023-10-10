package com.novacasa.Nova_Casa.model.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.novacasa.Nova_Casa.model.entidy.PerfilUsuario;
import com.novacasa.Nova_Casa.model.exception.RegraNegocioException;
import com.novacasa.Nova_Casa.model.repository.PerfilUsuarioRepository;
import com.novacasa.Nova_Casa.model.service.perfilUsuarioService;

@Service
public class PerfilUsuarioServiceImpl implements perfilUsuarioService {
	
	private final PerfilUsuarioRepository repository;
	
	@Autowired
	public PerfilUsuarioServiceImpl(PerfilUsuarioRepository repository) {
		this.repository = repository;
	}
	@Override
    public PerfilUsuario salvarUsuarioPerfil(PerfilUsuario usuarioPerfil) {
        return repository.save(usuarioPerfil);
    }

    @Override
    public List<PerfilUsuario> buscarUsuarioPerfisPorIdUsuario(Long idUsuario) {
        return repository.findByIdUsuario(idUsuario);
    }

    @Override
    public PerfilUsuario atualizarUsuarioPerfil(Long idUsuario, Long idPerfil, PerfilUsuario novoUsuarioPerfil) {
        PerfilUsuario usuarioPerfilExistente = repository.findByIdUsuarioAndIdPerfil(idUsuario, idPerfil)
                .orElseThrow(() -> new RegraNegocioException("UsuarioPerfil não encontrado"));

        usuarioPerfilExistente.setUsuario(novoUsuarioPerfil.getUsuario());
        usuarioPerfilExistente.setPerfil(novoUsuarioPerfil.getPerfil());

        return repository.save(usuarioPerfilExistente);
    }

    @Override
    public void excluirUsuarioPerfil(Long idUsuario, Long idPerfil) {
        repository.deleteByIdUsuarioAndIdPerfil(idUsuario, idPerfil);
    }

    @Override
    public List<PerfilUsuario> listarTodos() {
        return repository.findAll();
    }
}
