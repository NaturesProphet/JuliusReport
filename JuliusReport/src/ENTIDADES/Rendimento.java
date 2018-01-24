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

/**
 *
 * @author mgarcia
 */
public class Rendimento {
    private Double KmL;
    private int Trajeto; //referencia Trajeto.IdTrajeto
    private int ArCond; //inteiro representando o status do Ar Condicionado
    private int IdRendimento;
    private int Abastecimento; //referencia Abastecimento.IdAbastecimento
    
    public void setKmL (Double k) {
        this.KmL = k;
    }
    public void setTrajeto(int t) {
        this.Trajeto = t;
    }
    public void setArCond(int a) {
        this.ArCond = a;
    }
    public void setIdRendimento(int i) {
        this.IdRendimento = i;
    }
    public void SetAbastecimento(int a) {
        this.Abastecimento = a;
    }
    
    
    
    public Double getKmL() {
        return this.KmL;
    }
    public int getTrajeto() {
        return this.Trajeto;
    }
    public int getArCond() {
        return this.ArCond;
    }
    public int getIdRendimento() {
        return this.IdRendimento;
    }
    public int getAbastecimento() {
        return this.Abastecimento;
    }
}
