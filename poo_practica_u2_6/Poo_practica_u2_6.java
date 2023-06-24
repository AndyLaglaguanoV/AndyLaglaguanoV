/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poo_practica_u2_6;
import java.io.*;


/**
 *
 * @author PC-MASTER
 */
public class Poo_practica_u2_6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try(BufferedReader br=new BufferedReader(new FileReader("C:\\Users\\PC-MASTER\\Documents\\Practica_u2.txt"));
        BufferedWriter bw=new BufferedWriter(new FileWriter("C:\\Users\\PC-MASTER\\Documents\\Practica_u2.txt"));){
        
        bw.write ("Esto es una prueba usando BufferedWriter");
        bw.newLine();
        bw.write("Seguimos usando BUffered");
        bw.newLine();
        bw.write("Hola a todos");
        
        bw.flush();
        
        String linea=br.readLine();
        while(linea!=null){
            System.out.println(linea);
            linea=br.readLine();
        }
    }catch(IOException e){
        System.out.println("Error E/S:"+e);
 
    }
    }
}