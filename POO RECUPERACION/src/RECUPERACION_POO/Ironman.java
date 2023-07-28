package RECUPERACION_POO;

public class Ironman extends Superheroe {
    public Ironman(int edad) {
        super("Iron Man", "Tecnologia avanzada y armadura potenciada", edad, "Nueva York");
    }

    // Sobreescribimos el método realizarAccion() para Iron Man
    @Override
    public void realizarAccion() {
        System.out.println("Iron Man esta combatiendo la ciudaad con su tegnologia.");
    }
}



