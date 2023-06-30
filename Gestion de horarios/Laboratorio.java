/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menu;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author PC-MASTER
 */
public abstract class Laboratorio {

   protected String nombre;
    protected int capacidad;
    protected List<String> equipos;
    
    public Laboratorio(String nombre, int capacidad, List<String> equipos) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.equipos = equipos;
    }
    
    public abstract void mostrarInformacion();
    
    public String getNombre() {
        return nombre;
    }
    
    public int getCapacidad() {
        return capacidad;
    }
    
    public List<String> getEquipos() {
        return equipos;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    
    public void setEquipos(List<String> equipos) {
        this.equipos = equipos;
    }
}
