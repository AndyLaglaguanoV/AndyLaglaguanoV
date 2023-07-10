
package poo_u2_practica_16_polimorfismo;


public class  Circulo extends Figura  {
    private int radio;

    public Circulo(int radio, String color) {
        super(color);
        this.radio = radio;
    }
    @Override 
    public double superficie (){
        return Math.PI*radio*radio;
        
    }
    
}
