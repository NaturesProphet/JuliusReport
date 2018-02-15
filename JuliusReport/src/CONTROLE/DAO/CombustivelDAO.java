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
import ENTIDADES.Combustivel;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mgarcia
 */
public class CombustivelDAO implements DAO {

    @Override
    public void salvar(Object o) throws SQLException, IOException {
        if (o instanceof Combustivel) {
            Combustivel combustivel = (Combustivel) o;
            String sql = "INSERT INTO Combustivel VALUES (?)";
            Connection con = new ConnectionFactory().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, combustivel.getNome());
            ps.execute();
            System.out.println("Abastecimento registrado.");
            ps.close();
            con.close();

        } else {
            System.out.println("O objeto informado não pertende a classe Combustivel");
        }
    }

    @Override
    public void atualizar(Object o) {
        System.out.println("Método não implementado ainda..");
    }

    @Override
    public void excluir(Object o) {
        System.out.println("Método não implementado ainda..");
    }

    //retorna uma lista de strings simples contendo codigo e nome do combustivel
    public ArrayList<String> getAll() throws IOException, SQLException {
        ArrayList<String> lista = new ArrayList();
        Connection con = new ConnectionFactory().getConnection();
        String sql = "SELECT rowid, Nome FROM Combustivel ORDER BY rowid";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String x = "" + rs.getInt(1) + " - ";
            x += rs.getString(2);
            lista.add(x);
        }
        ps.close();
        con.close();
        rs.close();

        return lista;
    }

    public String getByID(int IdCombustivel) throws IOException, SQLException {
        Connection con = new ConnectionFactory().getConnection();
        String sql = "SELECT Nome FROM Combustivel WHERE rowid = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, IdCombustivel);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getString(1);
        }
        return "ERRO";
    }
}
