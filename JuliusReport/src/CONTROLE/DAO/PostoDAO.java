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
import ENTIDADES.Posto;
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
public class PostoDAO implements DAO {

    @Override
    public void salvar(Object o) throws SQLException, IOException {
        if (o instanceof Posto) {
            
            Posto posto = (Posto) o;
            String sql = "INSERT INTO Posto VALUES (?,?)";
            Connection con = new ConnectionFactory().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, posto.getNome());
            ps.setString(2, posto.getLocal());
            ps.execute();
            System.out.println("Posto registrado");
            ps.close();
            con.close();
            
            
        } else {
            System.out.println("O objeto informado não é um Posto");
        }

    }

    @Override
    public void atualizar(Object o) {
        System.out.println("Não Implementado");
    }

    @Override
    public void excluir(Object o) {
        System.out.println("Não Implementado");
    }
    
    public ArrayList<Posto> getAll() throws IOException, SQLException {
        ArrayList<Posto> lista = new ArrayList();
        Connection con = new ConnectionFactory().getConnection();
        String sql = "SELECT rowid, Nome, Local FROM Posto ORDER BY rowid";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Posto posto = new Posto();
            posto.setIdPosto(rs.getInt(1));
            posto.setNome(rs.getString(2));
            posto.setLocal(rs.getString(3));
            lista.add(posto);
        }
        ps.close();
        con.close();
        return lista;
    }

}
