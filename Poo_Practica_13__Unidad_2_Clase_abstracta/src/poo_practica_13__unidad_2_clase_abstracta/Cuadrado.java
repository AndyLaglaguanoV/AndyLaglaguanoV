/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo_practica_13__unidad_2_clase_abstracta;

/**
 *
 * @author PC-MASTER
 */
public class Cuadrado  extends Figura {
double lado;
    public Cuadrado (){
    }
 public Cuadrado(double lado,double x,double y){
     super(x,y);
     this.lado=lado;
 }  
@Override
public double calcularArea(){
    double resul=lado*lado;
    return resul;
    
}
}
