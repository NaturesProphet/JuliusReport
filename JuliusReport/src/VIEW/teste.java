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
package VIEW;

import CONTROLE.DAO.AbastecimentoDAO;
import CONTROLE.DAO.CombustivelDAO;
import CONTROLE.DAO.RendimentoDAO;
import ENTIDADES.Abastecimento;
import ENTIDADES.Rendimento;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mgarcia
 */
public class teste {

    public static void main(String[] args) {
        RendimentoDAO rdao = new RendimentoDAO();
        ArrayList<Rendimento> lista = new ArrayList();
        try {
            lista = rdao.getAll(1);
        } catch (IOException ex) {
            Logger.getLogger(teste.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(teste.class.getName()).log(Level.SEVERE, null, ex);
        }

        for(int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).getAbastecimento());
        }
        
        
    }
}
