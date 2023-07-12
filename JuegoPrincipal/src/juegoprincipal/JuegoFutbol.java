
package juegoprincipal;


public class JuegoFutbol extends Juego {
    private int golesEquipoA;
    private int golesEquipoB;

    public JuegoFutbol(String nombre, int jugadores) {
        super(nombre, jugadores);
        this.golesEquipoA = 0;
        this.golesEquipoB = 0;
    }

    public void marcarGolEquipoA() {
        golesEquipoA++;
    }

    public void marcarGolEquipoB() {
        golesEquipoB++;
    }

    public void obtenerResultado() {
        System.out.println(" Resultado final: Equipo A " + golesEquipoA + " - Equipo B " + golesEquipoB);
    }

}
