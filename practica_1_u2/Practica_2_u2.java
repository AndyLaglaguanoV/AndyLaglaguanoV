/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica_2_u2;

/**
 *
 * @author PC-MASTER
 */
public class Practica_2_u2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
  
   int numero[] = new int[5];
        try {
            numero[7] = 0;
        } catch (ArrayIndexOutOfBoundsException error) {
            System.out.println("Se genero una excepcion al acceder al arreglo");
        }
    }
        // TODO code application logic here
}