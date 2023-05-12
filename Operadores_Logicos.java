/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package operadores_logicos;

/**
 *
 * @author PC-MASTER
 */
public class Operadores_Logicos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int valorM = 10;
        int valorL = 24;
        
        System.out.println((valorM== valorL)&& (valorM != valorL));//true 
        System.out.println((valorM== valorL)|| (valorM != valorL)); //true
        System.out.println(valorM != valorL);//false
        
    }
    
}
