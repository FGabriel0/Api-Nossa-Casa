CREATE TABLE perfil(
    id SERIAL NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    role VARCHAR(125) NOT NULL,
    ativo BOOLEAN NOT NULL DEFAULT TRUE,
    data_criacao TIMESTAMP NOT NULL DEFAULT CURRENT_DATE,
    id_usuario_criacao INTEGER,
    data_atualizacao TIMESTAMP,
    id_usuario_atualizacao INTEGER
);

ALTER TABLE perfil
   ADD PRIMARY KEY (id); 
