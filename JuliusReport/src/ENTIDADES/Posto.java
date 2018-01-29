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
public class Posto {
    private String Nome;
    private String Local;
    private int IdPosto;
    
    
    public void setNome(String n) {
        this.Nome = n;
    }
    public String getNome() {
        return this.Nome;
    }
    
    public void setLocal(String l) {
        this.Local = l;
    }
    public String getLocal(){
        return this.Local;
    }
    
    public void setIdPosto(int i) {
        this.IdPosto = i;
    }
    public int getIdPosto(){
        return this.IdPosto;
    }
}
