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

/**
 *
 * @author mgarcia
 */
public class Abastecimento {
    private Date Data;
    private Double ValorTotal;
    private int TipoCombustivel; //referencia Combustivel.IdCombustivel
    private Double ValorLitro;
    private int Posto;
    private int Veiculo;
    private int Usuario;
    private int km;
    private int IdAbastecimento;
    
    public void setVeiculo(int v) {
        this.Veiculo = v;
    }
    
    public int getVeiculo() {
        return this.Veiculo;
    }
    
    public void setUsuario(int i) {
        this.Usuario = i;
    }
    
    public int getUsuario(){
        return this.Usuario;
    }
    
    
    //recebe uma string dd/MM/yyyy como data e joga exceções pra cima
    public void setData(String d) throws ParseException{
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        this.Data = df.parse(d);
    }
    
    public void setData(Date d) {
        this.Data = d;
    }
    
    public void setValorTotal(Double v) {
        this.ValorTotal = v;
    }
    
    public void setTipoCombustivel(int t) {
        this.TipoCombustivel = t;
    }
    
    public void setValorLitro(Double v) {
        this.ValorLitro = v;
    }
    
    public void setPosto(int p) {
        this.Posto = p;
    }
    
    public void setIdAbastecimento(int i) {
        this.IdAbastecimento = i;
    }
    
    //retorna uma string formatada como dd/MM/yyyy com a data
    public String getDataAsString() {
        return CONTROLE.UTIL.Data.getDataAsStringBR(this.Data);
    }
    
    public Date getData() {
        return this.Data;
    }

    public Double getValorTotal() {
        return this.ValorTotal;
    }
    
    public int getTipoCombustivel() {
        return this.TipoCombustivel;
    }
    
    public Double getValorLitro() {
        return this.ValorLitro;
    }
    
    public int getPosto() {
        return this.Posto;
    }
    
    public int getIdAbastecimento() {
        return this.IdAbastecimento;
    }
    
    public void setkm(int k) {
        this.km = k;
    }
    
    public int getkm() {
        return this.km;
    }
}
