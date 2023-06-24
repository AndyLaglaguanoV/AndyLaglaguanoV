
package practica_7_herencia;

/**
 *
 * @author PC-MASTER
 */
public class Practica_7_herencia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     Vehiculo veh = new Vehiculo ();
     Automovil  auto = new Automovil ();
     Motocicletas  moto = new Motocicletas ();
     
     
        veh.encendido();
        auto.encendido();
        moto.encendido();
        
       
        System.out.println(veh.estado);
        System.out.println(auto.estado);
        System.out.println(moto.estado);

    }
              
}
             
       