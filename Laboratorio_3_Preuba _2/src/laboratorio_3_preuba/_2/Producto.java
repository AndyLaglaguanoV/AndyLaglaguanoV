
package laboratorio_3_preuba._2;

//ESTA EL LA CLASE PADRE 
public  abstract class Producto {
    // Atributos nombre, precio
private String nombre;
    private double precio;
//  Metodo constructor 
    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
        //Utilizacion de los getter y setters y del metodo obtenerPrecioPedido() 
        //que recibe como parámetro las unidades pedidas del producto y devuelve el precio final. 
    }
    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double obtenerPrecioPedido(int unidadesPedidas) {
        return unidadesPedidas * precio;
    }
}
