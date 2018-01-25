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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mgarcia
 */
public class OutrosGastosDAO implements DAO {

    @Override
    public void salvar(Object o) {
        if (o instanceof OutrosGastos) {
            OutrosGastos outrosgastos = (OutrosGastos) o;
            String sql = "INSERT INTO OutrosGastos VALUES (?,?,?)";
            try {
                Connection con = new ConnectionFactory().getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, outrosgastos.getDataAsString());
                ps.setDouble(2, outrosgastos.getValor());
                ps.setString(3, outrosgastos.getDesc());
                ps.execute();
                System.out.println("Outros Gastos registrado.");

            } catch (SQLException ex) {
                Logger.getLogger(CombustivelDAO.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Erro " + ex);
            }

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

}
