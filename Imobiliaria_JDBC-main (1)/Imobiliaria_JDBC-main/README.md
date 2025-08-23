# Imobiliaria_JDBC

## Equipe

| Equipe     | Email                                |
|------------|--------------------------------------|
| Ana Maria  | ann.m.esp@gmail.com                  |
| Clemerson  | clemersonfreislebentroian@gmail.com  |

## Configurações

| Item           | Valor         |
|----------------|---------------|
| Banco de Dados | MySQL         |
| Schema         | poo_atividade |

## Diagrama de classe da UML

![Diagrama de classe](/DiagramaDeClasse.pdf)

## Diagrama MER

![MER](/DiagramaDeMER.pdf)

## Instruções SQL

Criação do schema e tabelas.
```SQL
-- Criação do schema
CREATE SCHEMA IF NOT EXISTS poo_atividade;
USE poo_atividade;

-- Tabela CLIENTE
CREATE TABLE IF NOT EXISTS CLIENTE (
	CLI_ID INT AUTO_INCREMENT PRIMARY KEY,
	CLI_NOME VARCHAR(255) NOT NULL,
	CLI_CPF VARCHAR (11) NOT NULL,
	CLI_IDADE INT NOT NULL
);

-- Tabela IMOVEL
CREATE TABLE IF NOT EXISTS IMOVEL (
	IMO_ID INT AUTO_INCREMENT PRIMARY KEY,
	IMO_NOME VARCHAR(255) NOT NULL,
	IMO_ENDERECO VARCHAR(255) NOT NULL,
	IMO_VALOR FLOAT NOT NULL
);

-- Tabela CONTRATO
CREATE TABLE IF NOT EXISTS CONTRATO (
	CON_ID INT AUTO_INCREMENT PRIMARY KEY,
	CON_VALOR FLOAT NOT NULL,
	IMO_VALOR FLOAT, FOREIGN KEY (IMO_VALOR) REFERENCES IMOVEL (IMO_VALOR),
	CON_OFERTA FLOAT,
	CON_DATAINICIO TIMESTAMP NOT NULL,
	CON_DATAFIM TIMESTAMP NOT NULL,
	CLI_ID INT, FOREIGN KEY (CLI_ID) REFERENCES CLIENTE (CLI_ID),
  IMO_ID INT, FOREIGN KEY (IMO_ID) REFERENCES IMOVEL (IMO_ID)
);

```

Inserção de registros.
```SQL
-- Inserção de clientes
INSERT INTO CLIENTE (COLUNAS) VALUES 
('Apartamento Centro', 'Rua das Flores, 100', 1200.00),
('Casa Bairro Norte', 'Av. Brasil, 250', 2000.00),
('Kitnet Estudantil', 'Rua Universitária, 45', 800.00);

-- Inserção de imóveis
INSERT INTO IMOVEL (COLUNAS) VALUES
('João Silva', '12345678901', 30),
('Maria Souza', '98765432100', 25),
('Carlos Pereira', '11122233344', 40);

-- Inserção de contratos]
INSERT INTO CONTRATO (COLUNAS) VALUES
(1200.00, 1200.00, 0.00, '2025-01-01', '2026-01-01', 1, 1),
(2000.00, 2000.00, 100.00, '2023-01-01', '2024-01-01', 2, 2),
(800.00, 800.00, 50.00, '2026-01-01', '2027-01-01', 3, 3);
```



