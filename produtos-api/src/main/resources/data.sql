CREATE TABLE produto (
    id BIGINT NOT NULL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    descricao VARCHAR(300),
    preco NUMERIC(18,2)
);
