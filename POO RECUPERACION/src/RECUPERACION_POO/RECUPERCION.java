package RECUPERACION_POO;
import java.util.Scanner;
public class RECUPERCION {

	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);

        // Crear superhéroes
        Superheroe flash = new Flash(30);
        Superheroe superman = new Superman(35);
        Superheroe ironman = new Ironman(40);

        // Menú de selección de superhéroes
        System.out.println("Bienvenido a la sala de heroes");
        System.out.println("Heroes disponibles.");
        System.out.println("1. Flash");
        System.out.println("2. Superman");
        System.out.println("3. Iron Man");
        System.out.println("Elige a tu superheroe:");

        int opcion = scanner.nextInt();

        // Realizar acciones de los superhéroes usando polimorfismo según la elección del usuario
        switch (opcion) {
            case 1:
                realizarAccionSuperheroe(flash);
                break;
            case 2:
                realizarAccionSuperheroe(superman);
                break;
            case 3:
                realizarAccionSuperheroe(ironman);
                break;
            default:
                System.out.println("Opcion invalida. Selecciona una del 1 al 3.");
                break;
        }

        scanner.close();
    }

    // Método que utiliza polimorfismo para realizar una acción de cualquier superhéroe
    public static void realizarAccionSuperheroe(Superheroe heroe) {
        System.out.println("Nombre: " + heroe.getNombre());
        System.out.println("Poder: " + heroe.getPoder());
        System.out.println("Edad: " + heroe.getEdad() + " años");
        System.out.println("Ciudad de origen: " + heroe.getCiudadOrigen());
        heroe.realizarAccion();
    }
}