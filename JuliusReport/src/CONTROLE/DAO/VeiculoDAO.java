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
import ENTIDADES.Veiculo;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author mgarcia
 */
public class VeiculoDAO implements DAO {

    @Override
    public void salvar(Object o) throws SQLException, IOException {
        if (o instanceof Veiculo) {
            Veiculo veiculo = (Veiculo) o;
            String sql = "INSERT INTO Veiculo VALUES (?,?,?,?,?,?,?,?)";
                Connection con = new ConnectionFactory().getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, veiculo.getTipo());
                ps.setString(2, veiculo.getMarca());
                ps.setString(3, veiculo.getModelo());
                ps.setInt(4, veiculo.getAno());
                ps.setString(5, veiculo.getCor());
                ps.setString(6, veiculo.getPlaca());
                ps.setInt(7, veiculo.getUsuario());
                ps.setString(8, veiculo.getAnotacoes());
            
                ps.execute();
                System.out.println("Veiculo Registrado.");
                ps.close();
                con.close();
            
        }else {
            System.out.println("O objeto informado não é um Veículo");
        }

    }

    @Override
    public void atualizar(Object o) {
        System.out.println("Não implementado");
    }

    @Override
    public void excluir(Object o) {
        System.out.println("Não implementado");
    }
    
}
