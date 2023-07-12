
package laboratorio_3_preuba._2;
//CLASE HIJA APLICANDO LA HERENCIA PRODUCTO QUE HEREDA LA CLASE PRINCIPAL
public class ProductoEstandar extends Producto {
  private String seccion; //ATRIBUTO QUE SE USARA PARA ESTA CLASE HIJA 
//CONSTRUCTOR 
    public ProductoEstandar(String nombre, double precio, String seccion) {
        super(nombre, precio);//Usamos el super para llamar al cosntructor de la super clase 
        this.seccion = seccion;
    }
  //Utilizacion de los getters y setters
    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }
//El @Override sobrescribe el método obtenerPrecioPedido()
    @Override
    public double obtenerPrecioPedido(int unidadesPedidas) {
        if (unidadesPedidas >= 5) {
            return super.obtenerPrecioPedido(unidadesPedidas) * 0.9; // Aplica un 10% de descuento
        } else {
            return super.obtenerPrecioPedido(unidadesPedidas);
        }
    }
}