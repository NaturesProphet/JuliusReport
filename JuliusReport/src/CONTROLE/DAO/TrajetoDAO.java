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
import ENTIDADES.Trajeto;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mgarcia
 */
public class TrajetoDAO implements DAO {

    @Override
    public void salvar(Object o) throws SQLException, IOException {
        if (o instanceof Trajeto) {
            Trajeto trajeto = (Trajeto) o;
            String sql = "INSERT INTO Trajeto VALUES (?)";
            Connection con = new ConnectionFactory().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, trajeto.getNome());
            ps.execute();
            System.out.println("Trajeto registrado.");
            ps.close();
            con.close();
        } else {
            System.out.println("O objeto informado não é um Trajeto");
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

    public ArrayList<Trajeto> getAll() throws IOException, SQLException {
        ArrayList<Trajeto> lista = new ArrayList();
        Connection con = new ConnectionFactory().getConnection();
        String sql = "SELECT rowid, Nome FROM Trajeto ORDER BY rowid";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Trajeto trajeto = new Trajeto();
            trajeto.setIdTrajeto(rs.getInt(1));
            trajeto.setNome(rs.getString(2));
            lista.add(trajeto);
        }
        ps.close();
        con.close();
        return lista;
    }

    public String getByID(int IdTrajeto) throws IOException, SQLException {
        Connection con = new ConnectionFactory().getConnection();
        String sql = "SELECT Nome FROM Trajeto WHERE rowid = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, IdTrajeto);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getString(1);
        }
        return "ERRO";
    }

}
