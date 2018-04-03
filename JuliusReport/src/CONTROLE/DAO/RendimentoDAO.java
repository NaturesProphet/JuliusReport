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
public class RendimentoDAO implements DAO {

    @Override
    public void salvar(Object o) throws SQLException, IOException {
        if (o instanceof Rendimento) {
            Rendimento rendimento = (Rendimento) o;
            AbastecimentoDAO abdao = new AbastecimentoDAO();

            if (abdao.getById(rendimento.getAbastecimento()).getPosto() != 0) {

                String sql = "INSERT INTO Rendimento VALUES(?,?,?,?)";
                Connection con = new ConnectionFactory().getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setDouble(1, rendimento.getKmL());
                ps.setInt(2, rendimento.getTrajeto());
                ps.setString(3, rendimento.getArCond());
                ps.setInt(4, rendimento.getAbastecimento());
                ps.execute();
                System.out.println("Rendimento Registrado.");
                ps.close();
                con.close();
            } else {
                System.out.println("O abastecimento informado é o ponto zero.\n"
                        + "Abastecimento não registrado.");
            }
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
    
    public ArrayList<Rendimento> getAll(int IdVeiculo) throws IOException, SQLException {
        ArrayList<Rendimento> lista = new ArrayList();
        StringBuilder query = new StringBuilder();
        query.append("SELECT Rendimento.rowid, Rendimento.KmL, ");
        query.append("Rendimento.Trajeto, Rendimento.ArCond, ");
        query.append("Rendimento.Abastecimento ");
        query.append("FROM Rendimento JOIN  Abastecimento ON ");
        query.append("Rendimento.Abastecimento = Abastecimento.rowid ");
        query.append("WHERE Abastecimento.Veiculo = ? ");
        query.append("ORDER BY Abastecimento.Data");
        
        Connection con = new ConnectionFactory().getConnection();
        PreparedStatement ps = con.prepareStatement(query.toString());
        ps.setInt(1, IdVeiculo);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Rendimento r = new Rendimento();
            r.setIdRendimento(rs.getInt(1));
            r.setKmL(rs.getDouble(2));
            r.setTrajeto(rs.getInt(3));
            r.setArCond(rs.getString(4));
            r.SetAbastecimento(rs.getInt(5));
            lista.add(r);
        }
        rs.close();
        ps.close();
        con.close();
        
        return lista;
    }
    
    
    
    

}
