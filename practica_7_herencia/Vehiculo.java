/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica_7_herencia;

/**
 *
 * @author PC-MASTER
 */
public class Vehiculo {
    
    String placa;
    int numeroRuedas;
    boolean encendido;
    String  estado;
     

public void setnumeroRuedas(int ruedas ) {
numeroRuedas = ruedas;

}
public void encendido(){
    encendido=true;
    estado="Vehiculo encendido";
    
}
public void apagado(){
    encendido=false;
    estado="Vehiculo apagado";
}    
}