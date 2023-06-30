
package sistema.bancario;


public class CuentaIlimitada  extends Cuenta {
    double maxEntrada;
    double maxSalida;
    
    public CuentaIlimitada(double dinero, String nombre, int cedula) {
        super(dinero, nombre, cedula);
        this.maxEntrada = Double.MAX_VALUE;
        this.maxSalida = Double.MAX_VALUE;
    }
    
    public CuentaIlimitada(double dinero, String nombre, int cedula, double maxEntrada, double maxSalida) {
        super(dinero, nombre, cedula);
        this.maxEntrada = maxEntrada;
        this.maxSalida = maxSalida;
    }
    
    @Override
    public void realizarDeposito(double cantidad) {
        if (cantidad <= maxEntrada) {
            dinero += cantidad;
            total += cantidad;
            System.out.println("Depósito realizado correctamente.");
        } else {
            System.out.println("La cantidad supera el límite de entrada.");
        }
    }
    
    @Override
    public boolean realizarRetiro(double cantidad) {
        if (cantidad <= maxSalida) {
            return super.realizarRetiro(cantidad);
        } else {
            System.out.println("La cantidad supera el límite de salida.");
            return false;
        }
    }
    
    // Otros métodos y funcionalidades específicas de la cuenta ilimitada
    
}