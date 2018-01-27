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
package CONTROLE;

import ENTIDADES.Usuario;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author mgarcia
 */
//verifica se o usuario possui algum Veículo e algum Posto cadastrado.
public class VerificadorBD {

    //verifica se o usuario possui algum Veículo e algum Posto cadastrado.
    public static boolean Verifica(Usuario u) throws IOException, SQLException {
        Connection con = new ConnectionFactory().getConnection();
        String sql1 = "SELECT Count(*) FROM Veiculo WHERE Veiculo.Usuario = ?";
        PreparedStatement ps = con.prepareStatement(sql1);
        ps.setInt(1, u.getIdUsuario());
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            if (rs.getInt(1) == 0) {
                rs.close();
                ps.close();
                con.close();
                return false;
            }
        }

        Connection con2 = new ConnectionFactory().getConnection();
        String sql2 = "SELECT Count(*) FROM Posto";
        PreparedStatement ps2 = con.prepareStatement(sql2);
        ResultSet rs2 = ps2.executeQuery();
        while (rs2.next()) {
            if (rs2.getInt(1) == 0) {
                rs2.close();
                con2.close();
                return false;
            }
        }

        return true;
    }
}
