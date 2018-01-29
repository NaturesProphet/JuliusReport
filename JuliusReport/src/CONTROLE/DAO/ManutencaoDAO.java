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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mgarcia
 */
public class ManutencaoDAO implements DAO {

    @Override
    public void salvar(Object o) throws SQLException, IOException{
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

}
