/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prueba;
import java.util.Scanner;
/**
 *
 * @author PC-MASTER
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 Scanner scanner = new Scanner(System.in);

         System.out.println("Bienvenido");
        System.out.println("Seleccione la figura que desea calcular");
        System.out.println("1. Cuadrado");
        System.out.println("2. Rectangulo");
        System.out.println("3. Triangulo");
        System.out.println("4. Pentagono");

        System.out.print("Elige una opcion: ");
        int opcion = scanner.nextInt();

        Figura figura = null;

        switch (opcion) {
            case 1:
                figura = new Cuadrado();
                break;
            case 2:
                figura = new Rectangulo();
                break;
            case 3:
                figura = new Triangulo();
                break;
            case 4:
                figura = new Pentagono();
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }

        if (figura != null) {
            figura.ingresarDatos();
            figura.calcularArea();
        }

        scanner.close();
    }
}