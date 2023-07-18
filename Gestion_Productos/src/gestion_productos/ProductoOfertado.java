
package gestion_productos;
public class ProductoOfertado extends Producto {
    private int dias;

    public ProductoOfertado(String nombre, double precio, int dias) {
        super(nombre, precio);
        this.dias = dias;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    @Override
    public double obtenerPrecioPedido(int unidadesPedidas) {
        if (dias == 1) {
            return super.getPrecio() * unidadesPedidas * 0.8; // Aplica un 20% de descuento
        } else if (dias == 2 || dias == 3) {
            return super.getPrecio() * unidadesPedidas * 0.85; // Aplica un 15% de descuento
        } else {
            return super.getPrecio() * unidadesPedidas * 0.9; // Aplica un 10% de descuento
        }
    }
}