package com.novacasa.Nova_Casa.Controller;

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

import com.novacasa.Nova_Casa.model.entidy.Perfil;
import com.novacasa.Nova_Casa.model.service.PerfilService;

import java.util.List;

@RestController
@RequestMapping("/api/perfil")
public class PerfilController {

	private final PerfilService service;
	
	 @Autowired
	   public PerfilController(PerfilService service) {
	       this.service = service;
	    }
	 
	 @GetMapping
	 public ResponseEntity<List<Perfil>> listarTodos(){
		 List<Perfil> perfil = service.listarTodos();
		 return ResponseEntity.ok(perfil);
	 }
	 
	 @GetMapping("/{id}")
	 public ResponseEntity<Perfil> obterPorId(@PathVariable Long id){
		 Optional<Perfil> perfil = service.obterPorId(id);
		 return perfil.map(ResponseEntity::ok)
	                .orElse(ResponseEntity.notFound().build());
	 }
	 
	 @PostMapping
	 public ResponseEntity<Perfil> salvar(@RequestBody Perfil perfil){
		 Perfil salvar = service.salvar(perfil);
		 return ResponseEntity.status(HttpStatus.CREATED).body(salvar);
	 }
	 
	 @PutMapping("{id}")
	 public ResponseEntity<Perfil> atualizarPerfil(@PathVariable Long id,@RequestBody Perfil perfil ){
		 Perfil perfilAtualizado = service.atualizarPerfil(id, perfil);
		 
		 if (perfilAtualizado != null) {
	            return ResponseEntity.ok(perfilAtualizado);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	 }
	 
	 
	 @DeleteMapping("/{id}")
	    public ResponseEntity<Void> excluirPerfil(@PathVariable Long id) {
	        service.excluirPerfil(id);
	        return ResponseEntity.noContent().build();
	    }
	
	
}
