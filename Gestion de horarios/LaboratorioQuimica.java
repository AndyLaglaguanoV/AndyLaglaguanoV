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
public class LaboratorioQuimica    extends Laboratorio {
    private int cantidadSustancias;
    private boolean requiereVentilacionEspecial;
    
    public LaboratorioQuimica(String nombre, int capacidad, List<String> equipos, int cantidadSustancias, boolean requiereVentilacionEspecial) {
        super(nombre, capacidad, equipos);
        this.cantidadSustancias = cantidadSustancias;
        this.requiereVentilacionEspecial = requiereVentilacionEspecial;
    }
    
    @Override
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Capacidad: " + capacidad);
        System.out.println("Equipos:");
        for (String equipo : equipos) {
            System.out.println("- " + equipo);
        }
        System.out.println("Cantidad de sustancias: " + cantidadSustancias);
        System.out.println("Requiere ventilación especial: " + (requiereVentilacionEspecial ? "Sí" : "No"));
    }
    
    public int getCantidadSustancias() {
        return cantidadSustancias;
    }
    
    public boolean requiereVentilacionEspecial() {
        return requiereVentilacionEspecial;
    }
    
    public void setCantidadSustancias(int cantidadSustancias) {
        this.cantidadSustancias = cantidadSustancias;
    }
    
    public void setRequiereVentilacionEspecial(boolean requiereVentilacionEspecial) {
        this.requiereVentilacionEspecial = requiereVentilacionEspecial;
    }
}

