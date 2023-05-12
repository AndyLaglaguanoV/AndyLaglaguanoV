/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica_ramdom;

/**
 *
 * @author PC-MASTER
 */
public class Practica_Ramdom {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println( Math.random());
        // PARA HACERLO DE DOS DIGITOS
        System.out.println( Math.random()*100);
        // Los convertimos a entero
        System.out.println((int)(Math.random()*100 ));
    }
    
}
