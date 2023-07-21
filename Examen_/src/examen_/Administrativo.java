
package examen_;

public class Administrativo extends Personal {
    private double salarioMensual;
    private Personal personal;

    public Administrativo(String nombre, int edad, int cedula, String genero, int año, double salarioMensual, Personal personal) {
        super(nombre, edad, cedula, genero, año);
        this.salarioMensual = salarioMensual;
        this.personal = personal;
    }

    public double getSalarioMensual() {
        return salarioMensual;
    }

    public Personal getPersonal() {
        return personal;
    }

 
    @Override
    public double calcularSueldo() {
        // Ejemplo de fórmula de sueldo para Administrativo
        // Puedes ajustar los valores según lo consideres conveniente
        double sueldo = getSalarioMensual();
        double incentivo = calcularIncentivo();

        return sueldo + incentivo;
    }
}
