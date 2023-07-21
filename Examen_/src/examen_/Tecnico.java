
package examen_;

public class Tecnico extends Personal {
    private int horasTrabajadas;
    private String nivel;

    public Tecnico(String nombre, int edad, int cedula, String genero, int año, int horasTrabajadas, String nivel) {
        super(nombre, edad, cedula, genero, año);
        this.horasTrabajadas = horasTrabajadas;
        this.nivel = nivel;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public String getNivel() {
        return nivel;
    }

   @Override
    public double calcularSueldo() {
        int salarioPorHora = 10; // Sueldo por hora fijo de 10 unidades
        return getHorasTrabajadas() * salarioPorHora + calcularIncentivo();
    }
}