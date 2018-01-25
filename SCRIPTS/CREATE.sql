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
	CONSTRAINT FK_Abastecimento_Combustivel
	FOREIGN KEY (TipoCombustivel)
	REFERENCES Combustivel (IdCombustivel)
);

CREATE TABLE Rendimento (
	KmL FLOAT (2,2),
	Trajeto INT,
	ArCond INT,
	Abastecimento INT,
	CONSTRAINT FK_Rendimento_Abastecimento
	FOREIGN KEY (Abastecimento)
	REFERENCES Abastecimento (IdAbastecimento),
	CONSTRAINT FK_Rendimento_Trajeto
	FOREIGN KEY (Trajeto)
	REFERENCES Trajeto (IdTrajeto)
);

CREATE TABLE Manutencao (
	Data DATETIME,
	Km INT,
	ValorPecas FLOAT(5,2),
	ValorServ FLOAT(5,2),
	Servico VARCHAR(255) NOT NULL
);


/*
	INSERÇÕES DE DADOS BÁSICOS NO BANCO
*/

INSERT INTO Combustivel VALUES 
('Gasolina Comum'),
('Gasolina Aditivada'),
('Alcool Anidro');



INSERT INTO Trajeto VALUES
('Cidade'),
('Trafego misto Cidade/Estrada'),
('Estrada - Montanhas'),
('Estrada - Planicies'),
('Estrada - condições diversas');
