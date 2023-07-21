
package examen_;


public class Docente extends Personal {
    private double sueldoBase;
    private String especialidad;

    public Docente(String nombre, int edad, int cedula, String genero, int año, double sueldoBase, String especialidad) {
        super(nombre, edad, cedula, genero, año);
        this.sueldoBase = sueldoBase;
        this.especialidad = especialidad;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public String getEspecialidad() {
        return especialidad;
    }

   @Override
    public double calcularSueldo() {
        return getSueldoBase() + calcularIncentivo();
    }
}
