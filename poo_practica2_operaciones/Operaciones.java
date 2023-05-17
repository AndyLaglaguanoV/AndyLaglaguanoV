/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo_practica2_operaciones;
import javax.swing.JOptionPane;

/**
 *
 * @author PC-MASTER
 */
public class Operaciones {
    
      int nu1;
    int nu2;
    int suma;  
    int resta;  int multiplicacion;  int division;
   
   
    public void capturarnumeros() {
   
    nu1=Integer.parseInt(JOptionPane.showInputDialog("Digite su primer numero numero"));
    nu2=Integer.parseInt(JOptionPane.showInputDialog("Digite un numero"));    
    }
    public void sumar() {
       
    suma=nu1+nu2;
   
}
//generamor de metodos
    //pedimos numeros
    //nuestro metodos  es publico
   
   
     public void resultados() {
       
 System.out.println("El resultado de la suma es:"+suma);
    
 
 }

}
