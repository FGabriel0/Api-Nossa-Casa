package com.novacasa.Nova_Casa.model.serviceimpl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.novacasa.Nova_Casa.controller.form.UsuarioPerfilForm;
import com.novacasa.Nova_Casa.model.entidy.Perfil;
import com.novacasa.Nova_Casa.model.entidy.Usuario;
import com.novacasa.Nova_Casa.model.entidy.UsuarioPerfil;
import com.novacasa.Nova_Casa.model.exception.RegraNegocioException;
import com.novacasa.Nova_Casa.model.repository.AdminRepository;
import com.novacasa.Nova_Casa.model.repository.PerfilRepository;
import com.novacasa.Nova_Casa.model.repository.UsuarioPerfilRepository;
import com.novacasa.Nova_Casa.model.service.UsuarioPerfilService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioPerfilImpl implements UsuarioPerfilService{

	private final UsuarioPerfilRepository repository;
	private final AdminRepository usuarioRepository;
	private final PerfilRepository perfilRepository;
		
	@Override
	@Transactional
	public UsuarioPerfil salvar(UsuarioPerfilForm dto) {
				
		Long idUsuario = dto.getIdUsuario();
		Long idPerfil = dto.getIdPerfil();

		Usuario usuario = usuarioRepository.findById(idUsuario)
				.orElseThrow(()-> new RegraNegocioException("Usuário não encontrado"));
		
		Perfil perfil = perfilRepository.findById(idPerfil)
				.orElseThrow(() -> new RegraNegocioException("Perfil não Encontrado"));
		
		UsuarioPerfil usuarioPerfil = new UsuarioPerfil();
		usuarioPerfil.setUsuario(usuario);
		usuarioPerfil.setPerfil(perfil);
		
		return repository.save(usuarioPerfil);
		
	}
	
	
	@Override
	public Optional<UsuarioPerfil> obterPorId(Long id) {
		 return repository.findById(id);

	}
	


}
