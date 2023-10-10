package com.novacasa.Nova_Casa.model.entidy;


import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuario_perfil")
@Getter
@Setter

public class PerfilUsuario {
	
	   @Id
	   @Column(name = "id_usuario")
	   private Long idUsuario;

	    @Id
	    @Column(name = "id_perfil")
	    private Long idPerfil;

	    @ManyToOne
	    @JoinColumn(name = "id_usuario", referencedColumnName = "id", insertable = false, updatable = false)
	    private Admin usuario;

	    @ManyToOne
	    @JoinColumn(name = "id_perfil", referencedColumnName = "id", insertable = false, updatable = false)
	    private Perfil perfil;

	  

}
