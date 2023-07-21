
package examen_;

public class Limpieza extends Personal {
    private double horasTrabajadas;
    private String area;

    public Limpieza(String nombre, int edad, int cedula, String genero, int año, double horasTrabajadas, String area) {
        super(nombre, edad, cedula, genero, año);
        this.horasTrabajadas = horasTrabajadas;
        this.area = area;
    }

    public double getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public String getArea() {
        return area;
    }

   @Override
    public double calcularSueldo() {
        int salarioPorHora = 8; // Sueldo por hora fijo de 8 unidades
        return getHorasTrabajadas() * salarioPorHora + calcularIncentivo();
    }
}
