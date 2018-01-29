/*
Os IDs das tabelas não foram criados aqui
pois o SQLITE3 utiliza as rowid no lugar
das chaves primarias. estas rowids serao
recuperadas na aplicação e utilizadas nas
classes ao serem instanciadas a partir
dos dados do banco.

Sim, eu sei... o estilo é PHP mas o 
codigo é Java.. Não pergunte, só aceite.
*/
CREATE TABLE Usuario (
Login VARCHAR(40) UNIQUE NOT NULL,
Senha VARCHAR(255) NOT NULL
);

CREATE TABLE Veiculo (
Tipo VARCHAR(30) NOT NULL,
Marca VARCHAR(30) NOT NULL,
Modelo VARCHAR(45) NOT NULL,
Ano INT NOT NULL,
Cor VARCHAR(20),
Placa VARCHAR(8) UNIQUE NOT NULL,
Usuario INT NOT NULL,
Anotacoes VARCHAR(255),
CONSTRAINT FK_Veiculo_Usuario
FOREIGN KEY (Usuario)
REFERENCES Usuario (rowid)
);

CREATE TABLE Posto (
    Nome VARCHAR(30) UNIQUE NOT NULL,
    Local VARCHAR(255)
);

CREATE TABLE Combustivel (
	Nome VARCHAR(30) UNIQUE
);

CREATE TABLE Trajeto (
	Nome VARCHAR(30) UNIQUE
);

CREATE TABLE OutrosGastos (
	Data DATETIME,
	Valor FLOAT(5,2),
	Desc VARCHAR(255)
);

CREATE TABLE Abastecimento (
	Data DATETIME,
	ValorTotal FLOAT(5,2),
	TipoCombustivel INT,
	ValorLitro FLOAT(2,2),
  Posto VARCHAR(30),
  Usuario INT NOT NULL,
  Veiculo INT NOT NULL,
  km INT,
	CONSTRAINT FK_Abastecimento_Combustivel
	FOREIGN KEY (TipoCombustivel)
	REFERENCES Combustivel (rowid)
);

CREATE TABLE Rendimento (
	KmL FLOAT (2,2),
	Trajeto INT,
	ArCond VARCHAR(30),
	Abastecimento INT,
	CONSTRAINT FK_Rendimento_Abastecimento
	FOREIGN KEY (Abastecimento)
	REFERENCES Abastecimento (IdAbastecimento),
	CONSTRAINT FK_Rendimento_Trajeto
	FOREIGN KEY (Trajeto)
	REFERENCES Trajeto (rowid)
);

CREATE TABLE Manutencao (
	Data DATETIME,
	Km INT,
	ValorPecas FLOAT(5,2),
	ValorServ FLOAT(5,2),
	Servico VARCHAR(255) NOT NULL,
        Veiculo INT
);


/*
	INSERÇÕES DE DADOS BÁSICOS NO BANCO
*/

INSERT INTO Combustivel VALUES 
('Gasolina Comum'),
('Gasolina Aditivada'),
('Alcool Anidro');



INSERT INTO Trajeto VALUES
('Cidade - trafego moderado'),
('Cidade - trafego mediano'),
('Cidade - trafego intenso'),
('Trafego misto Cidade/Estrada'),
('Estrada - Montanhas'),
('Estrada - Planicies'),
('Estrada - condições diversas'),
('Estrada de chão/roça');

