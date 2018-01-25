/*
 * Copyright (C) 2018 mgarcia.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package TESTES;

import CONTROLE.AbastecimentoDAO;
import CONTROLE.CombustivelDAO;
import CONTROLE.ConnectionFactory;
import ENTIDADES.Abastecimento;
import ENTIDADES.Combustivel;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mgarcia
 */
public class teste {
    public static void main(String[] args) {
        Abastecimento a = new Abastecimento();
        a.setData(new Date());
        a.setTipoCombustivel(1);
        a.setValorTotal(150.0);
        a.setValorLitro(3.88);
        AbastecimentoDAO aD = new AbastecimentoDAO();
        aD.salvar(a);
    
    }
}
