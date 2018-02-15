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
import ENTIDADES.OutrosGastos;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mgarcia
 */
public class OutrosGastosDAO implements DAO {

    @Override
    public void salvar(Object o) throws SQLException, IOException {
        if (o instanceof OutrosGastos) {
             SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
            OutrosGastos outrosgastos = (OutrosGastos) o;
            String sql = "INSERT INTO OutrosGastos VALUES (?,?,?,?)";
            Connection con = new ConnectionFactory().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, formatador.format(outrosgastos.getData()));
            
            ps.setDouble(2, outrosgastos.getValor());
            ps.setString(3, outrosgastos.getDesc());
            ps.setInt(4, outrosgastos.getIdVeiculo());
            ps.execute();
            System.out.println("Outros Gastos registrado.");
            ps.close();
            con.close();

        } else {
            System.out.println("O objeto informado não é um OutrosGastos");
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

    public ArrayList<OutrosGastos> getAll(int IdVeiculo) throws IOException, SQLException, ParseException {
        ArrayList<OutrosGastos> lista = new ArrayList<OutrosGastos>();
        Connection con = new ConnectionFactory().getConnection();
        String sql = "SELECT rowid, * FROM OutrosGastos WHERE Veiculo = ? ";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, IdVeiculo);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            OutrosGastos og = new OutrosGastos();
            og.setIdOutrosGastos(rs.getInt(1));
            try {
                og.setData(rs.getString(2));
            } catch (ParseException ex) {
                Logger.getLogger(AbastecimentoDAO.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Erro ao converter String em Data\n" + ex);
            }
            og.setValor(rs.getDouble(3));
            og.setDesc(rs.getString(4));
            lista.add(og);
        }
        rs.close();
        ps.close();
        con.close();

        return lista;
    }

}
