/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba;
import java.util.Scanner;
/**
 *
 * @author PC-MASTER
 */
public class Pentagono extends Figura {
    private double lado;

    public Pentagono() {
        // Constructor vacío
    }

    @Override
    public void ingresarDatos() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa el lado 1 del pentagono: ");
        double lado1 = scanner.nextDouble();
        System.out.print("Ingresa el lado 2 : ");
        double lado2 = scanner.nextDouble();
        System.out.print("Ingresa el lado 3 : ");
        double lado3 = scanner.nextDouble();
        System.out.print("Ingresa el lado 4: ");
        double lado4 = scanner.nextDouble();
        System.out.print("Ingresa el lado 5: ");
        double lado5 = scanner.nextDouble();
        // Suponemos que los 5 lados son iguales en un pentágono regular
        lado = lado1; // Podrías usar cualquiera de los lados, ya que son iguales
    }

    @Override
    public void calcularArea() {
        area = (5 * lado * lado) / (4 * Math.tan(Math.toRadians(36)));
        System.out.println("El area del pentagono es: " + area);
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }
}
