package jerarquia_empleados;
import java.time.LocalDate;

public class Director extends Empleado {
    private String departamento; // Departamento del director
    private int personal; // Número de personal a cargo del director

    public Director(String nombre, int edad, LocalDate fechaIngreso, double salario, String departamento, int personal) {
        super(nombre, edad, fechaIngreso, salario);
        this.departamento = departamento;
        this.personal = personal;
    }
//Getters y Setters
    public String getDepartamento() {
        return departamento;
    }

    public int getPersonal() {
        return personal;
    }

    @Override
    public void incentivar() {
        LocalDate fechaActual = LocalDate.of(2023, 7, 2); // Fecha actual (2 de julio de 2023)
        // Lógica de incentivar al director
    }

    @Override
    public void actualizarNivel() {
        // No se realiza ninguna actualización de nivel para el director
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Departamento: " + departamento + "\n" +
                "Personal a cargo: " + personal;
    }
}