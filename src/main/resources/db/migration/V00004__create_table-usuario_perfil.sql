CREATE TABLE IF NOT EXISTS usuario_perfil (
    id_usuario BIGINT NOT NULL,
    id_perfil BIGINT NOT NULL,
    CONSTRAINT pk_usuario_perfil PRIMARY KEY (id_usuario, id_perfil),
    CONSTRAINT fk_usuario_perfil_perfil FOREIGN KEY (id_perfil) REFERENCES perfil(id),
    CONSTRAINT fk_usuario_perfil_usuario FOREIGN KEY (id_usuario) REFERENCES usuario(id)
); 