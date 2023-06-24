/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica_2_segunda.unidad;

/**
 *
 * @author PC-MASTER
 */
public class Practica_2_segundaUnidad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        

   int numero[] = new int[5];
        try {
            numero[7] = 0;
        } catch (ArrayIndexOutOfBoundsException error) {
            System.out.println("Se generó una excepción al acceder al arreglo");
        }
    }
        // TODO code application logic here
}