INSERT INTO perfil(id, descricao, role) VALUES(1, 'Administrador', 'ADMINISTRADOR');
INSERT INTO perfil(id, descricao, role) VALUES(2, 'Responsável Trailer', 'TRAILER');
INSERT INTO perfil(id, descricao, role) VALUES(3, 'Responsável Loja', 'LOJA');
INSERT INTO perfil(id, descricao, role) VALUES(4, 'Responsável Casa', 'CASA');

SELECT setval('perfil_id_seq', 4, false); 
