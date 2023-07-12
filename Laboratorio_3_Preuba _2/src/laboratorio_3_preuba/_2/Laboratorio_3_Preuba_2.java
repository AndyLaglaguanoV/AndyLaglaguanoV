
package laboratorio_3_preuba._2;
import java.util.Scanner;

public class Laboratorio_3_Preuba_2 {

  //Clase principal
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
        int opcion;

        ProductoEstandar productoEstand1 = null;
        ProductoEstandar productoEstand2 = null;
        ProductoOfertado productoOf1 = null;
        ProductoOfertado productoOf2 = null;
        ProductoOfertado productoOf3 = null;
// Utilizamos un blucle do
        do {
            System.out.println("Bienvenidos a nuestro programa:");
            System.out.println("=== Menu de opciones ===");
            System.out.println("1. Ingresar productos");
            System.out.println("2. Calcular total del pedido");
            System.out.println("3. Salir");
            System.out.print("Ingrese una opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Ingresar productos
                    scanner.nextLine(); // Consumir el salto de línea pendiente

                    System.out.println("=== Ingresar productos ===");
                    System.out.println("Productos estandar:");
                    System.out.print("Nombre del producto  1: ");
                    String nombreEst1 = scanner.nextLine();
                    System.out.print("Precio del producto  1: ");
                    double precioEst1 = scanner.nextDouble();
                    System.out.print("Seccion del producto  1: ");
                    scanner.nextLine(); // Consumir el salto de línea pendiente
                    String seccionEst1 = scanner.nextLine();

                    productoEstand1 = new ProductoEstandar(nombreEst1, precioEst1, seccionEst1);

                    System.out.print("Nombre del producto  2: ");
                    String nombreEst2 = scanner.nextLine();
                    System.out.print("Precio del producto  2: ");
                    double precioEst2 = scanner.nextDouble();
                    System.out.print("Seccion del producto  2: ");
                    scanner.nextLine(); // Consumir el salto de línea pendiente
                    String seccionEst2 = scanner.nextLine();

                    productoEstand2 = new ProductoEstandar(nombreEst2, precioEst2, seccionEst2);

                    System.out.println("Productos ofertados:");
                    System.out.print("Nombre del producto ofertado 1: ");
                    String nombreOf1 = scanner.nextLine();
                    System.out.print("Precio del producto ofertado 1: ");
                    double precioOf1 = scanner.nextDouble();
                    System.out.print("Dias restantes de oferta para el producto ofertado 1: ");
                    int diasOf1 = scanner.nextInt();

                    productoOf1 = new ProductoOfertado(nombreOf1, precioOf1, diasOf1);

                    System.out.print("Nombre del producto ofertado 2: ");
                    String nombreOf2 = scanner.nextLine();
                    System.out.print("Precio del producto ofertado 2: ");
                    double precioOf2 = scanner.nextDouble();
                    System.out.print("Dias restantes de oferta para el producto ofertado 2: ");
                    int diasOf2 = scanner.nextInt();

                    productoOf2 = new ProductoOfertado(nombreOf2, precioOf2, diasOf2);

                    System.out.print("Nombre del producto ofertado 3: ");
                    String nombreOf3 = scanner.nextLine();
                    System.out.print("Precio del producto ofertado 3: ");
                    double precioOf3 = scanner.nextDouble();
                    System.out.print("Dias restantes de oferta para el producto ofertado 3: ");
                    int diasOf3 = scanner.nextInt();

                    productoOf3 = new ProductoOfertado(nombreOf3, precioOf3, diasOf3);

                    break;
                case 2:
                    // Calcular total del pedido
                    if (productoEstand1 == null || productoEstand2 == null || productoOf1 == null ||
                            productoOf2 == null || productoOf3 == null) {
                        System.out.println("No se han ingresado todos los productos necesarios.");
                    } else {
                        System.out.println("=== Calcular total del pedido ===");
                        int unidadesPedidas = 5;
                        double totalPedido = productoEstand1.obtenerPrecioPedido(unidadesPedidas)
                                + productoEstand2.obtenerPrecioPedido(unidadesPedidas)
                                + productoOf1.obtenerPrecioPedido(unidadesPedidas)
                                + productoOf2.obtenerPrecioPedido(unidadesPedidas)
                                + productoOf3.obtenerPrecioPedido(unidadesPedidas);

                        System.out.println("Total del pedido: " + totalPedido);
                    }

                    break;
                case 3:
                    // Salir del programa
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion invalida..");
                    break;
            }

            System.out.println();
        } while (opcion != 3);

        scanner.close();
    }
}
        