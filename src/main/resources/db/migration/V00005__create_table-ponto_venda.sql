CREATE TABLE ponto_venda(
    id SERIAL NOT NULL,
    codigo INTEGER UNIQUE NOT NULL,
    nome VARCHAR(255) NOT NULL,
    ativo BOOLEAN NOT NULL DEFAULT TRUE,
    data_criacao TIMESTAMP NOT NULL DEFAULT CURRENT_DATE,
    id_usuario_criacao INTEGER NOT NULL,
    data_atualizacao TIMESTAMP,
    id_usuario_atualizacao INTEGER
);

ALTER TABLE ponto_venda
   ADD PRIMARY KEY (id);

ALTER TABLE ponto_venda
	ADD CONSTRAINT fk_pv_usuario_criacao_id 
		FOREIGN KEY (id_usuario_criacao) 
			REFERENCES usuario(id);
ALTER TABLE ponto_venda
	ADD CONSTRAINT fk_pv_usuario_atualizacao_id 
		FOREIGN KEY (id_usuario_atualizacao) 
			REFERENCES usuario(id);
