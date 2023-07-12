
package laboratorio_3_preuba._2;
//Clase hija que hereda de la clase padre Producto
public class ProductoOfertado extends Producto {
    private int dias; //Atributo 
//CONSTRUCTOR 
    public ProductoOfertado(String nombre, double precio, int dias) {
        super(nombre, precio);//Usamos el super para llamar al cosntructor de la super clase 
        this.dias = dias;
    }
  //Utilizacion de los getter y setters
    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }
//El @Override sobrescribe el método obtenerPrecioPedido()
    @Override
    public double obtenerPrecioPedido(int unidadesPedidas) {
        if (dias == 1) {
            return super.obtenerPrecioPedido(unidadesPedidas) * 0.8; // Aplica un 20% de descuento
        } else if (dias == 2 || dias == 3) {
            return super.obtenerPrecioPedido(unidadesPedidas) * 0.85; // Aplica un 15% de descuento
        } else {
            return super.obtenerPrecioPedido(unidadesPedidas) * 0.9; // Aplica un 10% de descuento
        }
    }
}