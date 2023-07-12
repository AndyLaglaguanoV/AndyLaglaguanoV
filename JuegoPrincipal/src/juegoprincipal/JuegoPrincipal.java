
package juegoprincipal;
import java.util.Scanner;

public class JuegoPrincipal {


    public static void main(String[] args) {
     
          Scanner scanner = new Scanner(System.in);
       //Creamos  el menú y solicitar la selección del juego
        System.out.println("Bienvenido al programa de juegos deportivos");
        System.out.println("Por favor, selecciona el tipo de juego que deseas jugar:");
        System.out.println("1. Futbol");
        System.out.println("2. Basquet");
        System.out.println("3. Ajedrez");

        int opcion = scanner.nextInt();
 //Creamos la instancia del juego seleccionado y llamar al método iniciarJuego()
        Juego juego;

        switch (opcion) {
            case 1:
                juego = new JuegoFutbol("Futbol", 22);
                break;
            case 2:
                juego = new JuegoBasquet("Basquet", 10);
                break;
            case 3:
                juego = new JuegoAjedrez("Ajedrez", 2);
                break;
            default:
                System.out.println("Opcion invlida. Saliendo del programa.");
                return;
        }

        juego.iniciarJuego();
    }
}
