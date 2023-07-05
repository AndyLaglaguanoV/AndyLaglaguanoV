
package poo_practica_14_interfaces;


public class Circulo  implements Figura, Dibujar, Rotar, Redimensionar {
    double r;

    public Circulo(double r) {
        this.r = r;
    }

    @Override
    public double calcularArea() {
        double pi = 3.1416;
        double resul = pi * r * r;
        return resul;
    }

    @Override
    public void dibujar() {
        System.out.println("Vas a dibujar un circulo");
    }

    @Override
    public void rotar() {
        System.out.println("Estas rotando el circulo");
    }

    @Override
    public void redimensionar() {
        System.out.println("Estas redimensionando el circulo");
    }
}