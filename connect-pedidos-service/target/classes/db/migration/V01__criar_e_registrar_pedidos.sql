CREATE TABLE pedido (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	numero_controle VARCHAR(50) NOT NULL,
	data_cadastro DATE NOT NULL,
	nome_produto VARCHAR(50) NOT NULL,
	valor_produto DECIMAL(10,2) NOT NULL,
	quantidade INTEGER,
	codigo_cliente VARCHAR(50)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO pedido (numero_controle, data_cadastro, nome_produto, valor_produto, quantidade, codigo_cliente) values ('111111', '2010-11-01','Produto A', 12.60, 3, 'AX54687');