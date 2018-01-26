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
import ENTIDADES.Usuario;
import ENTIDADES.Veiculo;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mgarcia
 */
public class UsuarioDAO implements DAO {

    @Override
    public void salvar(Object o) throws SQLException, IOException {
        if (o instanceof Usuario) {
            Usuario usuario = (Usuario) o;
            String sql = "INSERT INTO Usuario VALUES (?,?)";
            Connection con = new ConnectionFactory().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getLogin());
            ps.setString(2, usuario.getSenha());
            ps.execute();
            System.out.println("Usuario registrado.");

        } else {
            System.out.println("O objeto informado nao é um usuario.");
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

    public Usuario getByLogin(String login) {
        String sql = "SELECT rowid, Login, Senha FROM Usuario WHERE Login = ?";

        try {
            Connection con = new ConnectionFactory().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt(1));
                usuario.setlogin(rs.getString(2));
                usuario.setSenha(rs.getString(3));

                //recuperando também os veiculos da frota do usuario
                String sql2 = "SELECT rowid, * FROM Veiculo WHERE Usuario = ?";
                try {
                    Connection con2 = new ConnectionFactory().getConnection();
                    PreparedStatement ps2 = con2.prepareStatement(sql2);
                    ps2.setInt(1, usuario.getIdUsuario());
                    ResultSet rs2 = ps2.executeQuery();
                    while (rs2.next()) {
                        Veiculo veiculo = new Veiculo();
                        veiculo.setIdVeiculo(rs2.getInt(1));
                        veiculo.setTipo(rs2.getString(2));
                        veiculo.setMarca(rs2.getString(3));
                        veiculo.setModelo(rs2.getString(4));
                        veiculo.setAno(rs2.getInt(5));
                        veiculo.setCor(rs2.getString(6));
                        veiculo.setPlaca(rs2.getString(7));
                        veiculo.setUsuario(rs2.getInt(8));

                        usuario.addToFrota(veiculo);
                        System.out.println("Veiculo gerado:\n"+veiculo.toString());
                    }
                } catch (SQLException e) {
                    System.out.println("Erro ao tentar recuperar os carros da Frota\n"+e);
                }

                return usuario;
            }

        } catch (SQLException e) {
            System.out.println("Usuario nao foi encontrado");
        } catch (IOException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
