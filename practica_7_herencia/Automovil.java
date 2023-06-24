
package practica_7_herencia;

/**
 *
 * @author PC-MASTER
 */
public class Automovil extends Vehiculo {
    
    boolean parabrisas;
    
    @Override
    public void encendido(){
    encendido=true;
    estado="Vehiculo encendido";
    
}
    public void apagado(){
    encendido=false;
    estado="Vehiculo apagado";
}    
    
}
