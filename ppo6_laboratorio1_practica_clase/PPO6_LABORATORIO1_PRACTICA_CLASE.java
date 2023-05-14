/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ppo6_laboratorio1_practica_clase;

/**
 *
 * @author PC-MASTER
 */
public class PPO6_LABORATORIO1_PRACTICA_CLASE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
             // VALOREES NIÑO 1
        Niño niño1 = new Niño();
        niño1.Nombre= "Joel";
        niño1.Edad= "8";
        niño1.Etnia= "Mestizo";        
        niño1.Color=  "Blanco";
        niño1.Genero=   "Masculino";    
        
        // VALORES NIÑO 2
         Niño niño2 = new Niño();
        niño2.Nombre= "Diego";
        niño2.Edad= "5";
        niño2.Etnia= "Mestizo";        
        niño2.Color=  "Moreno";
        niño2.Genero=   "Masculino";    
        
        // VALORES ZAPATO 1
        Zapato zapato1 = new Zapato();
        zapato1.Color= "Negro";
        zapato1.Talla= "42";
        zapato1.Marca= "Venus";        
        zapato1.Modelo="Casual";
        zapato1.Precio= "35";  
        
         // VALORES ZAPATO 2
        Zapato zapato2 = new Zapato();
        zapato2.Color= "Blanco";
        zapato2.Talla= "40";
        zapato2.Marca= "Adidas";        
        zapato2.Modelo="Deportivo";
        zapato2.Precio= "55";  
        
        
        // VALORES TELEVISOR 1
        Televisor televisor1 = new Televisor();
        televisor1.Color= "Negro";
        televisor1.Pulgadas= "55";
        televisor1.Marca= "LG";        
        televisor1.Pantalla=  "Oled";
        televisor1.Precio=   "1200";    
        
        
        // VALORES TELEVISOR 1
        Televisor televisor2 = new Televisor();
        televisor2.Color= "Blanco";
        televisor2.Pulgadas= "75";
        televisor2.Marca= "TCL";        
        televisor2.Pantalla=  "LCD";
        televisor2.Precio=   "850";    
        
        
        System.out.println(televisor1.Color);
        System.out.println(televisor1.Pulgadas);
        
        
        
        
        
        
    }
    
}
