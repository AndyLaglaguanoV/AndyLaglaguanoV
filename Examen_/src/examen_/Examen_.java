
package examen_;
import java.util.Scanner;
import java.util.ArrayList;
public class Examen_ {

    public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
        ArrayList<Personal> personalList = new ArrayList<>();

        int option;
        do {
            System.out.println("\n*** Menú ***");
            System.out.println("1. Agregar Docente");
            System.out.println("2. Agregar Técnico");
            System.out.println("3. Agregar Administrativo");
            System.out.println("4. Agregar Limpieza");
            System.out.println("5. Mostrar información de empleados");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Ingrese el nombre del Docente:");
                    String nombreDocente = scanner.next();
                    System.out.println("Ingrese la edad del Docente:");
                    int edadDocente = scanner.nextInt();
                    System.out.println("Ingrese la cédula del Docente:");
                    int cedulaDocente = scanner.nextInt();
                    System.out.println("Ingrese el género del Docente:");
                    String generoDocente = scanner.next();
                    System.out.println("Ingrese el año de ingreso del Docente:");
                    int añoDocente = scanner.nextInt();
                    System.out.println("Ingrese el sueldo base del Docente:");
                    double sueldoBaseDocente = scanner.nextDouble();
                    System.out.println("Ingrese la especialidad del Docente:");
                    String especialidadDocente = scanner.next();
                    Docente docente = new Docente(nombreDocente, edadDocente, cedulaDocente, generoDocente, añoDocente, sueldoBaseDocente, especialidadDocente);
                    personalList.add(docente);
                    break;
                case 2:
                    System.out.println("Ingrese el nombre del Técnico:");
                    String nombreTecnico = scanner.next();
                    System.out.println("Ingrese la edad del Técnico:");
                    int edadTecnico = scanner.nextInt();
                    System.out.println("Ingrese la cédula del Técnico:");
                    int cedulaTecnico = scanner.nextInt();
                    System.out.println("Ingrese el género del Técnico:");
                    String generoTecnico = scanner.next();
                    System.out.println("Ingrese el año de ingreso del Técnico:");
                    int añoTecnico = scanner.nextInt();
                    System.out.println("Ingrese el nivel del Técnico:");
                    String nivelTecnico = scanner.next();
                    System.out.println("Ingrese las horas trabajadas del Técnico:");
                    int horasTrabajadasTecnico = scanner.nextInt();
                    Tecnico tecnico = new Tecnico(nombreTecnico, edadTecnico, cedulaTecnico, generoTecnico, añoTecnico, horasTrabajadasTecnico, nivelTecnico);
                    personalList.add(tecnico);
                    break;
                case 3:
                    System.out.println("Ingrese el nombre del Administrativo:");
                    String nombreAdmin = scanner.next();
                    System.out.println("Ingrese la edad del Administrativo:");
                    int edadAdmin = scanner.nextInt();
                    System.out.println("Ingrese la cédula del Administrativo:");
                    int cedulaAdmin = scanner.nextInt();
                    System.out.println("Ingrese el género del Administrativo:");
                    String generoAdmin = scanner.next();
                    System.out.println("Ingrese el año de ingreso del Administrativo:");
                    int añoAdmin = scanner.nextInt();
                    System.out.println("Ingrese el salario mensual del Administrativo:");
                    double salarioMensualAdmin = scanner.nextDouble();
                    // Aquí podrías agregar la lógica para asignar personal a cargo, si lo deseas
                    Administrativo administrativo = new Administrativo(nombreAdmin, edadAdmin, cedulaAdmin, generoAdmin, añoAdmin, salarioMensualAdmin, null);
                    personalList.add(administrativo);
                    break;
                case 4:
                    System.out.println("Ingrese el nombre del Personal de Limpieza:");
                    String nombreLimpieza = scanner.next();
                    System.out.println("Ingrese la edad del Personal de Limpieza:");
                    int edadLimpieza = scanner.nextInt();
                    System.out.println("Ingrese la cédula del Personal de Limpieza:");
                    int cedulaLimpieza = scanner.nextInt();
                    System.out.println("Ingrese el género del Personal de Limpieza:");
                    String generoLimpieza = scanner.next();
                    System.out.println("Ingrese el año de ingreso del Personal de Limpieza:");
                    int añoLimpieza = scanner.nextInt();
                    System.out.println("Ingrese las horas trabajadas del Personal de Limpieza:");
                    double horasTrabajadasLimpieza = scanner.nextDouble();
                    System.out.println("Ingrese el área del Personal de Limpieza:");
                    String areaLimpieza = scanner.next();
                    Limpieza limpieza = new Limpieza(nombreLimpieza, edadLimpieza, cedulaLimpieza, generoLimpieza, añoLimpieza, horasTrabajadasLimpieza, areaLimpieza);
                    personalList.add(limpieza);
                    break;
                   case 5:
            System.out.println("\n*** Información de empleados ***");
            for (Personal personal : personalList) {
                if (personal instanceof Docente) {
                    Docente doc = (Docente) personal;
                    double sueldo = doc.calcularSueldo();
                    String mensajeIncentivo = doc.getAño() >= 3 ? "Es beneficiario del incentivo." : "No es beneficiario del incentivo.";
                    System.out.println("Docente - Nombre: " + doc.getNombre() + ", Especialidad: " + doc.getEspecialidad() + ", Sueldo: " + sueldo + ", " + mensajeIncentivo);
                } else if (personal instanceof Tecnico) {
                    Tecnico tec = (Tecnico) personal;
                    double sueldo = tec.calcularSueldo();
                    String mensajeIncentivo = tec.getAño() >= 3 ? "Es beneficiario del incentivo." : "No es beneficiario del incentivo.";
                    System.out.println("Técnico - Nombre: " + tec.getNombre() + ", Nivel: " + tec.getNivel() + ", Sueldo: " + sueldo + ", " + mensajeIncentivo);
                } else if (personal instanceof Administrativo) {
                    Administrativo admin = (Administrativo) personal;
                    double sueldo = admin.calcularSueldo();
                    String mensajeIncentivo = admin.getAño() >= 3 ? "Es beneficiario del incentivo." : "No es beneficiario del incentivo.";
                    System.out.println("Administrativo - Nombre: " + admin.getNombre() + ", Personal a cargo: "
                            + (admin.getPersonal() != null ? admin.getPersonal().getNombre() : "Ninguno") + ", Sueldo: " + sueldo + ", " + mensajeIncentivo);
                } else if (personal instanceof Limpieza) {
                    Limpieza limpieza = (Limpieza) personal;
                    double sueldo = limpieza.calcularSueldo();
                    String mensajeIncentivo = limpieza.getAño() >= 3 ? "Es beneficiario del incentivo." : "No es beneficiario del incentivo.";
                    System.out.println("Limpieza - Nombre: " + limpieza.getNombre() + ", Área: " + limpieza.getArea() + ", Sueldo: " + sueldo + ", " + mensajeIncentivo);
                }
            }
            break;
                case 6:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida, por favor intente nuevamente.");
            }
        } while (option != 6);

        scanner.close();
    }
}           