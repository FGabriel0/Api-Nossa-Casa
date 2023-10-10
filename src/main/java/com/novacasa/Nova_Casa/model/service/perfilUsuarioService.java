package com.novacasa.Nova_Casa.model.service;

import java.util.List;

import com.novacasa.Nova_Casa.model.entidy.PerfilUsuario;

import java.util.List;

public interface perfilUsuarioService {

    PerfilUsuario salvarUsuarioPerfil(PerfilUsuario usuarioPerfil);

    List<PerfilUsuario> buscarUsuarioPerfisPorIdUsuario(Long idUsuario);

    PerfilUsuario atualizarUsuarioPerfil(Long idUsuario, Long idPerfil, PerfilUsuario novoUsuarioPerfil);

    void excluirUsuarioPerfil(Long idUsuario, Long idPerfil);

    List<PerfilUsuario> listarTodos();
}

