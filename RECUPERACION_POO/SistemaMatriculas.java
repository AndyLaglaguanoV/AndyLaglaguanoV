package Matricula_p1;
import java.util.ArrayList;
import java.util.Scanner;

public class SistemaMatriculas {
    private ArrayList<Profesor> profesores;
    private ArrayList<Alumno> alumnos;
    private ArrayList<Materia> materias;
    private ArrayList<Matricula> matriculas;

    public SistemaMatriculas() {
        profesores = new ArrayList<>();
        alumnos = new ArrayList<>();
        materias = new ArrayList<>();
        matriculas = new ArrayList<>();
    }

    public void ingresarProfesores() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 2; i++) {
            System.out.println("Ingrese los datos del profesor " + (i + 1) + ":");
            System.out.print("Cédula: ");
            String cedula = scanner.nextLine();
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Dirección: ");
            String direccion = scanner.nextLine();
            System.out.print("Teléfono: ");
            String telefono = scanner.nextLine();
            System.out.print("Celular: ");
            String celular = scanner.nextLine();

            Profesor profesor = new Profesor(cedula, nombre, direccion, telefono, celular);
            profesores.add(profesor);
        }
    }

    public void ingresarAlumnos() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 6; i++) {
            System.out.println("Ingrese los datos del alumno " + (i + 1) + ":");
            System.out.print("Cédula: ");
            String cedula = scanner.nextLine();
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Dirección: ");
            String direccion = scanner.nextLine();
            System.out.print("Teléfono: ");
            String telefono = scanner.nextLine();
            System.out.print("Celular: ");
            String celular = scanner.nextLine();
            System.out.print("Género: ");
            String genero = scanner.nextLine();

            Alumno alumno = new Alumno(cedula, nombre, direccion, telefono, celular, genero);
            alumnos.add(alumno);
        }
    }

    public void ingresarMaterias() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 4; i++) {
            System.out.println("Ingrese los datos de la materia " + (i + 1) + ":");
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Profesor que imparte la materia: ");
            String nombreProfesor = scanner.nextLine();
            Profesor profesor = buscarProfesor(nombreProfesor);

            Materia materia = new Materia(nombre, profesor);
            materias.add(materia);
        }
    }

    public Profesor buscarProfesor(String nombreProfesor) {
        for (Profesor profesor : profesores) {
            if (profesor.getNombre().equalsIgnoreCase(nombreProfesor)) {
                return profesor;
            }
        }
        return null;
    }

    public void gestionarMatriculas() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese los datos de la matrícula:");
        System.out.print("Profesor: ");
        String nombreProfesor = scanner.nextLine();
        Profesor profesor = buscarProfesor(nombreProfesor);

        System.out.print("Alumno: ");
        String nombreAlumno = scanner.nextLine();
        Alumno alumno = buscarAlumno(nombreAlumno);

        System.out.print("Materia: ");
        String nombreMateria = scanner.nextLine();
        Materia materia = buscarMateria(nombreMateria);

        if (profesor != null && alumno != null && materia != null) {
            Matricula matricula = new Matricula(profesor, alumno, materia);
            matriculas.add(matricula);
            System.out.println("Matrícula registrada exitosamente.");
        } else {
            System.out.println("Error: Datos inválidos.");
        }
    }

    public Alumno buscarAlumno(String nombreAlumno) {
        for (Alumno alumno : alumnos) {
            if (alumno.getNombre().equalsIgnoreCase(nombreAlumno)) {
                return alumno;
            }
        }
        return null;
    }

    public Materia buscarMateria(String nombreMateria) {
        for (Materia materia : materias) {
            if (materia.getNombre().equalsIgnoreCase(nombreMateria)) {
                return materia;
            }
        }
        return null;
    }

    public void mostrarTotalMatriculados() {
        int totalMatriculados = matriculas.size();
        int totalHombres = 0;
        int totalMujeres = 0;

        for (Matricula matricula : matriculas) {
            Alumno alumno = matricula.getAlumno();
            if (alumno.getGenero().equalsIgnoreCase("hombre")) {
                totalHombres++;
            } else if (alumno.getGenero().equalsIgnoreCase("mujer")) {
                totalMujeres++;
            }
        }

        System.out.println("Total matriculados: " + totalMatriculados);
        System.out.println("Total hombres: " + totalHombres);
        System.out.println("Total mujeres: " + totalMujeres);
    }
}