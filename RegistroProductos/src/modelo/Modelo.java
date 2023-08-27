package modelo;
//Se importan las librerias para que funcione el controlador
import javax.swing.table.DefaultTableModel;

public class Modelo {
    //Se crean los datos que se obtendran del formulario y tabla
    String precio,producto;
    DefaultTableModel tabla;
    
    //Metodos getter y setter que controlan los datos del formulario
    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public DefaultTableModel getTabla() {
        return tabla;
    }

    public void setTabla(DefaultTableModel tabla) {
        this.tabla = tabla;
    }
    
}
