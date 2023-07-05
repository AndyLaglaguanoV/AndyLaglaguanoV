
package poo_practica_14_interfaces;
import java.util.Scanner;

public class POO_Practica_14_Interfaces {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Seleccione una figura:");
            System.out.println("1. Circulo");
            System.out.println("2. Cuadrado");
            System.out.println("3. Triangulo");
            System.out.println("4. Salir");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    crearCirculo(scanner);
                    break;
                case 2:
                    crearCuadrado(scanner);
                    break;
                case 3:
                    crearTriangulo(scanner);
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }
    }

    private static void crearCirculo(Scanner scanner) {
        System.out.println("Ingrese el radio del circulo:");
        double radio = scanner.nextDouble();

        Circulo circulo = new Circulo(radio);
        double areaCirculo = circulo.calcularArea();

        System.out.println("Area del circulo: " + areaCirculo);
        circulo.dibujar();
        circulo.rotar();
        circulo.redimensionar();
    }

    private static void crearCuadrado(Scanner scanner) {
        System.out.println("Ingrese el lado del cuadrado:");
        double lado = scanner.nextDouble();

        Cuadrado cuadrado = new Cuadrado(lado);
        double areaCuadrado = cuadrado.calcularArea();

        System.out.println("Area del cuadrado: " + areaCuadrado);
        cuadrado.dibujar();
        cuadrado.redimensionar();
    }

    private static void crearTriangulo(Scanner scanner) {
        System.out.println("Ingrese la base del triangulo:");
        double base = scanner.nextDouble();

        System.out.println("Ingrese la altura del triangulo:");
        double altura = scanner.nextDouble();

        Triangulo triangulo = new Triangulo(base, altura);
        double areaTriangulo = triangulo.calcularArea();

        System.out.println("Area del triangulo: " + areaTriangulo);
        triangulo.dibujar();
        triangulo.rotar();
    }
}

interface Figura {
    double calcularArea();
}

interface Dibujar {
    void dibujar();
}

interface Rotar {
    void rotar();
}

interface Redimensionar {
    void redimensionar();
}
