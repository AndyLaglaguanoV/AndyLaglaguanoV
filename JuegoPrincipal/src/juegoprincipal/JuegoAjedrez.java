
package juegoprincipal;

public class JuegoAjedrez extends Juego {
    private String jugador1;
    private String jugador2;

    public JuegoAjedrez(String nombre, int jugadores) {
        super(nombre, jugadores);
        this.jugador1 = "";
        this.jugador2 = "";
    }

    public void establecerJugadores(String jugador1, String jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }

    public void obtenerJugadores() {
        System.out.println("Jugador 1: " + jugador1);
        System.out.println("Jugador 2: " + jugador2);
    }

    // Resto del código específico para el juego de ajedrez...
}