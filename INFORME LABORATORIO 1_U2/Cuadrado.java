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
public class Cuadrado extends Figura {
    private double lado;

    public Cuadrado() {
        // Constructor vacío
    }

    @Override
    public void ingresarDatos() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa el lado 1 del cuadrado: ");
        double lado1 = scanner.nextDouble();
        System.out.print("Ingresa el lado 2 : ");
        double lado2 = scanner.nextDouble();
        System.out.print("Ingresa el lado 3 : ");
        double lado3 = scanner.nextDouble();
        System.out.print("Ingresa el lado 4 : ");
        double lado4 = scanner.nextDouble();

        // Verificar si los lados son iguales
        if (lado1 == lado2 && lado1 == lado3 && lado1 == lado4) {
            lado = lado1;
        } else {
            System.out.println("Los lados no forman un cuadrado valido.");
            // Salir del programa o solicitar nuevamente los lados
        }
    }

    @Override
    public void calcularArea() {
        area = lado * lado;
        System.out.println("El area del cuadrado es: " + area);
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }
}
