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
import ENTIDADES.Manutencao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mgarcia
 */
public class ManutencaoDAO implements DAO {

    @Override
    public void salvar(Object o) throws SQLException, IOException {
        if (o instanceof Manutencao) {
            Manutencao manutencao = (Manutencao) o;
            String sql = "INSERT INTO Manutencao VALUES (?,?,?,?,?,?)";
            Connection con = new ConnectionFactory().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, manutencao.getDataAsString());
            ps.setInt(2, manutencao.getKm());
            ps.setDouble(3, manutencao.getValorPecas());
            ps.setDouble(4, manutencao.getValorServ());
            ps.setString(5, manutencao.getServico());
            ps.setInt(6, manutencao.getVeiculo());
            ps.execute();
            System.out.println("Manutencao registrada.");
            ps.close();
            con.close();

        } else {
            System.out.println("O objeto informado não é um Manutencao");
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

    public ArrayList<Manutencao> getAll(int IdVeiculo) throws IOException, SQLException, ParseException {
        ///////
        ArrayList<Manutencao> lista = new ArrayList<Manutencao>();
        Connection con = new ConnectionFactory().getConnection();
        String sql = "SELECT rowid, * FROM Manutencao WHERE Veiculo = ? ";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, IdVeiculo);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Manutencao a = new Manutencao();
            a.setIdManutencao(rs.getInt(1));
            try {
                a.setData(rs.getString(2));
            } catch (ParseException ex) {
                Logger.getLogger(AbastecimentoDAO.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Erro ao converter String em Data\n" + ex);
            }
            a.setKm(rs.getInt(3));
            a.setValorPecas(rs.getDouble(4));
            a.setValorServ(rs.getDouble(5));
            a.setServico(rs.getString(6));

            lista.add(a);

        }
        rs.close();
        ps.close();
        con.close();

        return lista;
    }

}
