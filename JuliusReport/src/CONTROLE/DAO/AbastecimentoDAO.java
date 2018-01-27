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
import CONTROLE.ManipuladorData;
import ENTIDADES.Abastecimento;
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
public class AbastecimentoDAO implements DAO {

    @Override
    public void salvar(Object c) throws SQLException, IOException {
        if (c instanceof Abastecimento) {
            Abastecimento abastecimento = (Abastecimento) c;
            //formatador me ajudará a manipular as datas nos processos de I/O no DB
            SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
            String sql = "INSERT INTO Abastecimento VALUES(?,?,?,?,?,?,?)";
            Connection con = new ConnectionFactory().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, formatador.format(abastecimento.getData())); //so proud to understand dat shit
            ps.setDouble(2, abastecimento.getValorTotal());
            ps.setInt(3, abastecimento.getTipoCombustivel());
            ps.setDouble(4, abastecimento.getValorLitro());
            ps.setString(5, abastecimento.getPosto());
            ps.setInt(6, abastecimento.getUsuario());
            ps.setInt(7, abastecimento.getVeiculo());
            ps.execute();
            System.out.println("Abastecimento registrado.");
            ps.close();
            con.close();

        } else {
            System.out.println("O objeto informado não é da classe Abastecimento");
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

    //retorna uma lista com todos os registros de Abastecimento
    public ArrayList<Abastecimento> getAll(int IdUsuario, int IdVeiculo) throws IOException, SQLException {
        ArrayList<Abastecimento> lista = new ArrayList();
        Connection con = new ConnectionFactory().getConnection();
        String sql = "SELECT rowid, * FROM Abastecimento WHERE "
                + "Abastecimento.Usuario = ? AND Veiculo = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, IdUsuario);
        ps.setInt(2, IdVeiculo);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Abastecimento a = new Abastecimento();
            a.setIdAbastecimento(rs.getInt(1));
            try {
                a.setData(rs.getString(2));
            } catch (ParseException ex) {
                Logger.getLogger(AbastecimentoDAO.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Erro ao converter String em Data\n" + ex);
            }
            a.setValorTotal(rs.getDouble(3));
            a.setTipoCombustivel(rs.getInt(4));
            a.setValorLitro(rs.getDouble(5));
            a.setPosto(rs.getString(6));
            a.setUsuario(rs.getInt(7));
            a.setVeiculo(rs.getInt(8));

            lista.add(a);

        }
        rs.close();
        ps.close();
        con.close();

        return lista;
    }

}
