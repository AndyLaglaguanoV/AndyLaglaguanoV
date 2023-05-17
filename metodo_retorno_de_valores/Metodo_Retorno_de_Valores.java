/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package metodo_retorno_de_valores;
import javax.swing.JOptionPane;
/**
 *
 * @author PC-MASTER
 */
public class Metodo_Retorno_de_Valores {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         Operaciones op1 = new Operaciones();      
       
    int nu1=Integer.parseInt(JOptionPane.showInputDialog("Deme numero"));
    int nu2=Integer.parseInt(JOptionPane.showInputDialog("Digite numero"));    
        // TODO code application logic here
       
       
        int ope=op1.sumar(nu1,nu2);
        op1.resultados(ope);
       
       
  System.out.println("El resultado de la suma es:"+op1.sumar(nu1, nu2));
        
        // TODO code application logic here
    }
    
}
