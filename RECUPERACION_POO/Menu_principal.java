package Matricula_p1;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu_principal {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        SistemaMatriculas sistema = new SistemaMatriculas();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Profesores");
            System.out.println("2. Alumnos");
            System.out.println("3. Materias");
            System.out.println("4. Gestion de Matriculas");
            System.out.println("5. Total Matriculados");
            System.out.println("6. Salir");
            System.out.print("Opcion: ");
            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    sistema.ingresarProfesores();
                    break;
                case 2:
                    sistema.ingresarAlumnos();
                    break;
                case 3:
                    sistema.ingresarMaterias();
                    break;
                case 4:
                    sistema.gestionarMatriculas();
                    break;
                case 5:
                    sistema.mostrarTotalMatriculados();
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    return;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }
}