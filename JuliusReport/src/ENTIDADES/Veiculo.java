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
public class Veiculo {

    private String Tipo;
    private String Marca;
    private String Modelo;
    private int Ano;
    private String Cor;
    private String Placa;
    private int Usuario;
    private int IdVeiculo;

    public void setTipo(String t) {
        this.Tipo = t;
    }

    public String getTipo() {
        return this.Tipo;
    }

    public void setMarca(String m) {
        this.Marca = m;
    }

    public String getMarca() {
        return this.Marca;
    }

    public void setModelo(String m) {
        this.Modelo = m;
    }

    public String getModelo() {
        return this.Modelo;
    }

    public void setAno(int a) {
        this.Ano = a;
    }

    public int getAno() {
        return this.Ano;
    }

    public void setCor(String c) {
        this.Cor = c;
    }

    public String getCor() {
        return this.Cor;
    }

    public void setPlaca(String p) {
        this.Placa = p;
    }

    public String getPlaca() {
        return this.Placa;
    }

    public void setUsuario(int u) {
        this.Usuario = u;
    }

    public int getUsuario() {
        return this.Usuario;
    }

    public void setIdVeiculo(int i) {
        this.IdVeiculo = i;
    }

    public int getIdVeiculo() {
        return this.IdVeiculo;
    }
    
    @Override
    public String toString() {
        return this.getMarca() + " " + this.getModelo() + " " + this.getAno()
                + this.getCor() + ", Placa " + this.getPlaca();
    }
}
