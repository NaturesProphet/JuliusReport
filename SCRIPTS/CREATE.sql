CREATE TABLE Combustivel (
	Nome VARCHAR(30),
	IdCombustivel INT AUTO_INCREMENT PRIMARY KEY
);

CREATE TABLE Trajeto (
	Nome VARCHAR(30),
	IdTrajeto INT AUTO_INCREMENT PRIMARY KEY
);

CREATE TABLE OutrosGastos (
	Data DATETIME,
	Valor FLOAT(5,2),
	Desc VARCHAR(255),
	IdOutrosGastos INT AUTO_INCREMENT PRIMARY KEY
);

CREATE TABLE Abastecimento (
	Data DATETIME,
	ValorTotal FLOAT(5,2),
	TipoCombustivel INT,
	ValorLitro FLOAT(2,2),
	IdAbastecimento INT AUTO_INCREMENT PRIMARY KEY,
	CONSTRAINT FK_Abastecimento_Combustivel
	FOREIGN KEY (TipoCombustivel)
	REFERENCES Combustivel (IdCombustivel)
);

CREATE TABLE Rendimento (
	KmL FLOAT (2,2),
	Trajeto INT,
	ArCond INT,
	IdRendimento INT AUTO_INCREMENT PRIMARY KEY,
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
	Servico VARCHAR(255) NOT NULL,
	IdManutencao INT AUTO_INCREMENT PRIMARY KEY
);
