package jerarquia_empleados;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jerarquia_Empleados {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Empleado> empleados = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            mostrarMenu(); // Mostrar el menú de opciones
            int opcion = leerEntero();
            scanner.nextLine(); // Limpiar el buffer de entrada

            switch (opcion) {
                case 1:
                    empleados.add(crearEmpleado("Director")); // Crear un Director
                    break;

                case 2:
                    empleados.add(crearEmpleado("Operario")); // Crear un Operario
                    break;

                case 3:
                    incentivarEmpleado(); // Incentivar a un empleado
                    break;

                case 4:
                    actualizarNivelOperario(); // Actualizar el nivel de un operario
                    break;

                case 5:
                    verDatosEmpleados(); // Ver los datos de los empleados
                    break;

                case 6:
                    scanner.close(); // Salir del programa
                    return;

                default:
                    System.out.println("\nOpcion incorrecta. Ingrese una opcion valida.");
            }

            System.out.println();
        }
    }

    private static void mostrarMenu() {
        System.out.println("=== Menu ===");
        System.out.println("1. Crear Director"); // Opción para crear un Director
        System.out.println("2. Crear Operario"); // Opción para crear un Operario
        System.out.println("3. Incentivar empleado"); // Opción para incentivar a un empleado
        System.out.println("4. Actualizar nivel de operario"); // Opción para actualizar el nivel de un operario
        System.out.println("5. Ver datos de empleados"); // Opción para ver los datos de los empleados
        System.out.println("6. Salir"); // Opción para salir del programa
        System.out.print("\nIngrese una opcion: ");
    }

    private static int leerEntero() {
        return scanner.nextInt();
    }

    private static Empleado crearEmpleado(String tipo) {
        System.out.print("\nIngrese el nombre del " + tipo.toLowerCase() + ": ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la edad del " + tipo.toLowerCase() + ": ");
        int edad = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese el año de ingreso del " + tipo.toLowerCase() + ": ");
        int anio = scanner.nextInt();
        System.out.print("Ingrese el mes de ingreso del " + tipo.toLowerCase() + ": ");
        int mes = scanner.nextInt();
        System.out.print("Ingrese el dia de ingreso del " + tipo.toLowerCase() + ": ");
        int dia = scanner.nextInt();
        scanner.nextLine();
        LocalDate fechaIngreso = LocalDate.of(anio, mes, dia);
        System.out.print("Ingrese el salario del " + tipo.toLowerCase() + ": ");
        double salario = scanner.nextDouble();
        scanner.nextLine();

        if (tipo.equals("Director")) {
            System.out.print("Ingrese el departamento del director: ");
            String departamento = scanner.nextLine();
            System.out.print("Ingrese el número de personal a cargo del director: ");
            int personal = scanner.nextInt();
            scanner.nextLine();
            return new Director(nombre, edad, fechaIngreso, salario, departamento, personal);
        } else if (tipo.equals("Operario")) {
            System.out.print("Ingrese el nivel de seguridad del operario (1-5): ");
            int nivel = scanner.nextInt();
            scanner.nextLine();
            return new Operario(nombre, edad, fechaIngreso, salario, nivel);
        }

        return null;
    }

    private static void incentivarEmpleado() {
        if (!empleados.isEmpty()) {
            System.out.println("\nSeleccione el tipo de empleado:");
            System.out.println("1. Director"); // Opción para seleccionar un Director
            System.out.println("2. Operario"); // Opción para seleccionar un Operario
            System.out.print("Ingrese una opcion: ");
            int tipoEmpleado = leerEntero();
            scanner.nextLine();

            if (tipoEmpleado == 1) {
                incentivarDirector(); // Incentivar a un Director
            } else if (tipoEmpleado == 2) {
                incentivarOperario(); // Incentivar a un Operario
            } else {
                System.out.println("\nOpcion incorrecta. Seleccione una opcion valida.");
            }
        } else {
            System.out.println("\nNo se ha creado ningun empleado.");
        }
    }

    private static void incentivarDirector() {
        System.out.println("\nEmpleados Directores:");
        listarEmpleados(Director.class); // Listar los Directores existentes

        System.out.print("Seleccione un director: ");
        int directorIndex = leerEntero();
        scanner.nextLine();

        if (directorIndex >= 1 && directorIndex <= empleados.size()) {
            Director directorSeleccionado = (Director) empleados.get(directorIndex - 1);
            directorSeleccionado.incentivar();
            System.out.println("\nEmpleado incentivado correctamente.");
        } else {
            System.out.println("\nOpcion incorrecta. Seleccione un director valido.");
        }
    }

    private static void incentivarOperario() {
        System.out.println("\nEmpleados Operarios:");
        listarEmpleados(Operario.class); // Listar los Operarios existentes

        System.out.print("Seleccione un operario: ");
        int operarioIndex = leerEntero();
        scanner.nextLine();

        if (operarioIndex >= 1 && operarioIndex <= empleados.size()) {
            Operario operarioSeleccionado = (Operario) empleados.get(operarioIndex - 1);
            operarioSeleccionado.incentivar();
            System.out.println("\nEmpleado incentivado correctamente.");
        } else {
            System.out.println("\nOpcion incorrecta. Seleccione un operario valido.");
        }
    }

    private static void actualizarNivelOperario() {
        System.out.println("\nOperarios con nivel superior a 2:");
        listarEmpleados(Operario.class); // Listar los Operarios con nivel superior a 2

        System.out.print("Seleccione un operario: ");
        int operarioIndex = leerEntero();
        scanner.nextLine();

        if (operarioIndex >= 1 && operarioIndex <= empleados.size()) {
            Operario operarioSeleccionado = (Operario) empleados.get(operarioIndex - 1);
            operarioSeleccionado.actualizarNivel();
            System.out.println("\nNivel actualizado del operario: " + operarioSeleccionado.getNivel());
        } else {
            System.out.println("\nOpcion incorrecta. Seleccione un operario valido.");
        }
    }

    private static void verDatosEmpleados() {
        System.out.println("\n=== Datos de empleados ===");
        if (!empleados.isEmpty()) {
            System.out.println("Seleccione el tipo de empleado:");
            System.out.println("1. Directores"); // Opción para ver los datos de los Directores
            System.out.println("2. Operarios"); // Opción para ver los datos de los Operarios
            System.out.print("Ingrese una opcion: ");
            int tipo = leerEntero();
            scanner.nextLine();

            switch (tipo) {
                case 1:
                    System.out.println("\n=== Directores ===");
                    listarEmpleados(Director.class); // Listar los Directores existentes
                    break;

                case 2:
                    System.out.println("\n=== Operarios ===");
                    listarEmpleados(Operario.class); // Listar los Operarios existentes
                    break;

                default:
                    System.out.println("\nOpcion incorrecta. Seleccione una opcion valida.");
            }
        } else {
            System.out.println("No se ha creado ningun empleado.");
        }
    }

    private static void listarEmpleados(Class<? extends Empleado> tipoEmpleado) {
        int contador = 1;
        for (Empleado empleado : empleados) {
            if (tipoEmpleado.isInstance(empleado)) {
                System.out.println(contador + ". " + empleado.toString());
                if (empleado.isBeneficiarioBono(LocalDate.of(2023, 7, 2))) {
                    System.out.println("¡Es beneficiario del bono!");
                } else {
                    System.out.println("No es beneficiario del bono.");
                }
                System.out.println();
                contador++;
            }
        }

        if (contador == 1) {
            System.out.println("No se ha creado ningun empleado " + tipoEmpleado.getSimpleName().toLowerCase() + ".");
        }
    }
}
