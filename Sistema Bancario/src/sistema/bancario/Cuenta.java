
package sistema.bancario;



  public class Cuenta {
         double dinero;
    double total;
    String nombre;
    int cedula;
    
    public Cuenta(double dinero, String nombre, int cedula) {
        this.dinero = dinero;
        this.total = dinero;
        this.nombre = nombre;
        this.cedula = cedula;
    }
    
    public Cuenta(String nombre, int cedula) {
        this.dinero = 0.0;
        this.total = 0.0;
        this.nombre = nombre;
        this.cedula = cedula;
    }
    
    public double consultarSaldo() {
        return total;
    }
    
    public void realizarDeposito(double cantidad) {
        dinero += cantidad;
        total += cantidad;
        System.out.println("Depósito realizado correctamente.");
    }
    
    public boolean realizarRetiro(double cantidad) {
        if (cantidad <= total) {
            dinero -= cantidad;
            total -= cantidad;
            System.out.println("Retiro realizado correctamente.");
            return true;
        } else {
            System.out.println("Saldo insuficiente para realizar el retiro.");
            return false;
        }
    }
    
    // Otros métodos y funcionalidades de la cuenta
    
}