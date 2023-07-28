package RECUPERACION_POO;

public abstract class Superheroe {
    protected String nombre;
    protected String poder;
    protected int edad;
    protected String ciudadOrigen;

    public Superheroe(String nombre, String poder, int edad, String ciudadOrigen) {
        this.nombre = nombre;
        this.poder = poder;
        this.edad = edad;
        this.ciudadOrigen = ciudadOrigen;
    }

    public abstract void realizarAccion();

    // Métodos getter para acceder a los atributos
    public String getNombre() {
        return nombre;
    }

    public String getPoder() {
        return poder;
    }

    public int getEdad() {
        return edad;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }
}