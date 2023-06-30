/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menu;
import java.util.List;
/**
 *
 * @author PC-MASTER
 */
public class LaboratorioInformatica  extends Laboratorio {
    private String ubicacion;
    private boolean tieneProyector;
    
    public LaboratorioInformatica(String nombre, int capacidad, List<String> equipos, String ubicacion, boolean tieneProyector) {
        super(nombre, capacidad, equipos);
        this.ubicacion = ubicacion;
        this.tieneProyector = tieneProyector;
    }
    
    @Override
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Capacidad: " + capacidad);
        System.out.println("Equipos:");
        for (String equipo : equipos) {
            System.out.println("- " + equipo);
        }
        System.out.println("Ubicacion: " + ubicacion);
        System.out.println("Tiene proyector: " + (tieneProyector ? "Sí" : "No"));
    }
    
    public String getUbicacion() {
        return ubicacion;
    }
    
    public boolean tieneProyector() {
        return tieneProyector;
    }
    
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    public void setTieneProyector(boolean tieneProyector) {
        this.tieneProyector = tieneProyector;
    }
}


