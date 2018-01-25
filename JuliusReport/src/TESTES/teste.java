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
package TESTES;

import CONTROLE.DAO.TrajetoDAO;
import ENTIDADES.Trajeto;


/**
 *
 * @author mgarcia
 */
public class teste {
    public static void main(String[] args) {
       Trajeto t = new Trajeto();
       TrajetoDAO tD = new TrajetoDAO();
       
       t.setNome("Cidade");
       tD.salvar(t);
       t.setNome("Estrada - Montanhas");
       tD.salvar(t);
       t.setNome("Estrada - Planicies");
       tD.salvar(t);
       t.setNome("Estrada - condições diversas");
       tD.salvar(t);
       t.setNome("Trafego Misto Cidade/Estrada");
       tD.salvar(t);
       
        
        
    
    }
}
