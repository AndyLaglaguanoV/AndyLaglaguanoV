
package juegoprincipal;

public class Juego {
    
 private String nombre;
    private int jugadores;

    public Juego(String nombre, int jugadores) {
        this.nombre = nombre;
        this.jugadores = jugadores;
    }

    public void iniciarJuego() {
        System.out.println("Bienvenido al juego de " + nombre + ":");
        System.out.println("Numero de jugadores: " + jugadores);

        // Código para iniciar el juego...
    }
}