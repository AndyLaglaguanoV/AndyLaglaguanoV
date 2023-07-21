
package examen_;

public  abstract class Personal {
private String nombre;
    private int edad;
    private int cedula;
    private String genero;
    private int año;

    public Personal(String nombre, int edad, int cedula, String genero, int año) {
        this.nombre = nombre;
        this.edad = edad;
        this.cedula = cedula;
        this.genero = genero;
        this.año = año;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public int getCedula() {
        return cedula;
    }

    public String getGenero() {
        return genero;
    }

    public int getAño() {
        return año;
    }

    public abstract double calcularSueldo();

    public double calcularIncentivo() {
        // El bono de 300 dólares se otorgará a los empleados con más de 3 años de trabajo
        return getAño() >= 3 ? 300 : 0;
    }
}