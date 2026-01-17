package controlador;
//Se importan las librerias para que funcione el controlador
import vista.Vista;
import modelo.Modelo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class Controlador implements ActionListener{
    //Se crean los objetos vista y modelo
    public Vista vista;
    public Modelo modelo;
    
    //Se crea un constructor con los parametros de los objetos vista y modelo
    public Controlador(Vista vista, Modelo modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.btnGuardar.addActionListener(this);
    }
    
    //Metodo que inicia el formulario con su titulo y tamaño
    public void iniciar(){
        vista.setTitle("Productos");
        vista.setLocationRelativeTo(null);
    }
    //Se sobreescribe el metodo actionPerformed para que funcione el boton guardar
    //Se obtiene los datos del formulario y se los inserta a la tabla con un vector
    @Override
    public void actionPerformed(ActionEvent e) {
        modelo.setPrecio(vista.txtPrecio.getText());
        modelo.setProducto(vista.txtNombre.getText());
        modelo.setTabla((DefaultTableModel) vista.Tabla.getModel());
        Object datos[] = new Object[]{modelo.getProducto(),modelo.getPrecio()};
        modelo.getTabla().addRow(datos);
    }
    
}
