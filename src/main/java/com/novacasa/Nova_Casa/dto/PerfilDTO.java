package com.novacasa.Nova_Casa.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PerfilDTO {
	private Long id;
    private String descricao;
    private String role;
    private boolean ativo;
    private Date dataCriacao;
    private Integer idUsuarioCriacao;
    private Date dataAtualizacao;
    private Integer idUsuarioAtualizacao;
}
