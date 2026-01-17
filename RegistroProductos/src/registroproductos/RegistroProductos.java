package registroproductos;
//Se importan las librerias de controlador modelo y vista
//Para que funcione el formulario
import controlador.Controlador;
import modelo.Modelo;
import vista.Vista;

public class RegistroProductos {
    //Metodo principal main
    public static void main(String[] args) {
        //Se instancia los objetos modelo y vista 
        Modelo modelo = new Modelo();
        Vista vista = new Vista();
        
        //Se instancia el objeto controlador mandando como parametros
        //Los objetos modelo y vista
        Controlador controlador = new Controlador(vista,modelo);
        
        //Se llama al metodo iniciar para que inicie el controlador
        controlador.iniciar();
        //Se habilita la visualizacion del formulario
        vista.setVisible(true);
    }
    
}
