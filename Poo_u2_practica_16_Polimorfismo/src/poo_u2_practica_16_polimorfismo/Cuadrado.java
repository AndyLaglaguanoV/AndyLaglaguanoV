
package poo_u2_practica_16_polimorfismo;


public class Cuadrado extends Figura  {
    private int lado;
       

    public Cuadrado(int  lado, String color) {
       super(color);
        this.lado = lado;
    }

    @Override
    public double superficie () {
        double resul = lado * lado;
        return resul;
    }

}