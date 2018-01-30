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
import ENTIDADES.Abastecimento;
import ENTIDADES.Veiculo;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, veiculo.getTipo());
            ps.setString(2, veiculo.getMarca());
            ps.setString(3, veiculo.getModelo());
            ps.setInt(4, veiculo.getAno());
            ps.setString(5, veiculo.getCor());
            ps.setString(6, veiculo.getPlaca());
            ps.setInt(7, veiculo.getUsuario());
            ps.setString(8, veiculo.getAnotacoes());
            ps.execute();
            int lastId = 0;
            final ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                lastId = rs.getInt(1);
            }
            System.out.println("Veiculo Registrado.");
            ps.close();
            con.close();

            //inserção do abastecimento 0 para nao bugar o Rendimento
            /*
            As inserções de Rendimento originam-se a cada registro de 
            Abastecimento, estes registros apontam para a chave do 
            Abastecimento anterior do veículo atual do contexto, pois este
            rendimento diz respeito ao ultimo abastecimento, e não ao que está
            sendo registrado no momento. este terá seu rendimento calculado só
            após o próximo abastecimento.
            
             */
            AbastecimentoDAO dao = new AbastecimentoDAO();
            Abastecimento ab = new Abastecimento();
            try {
                ab.setData("0000-00-00");
            } catch (ParseException ex) {
                Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            ab.setPosto(0);
            ab.setTipoCombustivel(0);
            ab.setUsuario(veiculo.getUsuario());
            ab.setValorLitro(0.00);
            ab.setValorTotal(0.00);
            ab.setVeiculo(lastId);
            ab.setkm(0);
            dao.salvar(ab);

        } else {
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
