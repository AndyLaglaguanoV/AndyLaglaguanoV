
package poo_practica_14_interfaces;

public class  Triangulo  implements Figura, Dibujar, Rotar {
    double base;
    double altura;

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        double resul = (base * altura) / 2;
        return resul;
    }

    @Override
    public void dibujar() {
        System.out.println("Vas a dibujar un triángulo");
    }

    @Override
    public void rotar() {
        System.out.println("Estas rotando el triángulo");
    }
}