
package poo_u2_practica_16_polimorfismo;


public class Rectangulo extends Figura{
     private int base;
       private int altura;

    public Rectangulo(int base, int altura, String color) {
        super(color);
        this.base = base;
        this.altura = altura;
    }
       @Override
    public double superficie() {
        return base*altura;
    
}
}