/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poo_correcion._de._prueba;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author PC-MASTER
 */
public class POO_CORRECION_DE_PRUEBA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
   ArrayList<Integer> notas = new ArrayList<>();
 int aprobados = 0;
 Scanner scanner = new Scanner(System.in);
 int opcion = 0;

       do { //Creamos el menú principal de opciones
      System.out.println("===== MENU PRINCIPAL =====");
      System.out.println("1 - Agregar nota");
      System.out.println("2 - Ver nota media");
      System.out.println("3 - Ver aprobados");
      System.out.println("4 - Salir");
      System.out.print("Seleccione una opcion: ");
      opcion = scanner.nextInt();

      switch (opcion) { //Utilizamos la opcion switch las opcones que el usuario va a elegir
          
      case 1:
          
            System.out.print("Ingrese la nota: ");
            int nota = scanner.nextInt();
            notas.add(nota);
            break;
            
      case 2:
          
             double notaMedia = calcularNotaMedia(notas);
            System.out.println("La nota media es: " + notaMedia);
            break;
            
      case 3:
          
            int numAprobados = contarAprobados(notas);
            System.out.println("El numero notas de  aprobados es: " + numAprobados);
            break;
      case 4:
          
            System.out.println("Gracias por su preferencia...");
            break;
            default:
            System.out.println("Opcion no valida, elija otra opcion valida.");
            break;
    }

         System.out.println();
   }        while (opcion != 4);

           scanner.close();
      }
    //El método calcularNotaMedia toma como argumento un ArrayList de enteros llamado notas
    //y calcula la nota media de los valores en la lista. Si la lista está vacía, devuelve 0.
    
     public static double calcularNotaMedia(ArrayList<Integer> notas) {
     if (notas.size() == 0) {
      return 0;
 }

        int suma = 0;
        for (int nota : notas) {
         suma += nota;
  }

 return (double) suma / notas.size();
  }
       // El método contarAprobados también toma como argumento un ArrayList de enteros
       //llamado notas y cuenta el número de elementos en la lista que son mayores o iguales a 14,
      //es decir, las notas aprobadas. Inicializa una variable aprobados
    
 
      public static int contarAprobados(ArrayList<Integer> notas) {
     int aprobados = 0;
     for (int nota : notas) {
     if (nota >= 14) {
     aprobados++;
   }
 }
      return aprobados;
    }
    
}
