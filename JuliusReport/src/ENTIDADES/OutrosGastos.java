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
public class OutrosGastos {

    private Date Data;
    private Double Valor;
    private String Desc;
    private int IdVeiculo;
    private int IdOutrosGastos;

    
    public void setIdVeiculo(int id) {
        this.IdVeiculo = id;
    }
    
    public int getIdVeiculo(){
        return this.IdVeiculo;
    }
    
    public void setData(String d) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        this.Data = df.parse(d);
    }

    public void setData(Date d) {
        this.Data = d;
    }

    public void setValor(Double v) {
        this.Valor = v;
    }

    public void setDesc(String d) {
        this.Desc = d;
    }

    public void setIdOutrosGastos(int i) {
        this.IdOutrosGastos = i;
    }

    //retorna uma string formatada como dd/MM/yyyy com a data
    public String getDataAsString() {
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        return formatador.format(this.Data);
    }
    
    public Date getData() {
        return this.Data;
    }

    public Double getValor() {
        return this.Valor;
    }

    public String getDesc() {
        return this.Desc;
    }

    public int getIdOutrosGastos() {
        return this.IdOutrosGastos;
    }

}
