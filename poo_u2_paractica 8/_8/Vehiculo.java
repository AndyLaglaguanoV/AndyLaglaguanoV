/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo_u2_paractica._8;

/**
 *
 * @author PC-MASTER
 */
public class Vehiculo {
    public String numPlaca;
    public int numRuedas;
    public boolean boolEncendido;
    
    public Vehiculo (String numPlaca, int numRuedas, boolean Encendio){
           
           this.numPlaca = numPlaca;
           this.numRuedas = numRuedas;
           this.boolEncendido = boolEncendido;
           
           
        public void OnOfparabrisas(){
      if(this.boolEncendido){
          this.boolEncendido= false;
      }else{
          this.boolEncendido=true;
      }
      return;
          
      }

    public boolean isParabrisas() {
        return parabrisas;
    }

    public void setParabrisas(boolean parabrisas) {
        this.parabrisas = parabrisas;
    }

    public String getNumPlaca() {
        return numPlaca;
    }

    public void setNumPlaca(String numPlaca) {
        this.numPlaca = numPlaca;
    }

    public int getNumRuedas() {
        return numRuedas;
    }

    public void setNumRuedas(int numRuedas) {
        this.numRuedas = numRuedas;
    }

    public boolean isBoolEncendido() {
        return boolEncendido;
    }

    public void setBoolEncendido(boolean boolEncendido) {
        this.boolEncendido = boolEncendido;
    }
  
  }
             
    

