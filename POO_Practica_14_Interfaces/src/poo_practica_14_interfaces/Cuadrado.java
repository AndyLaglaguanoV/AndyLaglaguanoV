
package poo_practica_14_interfaces;


public class Cuadrado implements Figura, Dibujar, Redimensionar {
    double lado;

    public Cuadrado(double lado) {
        this.lado = lado;
    }

    @Override
    public double calcularArea() {
        double resul = lado * lado;
        return resul;
    }

    @Override
    public void dibujar() {
        System.out.println("Vas a dibujar un cuadrado");
    }

    @Override
    public void redimensionar() {
        System.out.println("Estas redimensionando el cuadrado");
    }
}
