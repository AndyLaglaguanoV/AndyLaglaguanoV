
package Paquete;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Caminante implements Runnable {
    PanelSnake panel; // Referencia al panel del juego
    boolean estado = true; // Control del estado del hilo
    long startTime; // Tiempo de inicio del hilo
    final long tiempoLimite = 60 * 1000; // Tiempo límite en milisegundos (60 segundos)
    
    // Constructor de la clase Caminante.
    public Caminante (PanelSnake panel){
         this.panel = panel; // Almacena la referencia al panel
        startTime = System.currentTimeMillis(); // Guarda el tiempo de inicio
        
    }
//Método que se ejecuta en el hilo.
 @Override
    public void run() {
        while (estado) { // Mientras el estado sea true
            panel.avanzar(); // Avanza el juego
            panel.repaint(); // Actualiza la representación gráfica

            try {
                Thread.sleep(200); // Pausa el hilo durante 200 milisegundos
            } catch (InterruptedException ex) {
                Logger.getLogger(Caminante.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    // Método para detener el hilo.
    public void parar(){
        this.estado= false;// Cambia el estado a false
    } 
}
