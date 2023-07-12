
package juegoprincipal;

/**
 *
 * @author PC-MASTER
 */
public class JuegoBasquet extends Juego {
    private int puntosEquipoA;
    private int puntosEquipoB;

    public JuegoBasquet(String nombre, int jugadores) {
        super(nombre, jugadores);
        this.puntosEquipoA = 0;
        this.puntosEquipoB = 0;
    }

    public void anotarPuntosEquipoA(int puntos) {
        puntosEquipoA += puntos;
    }

    public void anotarPuntosEquipoB(int puntos) {
        puntosEquipoB += puntos;
    }

    public void obtenerResultado() {
        System.out.println("Resultado final: Equipo A " + puntosEquipoA + " puntos - Equipo B " + puntosEquipoB + " puntos");
    }

    // Resto del código específico para el juego de baloncesto...
}
