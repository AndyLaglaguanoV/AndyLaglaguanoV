package Gestion_p1;

public class Gestion {

	 private String producto;
	    private String proveedor;
	    private double precioUnitario;
	    private int unidades;

	    public Gestion(String producto, String proveedor, double precioUnitario, int unidades) {
	        this.producto = producto;
	        this.proveedor = proveedor;
	        this.precioUnitario = precioUnitario;
	        this.unidades = unidades;
	    }

	    public String getProducto() {
	        return producto;
	    }

	    public String getProveedor() {
	        return proveedor;
	    }

	    public double getPrecioUnitario() {
	        return precioUnitario;
	    }

	    public int getUnidades() {
	        return unidades;
	    }

	    public double calcularTotal() {
	        return precioUnitario * unidades;
	    }
	}