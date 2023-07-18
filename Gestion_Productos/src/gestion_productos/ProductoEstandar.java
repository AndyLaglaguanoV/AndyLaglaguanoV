// Clase ProductoEstandar (clase hija)
package gestion_productos;
public class ProductoEstandar extends Producto {
    private String seccion;

    public ProductoEstandar(String nombre, double precio, String seccion) {
        super(nombre, precio);
        this.seccion = seccion;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    @Override
    public double obtenerPrecioPedido(int unidadesPedidas) {
        if (unidadesPedidas >= 5) {
            return super.getPrecio() * unidadesPedidas * 0.9; // Aplica un 10% de descuento
        } else {
            return super.getPrecio() * unidadesPedidas;
        }
    }
}