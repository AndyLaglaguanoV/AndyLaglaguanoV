/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo_correcion._de._prueba;

/**
 *
 * @author PC-MASTER
 */
       public class NOTAS {
    
       private double notaMedia;
       private int aprobados;
       private int totalNotas;
       public NOTAS() {
           
        notaMedia = 0.0;
        aprobados = 0 ;
        totalNotas = 0;


}

    public double getNotaMedia() {
        return notaMedia;
    }

    public void setNotaMedia(double notaMedia) {
        this.notaMedia = notaMedia;
    }

    public int getAprobados() {
        return aprobados;
    }

    public void setAprobados(int aprobados) {
        this.aprobados = aprobados;
    }

    public int getTotalNotas() {
        return totalNotas;
    }

    public void setTotalNotas(int totalNotas) {
        this.totalNotas = totalNotas;
    }

 }

