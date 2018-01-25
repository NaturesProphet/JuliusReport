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
package CONTROLE;

import ENTIDADES.Abastecimento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mgarcia
 */
public class AbastecimentoDAO /*implements DAO*/ {

    //@Override
    public void salvar(Object c) {
        if (c instanceof Abastecimento) {
            Abastecimento abastecimento = (Abastecimento) c;
            //formatador me ajudará a manipular as datas nos processos de I/O no DB
            SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
            String sql = "INSERT INTO Abastecimento VALUES(?,?,?,?)";
            try {
                Connection con = new ConnectionFactory().getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, formatador.format(abastecimento.getData())); //so proud to understand dat shit
                ps.setDouble(2, abastecimento.getValorTotal());
                ps.setInt(3, abastecimento.getTipoCombustivel());
                ps.setDouble(4, abastecimento.getValorLitro());
                ps.execute();
                
                
                
            } catch (SQLException ex) {
                Logger.getLogger(AbastecimentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        } else {
            System.out.println("O objeto informado não é da classe Abastecimento");
        }
    }

}
