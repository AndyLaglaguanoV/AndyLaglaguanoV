
package poo_practica_13__unidad_2_clase_abstracta;

public class Circulo    extends Figura {
double r;

    public Circulo (){
    }
 public Circulo(double r,double x,double y){
     super(x,y);
     this.r=r;
 }  
@Override
public double calcularArea(){
    double pi=3.1416;
    double resul=pi*r*r;
    return resul;
    
}
}