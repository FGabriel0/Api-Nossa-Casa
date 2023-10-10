package com.novacasa.Nova_Casa.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.novacasa.Nova_Casa.model.entidy.PerfilUsuario;
import com.novacasa.Nova_Casa.model.service.perfilUsuarioService;

@RestController
@RequestMapping("/api/perfilusuario")
public class PerfilUsuarioController {
	
	private final perfilUsuarioService service;
	
	@Autowired
	public PerfilUsuarioController(perfilUsuarioService service) {
		this.service = service;
	}
	
	 @PostMapping
	    public ResponseEntity<PerfilUsuario> salvarUsuarioPerfil(@RequestBody PerfilUsuario usuarioPerfil) {
		 PerfilUsuario novoUsuarioPerfil = service.salvarUsuarioPerfil(usuarioPerfil);
	        return ResponseEntity.ok(novoUsuarioPerfil);
	    }

	    @GetMapping("/usuario/{idUsuario}")
	    public ResponseEntity<List<PerfilUsuario>> buscarUsuarioPerfisPorIdUsuario(@PathVariable Long idUsuario) {
	        List<PerfilUsuario> usuarioPerfis = service.buscarUsuarioPerfisPorIdUsuario(idUsuario);
	        return ResponseEntity.ok(usuarioPerfis);
	    }

	    @PutMapping("/usuario/{idUsuario}/perfil/{idPerfil}")
	    public ResponseEntity<PerfilUsuario> atualizarUsuarioPerfil(
	            @PathVariable Long idUsuario,
	            @PathVariable Long idPerfil,
	            @RequestBody PerfilUsuario novoUsuarioPerfil) {
	    	PerfilUsuario usuarioPerfilAtualizado = service.atualizarUsuarioPerfil(idUsuario, idPerfil, novoUsuarioPerfil);
	        return ResponseEntity.ok(usuarioPerfilAtualizado);
	    }

	    @DeleteMapping("/usuario/{idUsuario}/perfil/{idPerfil}")
	    public ResponseEntity<Void> excluirUsuarioPerfil(
	            @PathVariable Long idUsuario,
	            @PathVariable Long idPerfil) {
	    	service.excluirUsuarioPerfil(idUsuario, idPerfil);
	        return ResponseEntity.noContent().build();
	    }

	    @GetMapping("/listar")
	    public ResponseEntity<List<PerfilUsuario>> listarTodos() {
	        List<PerfilUsuario> usuarioPerfis = service.listarTodos();
	        return ResponseEntity.ok(usuarioPerfis);
	    }
}
