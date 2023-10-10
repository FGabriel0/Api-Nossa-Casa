CREATE TABLE usuario(
    id SERIAL NOT NULL,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(125) NOT NULL,
  	senha VARCHAR(500) NOT NULL,
    ativo BOOLEAN NOT NULL DEFAULT TRUE,
    data_criacao TIMESTAMP NOT NULL DEFAULT CURRENT_DATE,
    id_usuario_criacao INTEGER,
    data_atualizacao TIMESTAMP,
    id_usuario_atualizacao INTEGER
);

ALTER TABLE usuario
   ADD PRIMARY KEY (id);
