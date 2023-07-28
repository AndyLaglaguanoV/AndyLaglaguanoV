package RECUPERACION_POO;

public class Flash extends Superheroe {
    public Flash(int edad) {
        super("Flash", "Super velocidad", edad, "Central City");
    }

    // Sobreescribimos el método realizarAccion() para Flash
    @Override
    public void realizarAccion() {
        System.out.println("Flash esta corriendo a una velocidad increible.");
    }
}
