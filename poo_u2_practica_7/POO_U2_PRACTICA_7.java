/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poo_u2_practica_7;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import com.csvreader.CsvWriter;
import com.csvreader.CsvReader;
 
/**
 *
 * @author PC-MASTER
 */
public class POO_U2_PRACTICA_7 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
   Persona persona = new Persona("John Doe", 123456789, "johndoe@example.com");
    System.out.println("Nombre: " + persona.getNombre());
    System.out.println("Telefono: " + persona.getTelefono());
    System.out.println("Email: " + persona.getEmail());
        
        
       List<Persona> personas = new ArrayList<Persona>();
        personas.add(new Persona("aaa L", 223323322, "@aaa@emaill.com"));
        personas.add(new Persona("aaa V", 233323322, "@eee@emaill.com"));
        


        ExportarCSV(personas);
    }

    public static void ExportarCSV(List<Persona> personas) {
        String salidaArchivo = "Persona.csv";
        boolean existe = new File(salidaArchivo).exists();

        if (existe) {
            File archivoPersona = new File(salidaArchivo);
            archivoPersona.delete();
        }

        try {
            CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');

            salidaCSV.write("Nombre");
            salidaCSV.write("Telefono");
            salidaCSV.write("Email");

            salidaCSV.endRecord();

            for (Persona persona : personas) {
                salidaCSV.write(persona.getNombre());
                salidaCSV.write(String.valueOf(persona.getTelefono()));
                salidaCSV.write(persona.getEmail());

                salidaCSV.endRecord();
            }

            salidaCSV.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ImportarCSV() {
        try {
            List<Persona> personas = new ArrayList<Persona>();

            CsvReader leerPersona = new CsvReader("Persona.csv");
            leerPersona.readHeaders();

            while (leerPersona.readRecord()) {
                String nombre = leerPersona.get(0);
                int telefono = Integer.parseInt(leerPersona.get(1));
                String email = leerPersona.get(2);

                personas.add(new Persona(nombre, telefono, email));
            }

            leerPersona.close();

            for (Persona persona : personas) {
                System.out.println(persona.getNombre() + " , "
                        + persona.getTelefono() + " , "
                        + persona.getEmail());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}