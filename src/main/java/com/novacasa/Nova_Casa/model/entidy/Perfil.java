package com.novacasa.Nova_Casa.model.entidy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "perfil")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Perfil {

	  	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(length = 255, nullable = false)
	    private String descricao;

	    @Column(length = 125, nullable = false)
	    private String role;

	    @Column(nullable = false)
	    private boolean ativo = true;

	    @Column(name = "data_criacao", nullable = false)
	    private Date dataCriacao;

	    @Column(name = "id_usuario_criacao")
	    private Integer idUsuarioCriacao;

	    @Column(name = "data_atualizacao")
	    private Date dataAtualizacao;

	    @Column(name = "id_usuario_atualizacao")
	    private Integer idUsuarioAtualizacao;
}
