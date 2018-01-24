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
package ENTIDADES;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mgarcia
 */
public class Manutencao {
    public Date Data;
    public int Km;
    public Double ValorPecas;
    public Double ValorServ;
    public String Servico;
    public int IdManutencao;
    
    
    
    public void setData(String d) throws ParseException{
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        this.Data = df.parse(d);
    }
    
    public void setData(Date d) {
        this.Data = d;
    }
    
    public void setKm(int k) {
        this.Km = k;
    }
    
    public void setValorPecas(Double v) {
        this.ValorPecas = v;
    }
    
    public void setValorServ(Double v) {
        this.ValorServ = v;
    }
    
    public void setServico(String s) {
        this.Servico = s;
    }
    
    public void setIdManutencao(int i) {
        this.IdManutencao = i;
    }
    
    
    
    //retorna uma string formatada como dd/MM/yyyy com a data
    public String getData() {
        SimpleDateFormat in= new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
 
        try {
             return out.format(in.parse(this.Data.toString()));
        } catch (ParseException ex) {
            Logger.getLogger(Abastecimento.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro em Manutencao.getData()");
        }
        return "00/00/0000";
    }
    
    public int getKm() {
        return this.Km;
    }
    
    public Double getValorPecas() {
        return this.ValorPecas;
    }
    
    public Double getValorServ() {
        return this.ValorServ;
    }
    
    public String getServico() {
        return this.Servico;
    }
    
    public int getIdManutencao() {
        return this.IdManutencao;
    }
    
    
    
    
    
    
    
    
}
