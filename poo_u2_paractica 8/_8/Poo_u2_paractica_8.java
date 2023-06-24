/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poo_u2_paractica._8;

/**
 *
 * @author PC-MASTER
 */
public class Poo_u2_paractica_8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Auto car1 = new Auto("JKF455", 4, false, false);
        Motocicleta moto1 = new Motocicleta("KJF345", 2,false);
        
        moto1.OnOff();
        car1.OnOff();
        moto1.OnOff();
        car1.OnOffParabrisas();
        car1.showNumRuedas();
        moto1.showNumRuedas();
        moto1.showPlaca();
        car1.showPlaca();
    }      
  

} 

