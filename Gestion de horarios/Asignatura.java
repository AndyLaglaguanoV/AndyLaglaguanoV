/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menu;

/**
 *
 * @author PC-MASTER
 */
public class Asignatura {

  private String nombre;
    private String horario;
    private String laboratorioAsignado;
    
    public Asignatura(String nombre, String horario) {
        this.nombre = nombre;
        this.horario = horario;
    }
    
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Horario: " + horario);
        System.out.println("Laboratorio asignado: " + laboratorioAsignado);
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getHorario() {
        return horario;
    }
    
    public String getLaboratorioAsignado() {
        return laboratorioAsignado;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setHorario(String horario) {
        this.horario = horario;
    }
    
    public void setLaboratorioAsignado(String laboratorioAsignado) {
        this.laboratorioAsignado = laboratorioAsignado;
    }
}
