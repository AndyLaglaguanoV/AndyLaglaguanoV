package jerarquia_empleados;

import java.time.LocalDate;

public class Operario extends Empleado {
    private int nivel; // Nivel de seguridad del operario

    public Operario(String nombre, int edad, LocalDate fechaIngreso, double salario, int nivel) {
        super(nombre, edad, fechaIngreso, salario);
        this.nivel = nivel;
    }

    public int getNivel() {
        return nivel;
    }

    @Override
    public void incentivar() {
        LocalDate fechaActual = LocalDate.of(2023, 7, 2); // Fecha actual (2 de julio de 2023)
        // Lógica de incentivar al operario
    }

    @Override
    public void actualizarNivel() {
        LocalDate fechaActual = LocalDate.of(2023, 7, 2); // Fecha actual (2 de julio de 2023)
        // Lógica de actualizar el nivel del operario
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Nivel: " + nivel;
    }
}