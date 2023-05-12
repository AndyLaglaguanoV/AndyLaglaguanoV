/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica_06_condicionales;

/**
 *
 * @author PC-MASTER
 */
public class Practica_06_condicionales {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // sentencia if (condicional)
        int hora = -5;
        if (hora >= 0 && hora <= 12){
             System.out.println("BUENOS DIAS ");
        }else{ if( hora >12 && hora <= 18){
            
                 System.out.println("BUENAS TARDES");
                 
        }else{
                 System.out.println("BUENAS NOCHES");
        }
        
        }
    }
    
}
