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
public class Rectangulo extends Figura {
    private double base;
    private double altura;

    public Rectangulo() {
        // Constructor vacío
    }

    @Override
    public void ingresarDatos() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa la base del rectangulo: ");
        base = scanner.nextDouble();
        System.out.print("Ingresa la altura del rectangulo: ");
        altura = scanner.nextDouble();
    }

    @Override
    public void calcularArea() {
        area = base * altura;
        System.out.println("El area del rectangulo es: " + area);
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
}