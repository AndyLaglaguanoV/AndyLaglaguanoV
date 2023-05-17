/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package metodo_con_argumentos;
import javax.swing.JOptionPane;
/**
 *
 * @author PC-MASTER
 */
public class Metodo_con_argumentos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         Operaciones op1 = new Operaciones ();
   
    int nu1=Integer.parseInt(JOptionPane.showInputDialog("Digite su primer numero numero"));
   int nu2=Integer.parseInt(JOptionPane.showInputDialog("Digite un numero"));  
   
   //llama a s variables
   op1.sumar(nu1, nu2);
   
    //presentamo los resultados
   
     op1.resultados();
    }
    
}
