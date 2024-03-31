package com.novacasa.Nova_Casa.model.entidy;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table( name = "ponto_venda" , schema = "public")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PontoVenda {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "codigo")
	private Integer codigo;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "ativo")
	private Boolean ativo;
	
	@Column(name = "data_criacao")
	private LocalDateTime dataCriacao;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario_criacao")
	private Usuario usuarioCriacao;
	
	@Column(name = "data_atualizacao")
	private LocalDateTime dataAtualizacao;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario_atualizacao")
	private Usuario usuarioAtualizacao;
	
}
