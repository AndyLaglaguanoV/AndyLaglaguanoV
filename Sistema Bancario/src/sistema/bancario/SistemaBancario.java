
package sistema.bancario;
import java.util.Scanner;

public class SistemaBancario {


    public static void main(String[] args) {
    
       Scanner sc = new Scanner(System.in);
       double saldoInicial = 0.0;
       String nombreUsuario = "";
       int cedulaUsuario = 0;
       int opcion;
       
       System.out.println("BIENVENIDO AL BANCO =LVA=");
       
       System.out.println("Ingrese el valor inicial de su cuenta");
       saldoInicial = sc.nextDouble();
       
       System.out.println("Ingrese su nombre");
       sc.nextLine(); // Limpiar el buffer del scanner antes de leer el nombre
       nombreUsuario = sc.nextLine();
       
       System.out.println("Ingrese su cedula");
       cedulaUsuario = sc.nextInt();
       
       System.out.println("Desea tener una cuenta ilimitada (SI/NO)");
       String respuesta = sc.next();
       
       Cuenta cuenta;
       if (respuesta.equalsIgnoreCase("S")) {
           cuenta = new CuentaIlimitada(saldoInicial, nombreUsuario, cedulaUsuario);
       } else {
           cuenta = new Cuenta(saldoInicial, nombreUsuario, cedulaUsuario);
       }
       
       do {
           System.out.println("\nMENU PRINCIPAL");
           System.out.println("1. Consultar saldo");
           System.out.println("2. Realizar depOsito");
           System.out.println("3. Realizar retiro");
           System.out.println("4. Salir");
           System.out.print("Ingrese su opcion: ");
           opcion = sc.nextInt();
           
           switch (opcion) {
               case 1:
                   System.out.println("Su saldo actual es: $" + cuenta.consultarSaldo());
                   break;
               case 2:
                   System.out.print("Ingrese la cantidad a depositar: $");
                   double cantidadDeposito = sc.nextDouble();
                   cuenta.realizarDeposito(cantidadDeposito);
                   break;
               case 3:
                   System.out.print("Ingrese la cantidad a retirar: $");
                   double cantidadRetiro = sc.nextDouble();
                   cuenta.realizarRetiro(cantidadRetiro);
                   break;
               case 4:
                   System.out.println("Gracias por utilizar nuestros servicios.");
                   break;
               default:
                   System.out.println("Opción invalida. Por favor, ingrese una opción valida.");
                   break;
           }
       } while (opcion != 4);
    }
}