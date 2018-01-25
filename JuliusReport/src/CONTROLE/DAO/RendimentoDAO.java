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
package CONTROLE.DAO;

import CONTROLE.ConnectionFactory;
import ENTIDADES.Rendimento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mgarcia
 */
public class RendimentoDAO implements DAO {

    @Override
    public void salvar(Object o) throws SQLException{
        if (o instanceof Rendimento) {
            Rendimento rendimento = (Rendimento) o;
            String sql = "INSERT INTO Rendimento VALUES(?,?,?,?)";
                Connection con = new ConnectionFactory().getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setDouble(1, rendimento.getKmL());
                ps.setInt(2, rendimento.getTrajeto());
                ps.setInt(3,rendimento.getArCond());
                ps.setInt(4, rendimento.getAbastecimento());
                ps.execute();
                System.out.println("Rendimento Registrado.");

        } else {
            System.out.println("O objeto informado não é da classe Rendimento");
        }

    }

    @Override
    public void atualizar(Object o) {
        System.out.println("Não implementado..");
    }

    @Override
    public void excluir(Object o) {
        System.out.println("Não implementado..");
    }

}
