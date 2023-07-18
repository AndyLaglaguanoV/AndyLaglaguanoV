package gestion_productos;

import java.util.Scanner;

// Clase principal
public class Gestion_Productos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        ProductoEstandar productoEstandar1 = null;
        ProductoEstandar productoEstandar2 = null;
        ProductoOfertado productoOfertado1 = null;
        ProductoOfertado productoOfertado2 = null;
        ProductoOfertado productoOfertado3 = null;

        do {
            System.out.println("=== Menu de opciones ===");
            System.out.println("1. Ingresar productos");
            System.out.println("2. Calcular total del pedido");
            System.out.println("3. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea pendiente

            switch (opcion) {
                case 1:
                    System.out.println("=== Ingresar productos ===");
                    System.out.println("Productos estándar:");
                    System.out.print("Nombre del producto 1: ");
                    String nombreEst1 = scanner.nextLine();
                    System.out.print("Precio del producto 1: ");
                    double precioEst1 = scanner.nextDouble();
                    scanner.nextLine(); // Consumir el salto de línea pendiente
                    System.out.print("Sección del producto 1: ");
                    String seccionEst1 = scanner.nextLine();

                    productoEstandar1 = new ProductoEstandar(nombreEst1, precioEst1, seccionEst1);

                    System.out.print("Nombre del producto 2: ");
                    String nombreEst2 = scanner.nextLine();
                    System.out.print("Precio del producto 2: ");
                    double precioEst2 = scanner.nextDouble();
                    scanner.nextLine(); // Consumir el salto de línea pendiente
                    System.out.print("Sección del producto 2: ");
                    String seccionEst2 = scanner.nextLine();

                    productoEstandar2 = new ProductoEstandar(nombreEst2, precioEst2, seccionEst2);

                    System.out.println("Productos ofertados:");
                    System.out.print("Nombre del producto ofertado 1: ");
                    String nombreOf1 = scanner.nextLine();
                    System.out.print("Precio del producto ofertado 1: ");
                    double precioOf1 = scanner.nextDouble();
                    System.out.print("Días restantes de oferta para el producto ofertado 1: ");
                    int diasOf1 = scanner.nextInt();

                    productoOfertado1 = new ProductoOfertado(nombreOf1, precioOf1, diasOf1);

                    scanner.nextLine();
                    System.out.print("Nombre del producto ofertado 2: ");
                    String nombreOf2 = scanner.nextLine();
                    System.out.print("Precio del producto ofertado 2: ");
                    double precioOf2 = scanner.nextDouble();
                    System.out.print("Días restantes de oferta para el producto ofertado 2: ");
                    int diasOf2 = scanner.nextInt();

                    productoOfertado2 = new ProductoOfertado(nombreOf2, precioOf2, diasOf2);

                    scanner.nextLine();
                    System.out.print("Nombre del producto ofertado 3: ");
                    String nombreOf3 = scanner.nextLine();
                    System.out.print("Precio del producto ofertado 3: ");
                    double precioOf3 = scanner.nextDouble();
                    System.out.print("Días restantes de oferta para el producto ofertado 3: ");
                    int diasOf3 = scanner.nextInt();

                    productoOfertado3 = new ProductoOfertado(nombreOf3, precioOf3, diasOf3);

                    break;
                case 2:
                    if (productoEstandar1 == null || productoEstandar2 == null || productoOfertado1 == null ||
                            productoOfertado2 == null || productoOfertado3 == null) {
                        System.out.println("No se han ingresado todos los productos necesarios.");
                    } else {
                        System.out.println("=== Calcular total del pedido ===");
                        int unidadesPedidas = 5;
                        double totalPedido = productoEstandar1.obtenerPrecioPedido(unidadesPedidas)
                                + productoEstandar2.obtenerPrecioPedido(unidadesPedidas)
                                + productoOfertado1.obtenerPrecioPedido(unidadesPedidas)
                                + productoOfertado2.obtenerPrecioPedido(unidadesPedidas)
                                + productoOfertado3.obtenerPrecioPedido(unidadesPedidas);

                        System.out.println("Total del pedido: " + totalPedido);
                    }

                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }

            System.out.println();
        } while (opcion != 3);

        scanner.close();
    }
}