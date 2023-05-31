package Gestion_p1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu_principal {

	public Menu_principal() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {


	  
	        List<Gestion> pedidos = new ArrayList<>(); // Lista para almacenar los pedidos
	        List<String> productos = new ArrayList<>(); // Lista para almacenar los nombres de los productos
	        List<String> proveedores = new ArrayList<>(); // Lista para almacenar los nombres de los proveedores
	        Scanner scanner = new Scanner(System.in); // Objeto Scanner para leer la entrada del usuario
	        int opcion; // Variable para almacenar la opción seleccionada por el usuario

	        do {  //permite que el programa muestre el menú al usuario
	            System.out.println("MENU:");
	            System.out.println("1. Ingresar  Productos");
	            System.out.println("2. Ingresar Proveedores");
	            System.out.println("3. Ingresar nuevo pedido");
	            System.out.println("4. Pedido mayor");
	            System.out.println("5. Total facturado");
	            System.out.println("6. Salir del programa");
	            System.out.print("Ingrese una opcion: ");
	            opcion = scanner.nextInt(); // Lee la opcion seleccionada por el usuario

	            switch (opcion) {
	                case 1:
	                    for (int i = 0; i < 4; i++) {
	                        System.out.print("Ingrese el nombre del producto " + (i + 1) + ": ");
	                        String producto = scanner.next(); // Lee el nombre del producto ingresado por el usuario
	                        productos.add(producto); // Agrega el nombre del producto a la lista de productos
	                    }
	                    System.out.println("Productos ingresados correctmente.");
	                    break;
	                case 2:
	                    for (int i = 0; i < 2; i++) {
	                        System.out.print("Ingrese el nombre del proveedor " + (i + 1) + ": ");
	                        String proveedor = scanner.next(); // Lee el nombre del proveedor ingresado por el usuario
	                        proveedores.add(proveedor); // Agrega el nombre del proveedor a la lista de proveedores
	                    }
	                    System.out.println("Proveedores ingresados correctamente.");
	                    break;
	                case 3:
	                    System.out.print("Ingrese el nombre del producto: ");
	                    String producto = scanner.next(); // Lee el nombre del producto ingresado por el usuario
	                    System.out.print("Ingrese el nombre del proveedor: ");
	                    String proveedor = scanner.next(); // Lee el nombre del proveedor ingresado por el usuario
	                    System.out.print("Ingrese el precio unitario: ");
	                    double precioUnitario = scanner.nextDouble(); // Lee el precio unitario ingresado por el usuario
	                    System.out.print("Ingrese la cantidad de unidades: ");
	                    int unidades = scanner.nextInt(); // Lee la cantidad de unidades ingresada por el usuario
	                    Gestion nuevoPedido = new Gestion(producto, proveedor, precioUnitario, unidades); // Crea un nuevo objeto Gestion 
	                                                                                                       //con los datos del pedido
	                    pedidos.add(nuevoPedido); // Agrega el pedido a la lista de pedidos                  
	                    System.out.println("Pedido registrado correctamente.");
	                    break;
	                case 4:
	                    Gestion pedidoMayor = null;
	                    int maxUnidades = 0;
	                    for (Gestion gestion : pedidos) {
	                        if (gestion.getUnidades() > maxUnidades) {
	                            maxUnidades = gestion.getUnidades();
	                            pedidoMayor = gestion;
	                        }
	                    }
	                    if (pedidoMayor != null) {
	                        System.out.println("Pedido con mas unidades:");
	                        System.out.println("Producto: " + pedidoMayor.getProducto());
	                        System.out.println("Proveedor: " + pedidoMayor.getProveedor());
	                        System.out.println("Precio unitario: " + pedidoMayor.getPrecioUnitario());
	                        System.out.println("Unidades: " + pedidoMayor.getUnidades());
	                    } else {
	                        System.out.println("No se encontraron pedidos.");
	                    }
	                    break;
	                case 5:
	                    double totalFacturado = 0;
	                    for (Gestion gestion : pedidos) {
	                        totalFacturado += gestion.calcularTotal();
	                    }
	                    System.out.println("Total facturado: $" + totalFacturado);
	                    break;
	                case 6:
	                    System.out.println("Saliendo del programa...");
	                    break;
	                default:
	                    System.out.println("Opcion invalida. Intente nuevamente.");
	                    break;
	            }

	            System.out.println();
	        } while (opcion != 6);

	        scanner.close();
	    }
	}