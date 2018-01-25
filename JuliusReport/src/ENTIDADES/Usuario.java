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
public class Usuario {
    private String Login;
    private String Senha;
    private int IdUsuario;
    
    public void setlogin(String n) {
        this.Login = n;
    }
    
    public void setSenha(String s) {
        this.Senha = s;
    }
    
    public void setIdUsuario(int id) {
        this.IdUsuario = id;
    }
    
    
    public int getIdUsuario() {
        return this.IdUsuario;
    }
    
    public String getLogin() {
        return this.Login;
    }
    
    public String getSenha() {
        return this.Senha;
    }
}
