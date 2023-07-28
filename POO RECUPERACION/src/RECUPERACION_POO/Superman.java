package RECUPERACION_POO;

public class Superman extends Superheroe {
    public Superman(int edad) {
        super("Superman", "Super fuerza y vuelo", edad, "Metropolis");
    }

    // Sobreescribimos el método realizarAccion() para Superman
    @Override
    public void realizarAccion() {
        System.out.println("Superman esta volando por los cielos y usando su super fuerza.");
    }
}