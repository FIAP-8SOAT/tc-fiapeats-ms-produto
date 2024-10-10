INSERT INTO CLIENTE (documento, email, nome)
VALUES ('87548309876', 'fulano@hotmail.com', 'Fulado da silva junior');
INSERT INTO CLIENTE (documento, email, nome)
VALUES ('98765467862', 'ciclano@gamail.com', 'Ciclano cavalcante dias');

INSERT INTO CATEGORIA(id, descricao)
VALUES (1, 'Lanche');
INSERT INTO CATEGORIA(id, descricao)
VALUES (2, 'Acompanhamento');
INSERT INTO CATEGORIA(id, descricao)
VALUES (3, 'Bebida');
INSERT INTO CATEGORIA(id, descricao)
VALUES (4, 'Sobremesa');

INSERT INTO STATUS_PAGAMENTO(id, descricao)
VALUES (1, 'Aguardando');
INSERT INTO STATUS_PAGAMENTO(id, descricao)
VALUES (2, 'Aprovado');
INSERT INTO STATUS_PAGAMENTO(id, descricao)
VALUES (3, 'Resusado');

INSERT INTO PRODUTO(valor, categoria_id, id, descricao, nome, imagem_url)
VALUES (9.90, 1, 'fc7c7f37-32ea-465c-ac4b-490685e5a55f', 'pao, salsicha, molho e ketchup', 'Cachorro quente', 'https://s2-receitas.glbimg.com/nhTnuFJn8-LKjqVgIn0tRvfyI3Y=/0x0:620x500/984x0/smart/filters:strip_icc()/s.glbimg.com/po/rc/media/2012/11/16/08_37_34_881_Cachorro_Quente_com_Leite_em_P_M_rcia_Cadore_Borin_620.jpg');
INSERT INTO PRODUTO(valor, categoria_id, id, descricao, nome, imagem_url)
VALUES (6, 3, 'fa0f9dde-b305-407b-869c-71045853dea8', 'Refrigerante 600ml de garrafa', 'Pepsi 600ml', 'https://io.convertiez.com.br/m/trimais/shop/products/images/846/medium/refrigerante-pepsi-600-ml_842.jpg');

INSERT INTO PEDIDO(tempo_espera, valor_total, data_hora_criacao, id_status, id_pedido, cliente_documento, status_pagamento_id)
VALUES (10, 99.80, NOW(), 1, 'd212192c-8155-440a-9eda-3d77732458bb', null, 1);
INSERT INTO PEDIDO(tempo_espera, valor_total, data_hora_criacao, id_status, id_pedido, cliente_documento, status_pagamento_id)
VALUES (10, 275.01, NOW(), 1, '6d597e32-62b5-4b1e-9696-eb794bbae188', '98765467862', 1);

INSERT INTO PEDIDO_PRODUTOS(pedido_entity_id_pedido, produtos_id)
VALUES ('d212192c-8155-440a-9eda-3d77732458bb', 'fc7c7f37-32ea-465c-ac4b-490685e5a55f');
INSERT INTO PEDIDO_PRODUTOS(pedido_entity_id_pedido, produtos_id)
VALUES ('d212192c-8155-440a-9eda-3d77732458bb', 'fa0f9dde-b305-407b-869c-71045853dea8');
INSERT INTO PEDIDO_PRODUTOS(pedido_entity_id_pedido, produtos_id)
VALUES ('6d597e32-62b5-4b1e-9696-eb794bbae188', 'fa0f9dde-b305-407b-869c-71045853dea8');