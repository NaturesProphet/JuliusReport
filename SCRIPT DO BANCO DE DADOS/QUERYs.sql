SELECT Rendimento.rowid, Rendimento.KmL, Rendimento.Trajeto, Rendimento.ArCond
FROM Rendimento JOIN  Abastecimento ON Rendimento.Abastecimento = Abastecimento.rowid
WHERE Abastecimento.Veiculo = 1;


