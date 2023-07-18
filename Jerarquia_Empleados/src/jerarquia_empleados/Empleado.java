package jerarquia_empleados;

import java.time.LocalDate;
//Clase Padre
public abstract class Empleado {
    //Atributos
    private String nombre;
    private int edad;
    private LocalDate fechaIngreso;
    protected double salario;
    public static final double BONO = 500.0;
//Metodo constructor
    public Empleado(String nombre, int edad, LocalDate fechaIngreso, double salario) {
        this.nombre = nombre;
        this.edad = edad;
        this.fechaIngreso = fechaIngreso;
        this.salario = salario;
    }
//Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public double getSalario() {
        return salario;
    }

    public abstract void incentivar();// Método abstracto para incentivar al empleado


    public abstract void actualizarNivel();// Método abstracto para actualizar el nivel del empleado

    public boolean isBeneficiarioBono(LocalDate fechaActual) {
        int mesesEnEmpresa = (int) fechaIngreso.until(fechaActual).toTotalMonths();
        return mesesEnEmpresa > 30;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\n" +
                "Edad: " + edad + "\n" +
                "Fecha de ingreso: " + fechaIngreso + "\n" +
                "Salario: " + salario;
    }
}
