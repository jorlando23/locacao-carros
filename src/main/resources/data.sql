INSERT INTO tb_cliente (nome, telefone, email, endereco, created_at) VALUES ('LEANDRO', '(67) 99999-9999', 'leandro@gmail.com', 'Rua Andromeda', now());
INSERT INTO tb_cliente (nome, telefone, email, endereco, created_at) VALUES ('LEANDRO', '(67) 99999-9999', 'leandro@gmail.com', 'Rua Andromeda', now());
INSERT INTO tb_cliente (nome, telefone, email, endereco, created_at) VALUES ('LEANDRO', '(67) 99999-9999', 'leandro@gmail.com', 'Rua Andromeda', now());


INSERT INTO tb_vendedor (codigo, nome, email, telefone, created_at) VALUES ('7617', 'Jorlando R', 'jorlando@ifms.edu.br', '(67) 3461-2750',now());
INSERT INTO tb_vendedor (codigo, nome, email, telefone, created_at) VALUES ('7617', 'Jorlando R', 'jorlando@ifms.edu.br', '(67) 3461-2750',now());
INSERT INTO tb_vendedor (codigo, nome, email, telefone, created_at) VALUES ('7617', 'Jorlando R', 'jorlando@ifms.edu.br', '(67) 3461-2750',now());


INSERT INTO tb_carro (carro, patrimonio, id_cliente_fk, created_at) VALUES ('Palio', 'J.R locacoes', 2,  now());
INSERT INTO tb_carro (carro, patrimonio, id_cliente_fk, created_at) VALUES ('Palio', 'J.R locacoes', 1,  now());
INSERT INTO tb_carro (carro, patrimonio, id_cliente_fk, created_at) VALUES ('Palio', 'J.R locacoes', 3,  now());





INSERT INTO tb_contrato_aluguel(data_Locacao, data_Devolucao, prioridade, status, id_cliente_fk, created_at) VALUES ('2022-01-01', '2022-08-10', 'Baixa', 'PENDENTE', 2, now());
INSERT INTO tb_contrato_aluguel(data_Locacao, data_Devolucao, prioridade, status, id_cliente_fk, created_at) VALUES ('2022-01-01', '2022-08-10', 'Baixa', 'PENDENTE', 2, now());
INSERT INTO tb_contrato_aluguel(data_Locacao, data_Devolucao, prioridade, status, id_cliente_fk, created_at) VALUES ('2022-01-01', '2022-08-10', 'Baixa', 'PENDENTE', 2, now());


INSERT INTO tb_contrato_has_carro(id_contrato, id_carro) VALUES (1, 3);
INSERT INTO tb_contrato_has_carro(id_contrato, id_carro) VALUES (2, 1);
INSERT INTO tb_contrato_has_carro(id_contrato, id_carro) VALUES (3, 2);
