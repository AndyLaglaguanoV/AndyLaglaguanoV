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
public class LaboratorioBiologia extends Laboratorio {
    private String areaEstudio;
    
    public LaboratorioBiologia(String nombre, int capacidad, List<String> equipos, String areaEstudio) {
        super(nombre, capacidad, equipos);
        this.areaEstudio = areaEstudio;
    }
    
    @Override
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Capacidad: " + capacidad);
        System.out.println("Equipos:");
        for (String equipo : equipos) {
            System.out.println("- " + equipo);
        }
        System.out.println("Area de estudio: " + areaEstudio);
    }
    
    public String getAreaEstudio() {
        return areaEstudio;
    }
    
    public void setAreaEstudio(String areaEstudio) {
        this.areaEstudio = areaEstudio;
    }
}
    
