SELECT Rendimento.rowid, Rendimento.KmL, Rendimento.Trajeto, Rendimento.ArCond, Rendimento.Abastecimento
FROM Rendimento JOIN  Abastecimento ON Rendimento.Abastecimento = Abastecimento.rowid
WHERE Abastecimento.Veiculo = 1 ORDER BY Rendimento.Trajeto;


