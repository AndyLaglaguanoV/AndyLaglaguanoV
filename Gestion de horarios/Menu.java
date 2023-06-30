/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package menu;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.*;
/**
 *
 * @author PC-MASTER
 */
public class Menu {
    
  public static int leerEntero(Scanner scanner) {
    while (true) {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Opcion no valida. Intente de nuevo.");
            scanner.nextLine(); // Descarta la entrada no válida
        }
    }
}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("======= Bienvenido =======");
        System.out.print("Ingrese la cantidad de laboratorios: ");
        int cantidadLaboratorios = leerEntero(scanner);
        scanner.nextLine();

        List<Laboratorio> laboratorios = new ArrayList<>(); // Lista de laboratorios

        for (int i = 0; i < cantidadLaboratorios; i++) {
            System.out.println("\nIngrese los detalles del Laboratorio " + (i + 1) + ":");

            System.out.println("1. Laboratorio de Informatica");
            System.out.println("2. Laboratorio de Quimica");
            System.out.println("3. Laboratorio de Biologia");

            int tipoLab = 0;
            boolean tipoValido = false;
            while (!tipoValido) {
                System.out.print("Seleccione el tipo de laboratorio: ");
                tipoLab = leerEntero(scanner);
                scanner.nextLine();

                if (tipoLab >= 1 && tipoLab <= 3) {
                    tipoValido = true;
                } else {
                    System.out.println("Opcion no valida. Intente de nuevo.");
                }
            }

            System.out.print("Nombre: ");
            String nombreLab = scanner.nextLine();

            System.out.print("Capacidad: ");
            int capacidadLab = leerEntero(scanner);
            scanner.nextLine();

            System.out.print("Cantidad de equipos: ");
            int cantidadEquipos = leerEntero(scanner);
            scanner.nextLine();

            List<String> equiposLab = new ArrayList<>(); // Lista de equipos del laboratorio

            for (int j = 0; j < cantidadEquipos; j++) {
                System.out.print("Equipo " + (j + 1) + ": ");
                String equipo = scanner.nextLine();
                equiposLab.add(equipo);
            }

            switch (tipoLab) {
                case 1:
                    System.out.print("Ubicacion: ");
                    String ubicacionLab = scanner.nextLine();

                    boolean tieneProyectorLab = false;
                    boolean seleccionValida = false;
                    while (!seleccionValida) {
                        System.out.print("Tiene proyector (si/no): ");
                        String seleccion = scanner.nextLine();
                        if (seleccion.equalsIgnoreCase("si")) {
                            tieneProyectorLab = true;
                            seleccionValida = true;
                        } else if (seleccion.equalsIgnoreCase("no")) {
                            seleccionValida = true;
                        } else {
                            System.out.println("Opcion no valida. Intente de nuevo.");
                        }
                    }

                    LaboratorioInformatica labInformatica = new LaboratorioInformatica(nombreLab, capacidadLab, equiposLab, ubicacionLab, tieneProyectorLab);
                    laboratorios.add(labInformatica); // Agrega el laboratorio a la lista de laboratorios
                    break;
                case 2:
                    System.out.print("Cantidad de sustancias: ");
                    int cantidadSustancias = leerEntero(scanner);
                    scanner.nextLine();

                    boolean requiereVentilacionEspecial = false;
                    seleccionValida = false;
                    while (!seleccionValida) {
                        System.out.print("Requiere ventilacion especial (si/no): ");
                        String seleccion = scanner.nextLine();
                        if (seleccion.equalsIgnoreCase("si")) {
                            requiereVentilacionEspecial = true;
                            seleccionValida = true;
                        } else if (seleccion.equalsIgnoreCase("no")) {
                            seleccionValida = true;
                        } else {
                            System.out.println("Opcion no valida. Intente de nuevo.");
                        }
                    }

                    LaboratorioQuimica labQuimica = new LaboratorioQuimica(nombreLab, capacidadLab, equiposLab, cantidadSustancias, requiereVentilacionEspecial);
                    laboratorios.add(labQuimica); // Agrega el laboratorio a la lista de laboratorios
                    break;
                case 3:
                    System.out.print("Area de estudio: ");
                    String areaEstudio = scanner.nextLine();

                    LaboratorioBiologia labBiologia = new LaboratorioBiologia(nombreLab, capacidadLab, equiposLab, areaEstudio);
                    laboratorios.add(labBiologia); // Agrega el laboratorio a la lista de laboratorios
                    break;
                default:
                    System.out.println("Tipo de laboratorio invalido. No se ha agregado ningun laboratorio.\n");
                    break;
            }

            System.out.println("Laboratorio " + (i + 1) + " ingresado correctamente.\n");
        }

        System.out.print("Ingrese la cantidad de asignaturas: ");
        int cantidadAsignaturas = leerEntero(scanner);
        scanner.nextLine();

        List<Asignatura> asignaturas = new ArrayList<>(); // Lista de asignaturas

        for (int i = 0; i < cantidadAsignaturas; i++) {
            System.out.println("\nIngrese los detalles de la Asignatura " + (i + 1) + ":");

            System.out.print("Nombre: ");
            String nombreAsignatura = scanner.nextLine();

            System.out.print("Horario: ");
            String horarioAsignatura = scanner.nextLine();

            System.out.print("Laboratorio asignado: ");
            String laboratorioAsignado = scanner.nextLine();

            Asignatura asignatura = new Asignatura(nombreAsignatura, horarioAsignatura);
            asignatura.setLaboratorioAsignado(laboratorioAsignado);

            asignaturas.add(asignatura); // Agrega la asignatura a la lista de asignaturas

            System.out.println("Asignatura " + (i + 1) + " ingresada correctamente.\n");
        }

        boolean salir = false;
        while (!salir) {
            System.out.println("=== Menu ===");
            System.out.println("1. Ver informacion de los laboratorios");
            System.out.println("2. Ver informacion de las asignaturas");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opcion: ");

            int opcion = leerEntero(scanner);
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("\nInformacion de los Laboratorios seleccionados:");
                    for (Laboratorio laboratorio : laboratorios) {
                        laboratorio.mostrarInformacion();
                        System.out.println();
                    }
                    break;
                case 2:
                    System.out.println("\nInformacion de las Asignaturas:");
                    for (Asignatura asignatura : asignaturas) {
                        asignatura.mostrarInformacion();
                        System.out.println();
                    }
                    break;
                case 3:
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion no valida. Intente de nuevo.\n");
                    break;
            }
        }

        System.out.println("\nGracias por utilizar nuestro programa.");
    }
}