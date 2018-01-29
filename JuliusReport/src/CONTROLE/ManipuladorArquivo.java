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
package CONTROLE;

/**
 *
 * @author mgarcia
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class ManipuladorArquivo {
 
    public static String ler(String path) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
           String linha = buffRead.readLine();
        buffRead.close();
        return linha;
    }
 
    public static void escrever(String path, String content) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
        buffWrite.append(content + "\n");
        buffWrite.close();
    }
    
    public static void main(String[] args) {
        try {
            escrever("BD.dat","jr.db");
        } catch (IOException ex) {
            Logger.getLogger(ManipuladorArquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
}
