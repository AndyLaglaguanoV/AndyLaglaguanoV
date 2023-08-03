/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poo.tutoria8.arreglos;

import java.util.Scanner;

/**
 *
 * @author PC-MASTER
 */
public class POOTUTORIA8ARREGLOS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         Scanner sc = new Scanner (System.in);
       int op;
       do{
           System.out.println("MENU DE ARREGLOS");
           System.out.println("1. REGISTRO DE DATOS");
           System.out.println("2. INGRESO DE NUMEROS");
           System.out.println("3. SALIR");
           System.out.println("Elija una opcion: ");
           
           op= sc.nextInt();
           switch (op){
            case 1:
                registroDatos();
		break;
                
            case 2:
               ingresoNumeros();
		break;
            
            case 3: 
                System.out.println("Ha finalizado el programa");  
		break;
               default:System.out.println("Opcíon inválida. Intente nuevamente");
           
        }              
           
       }while (op!=3);
    }
    static void registroDatos(){
        Scanner sc= new Scanner (System.in);
        
        System.out.println("Ingrese la cantidad de personas que va a registrar: ");
        //Creamos arreglos para el ingreso de datos como nombres, edades, direcciones
        int cantPersonas = sc.nextInt();
        String [] nombres =new String [cantPersonas];
        int [] edades = new int [cantPersonas];
        String [] direcciones = new String [cantPersonas];
        
        for (int i=0; i< cantPersonas; i++){
            System.out.println("---> Persona"+(i+1)+" :");
            System.out.println("Nombre: ");
            String nombre = sc.nextLine();
            nombres [i] = nombre;
            sc.nextLine();
            System.out.println("Edad: ");
            int edad = sc.nextInt();
            edades[i]=edad;
            System.out.println("Direccion: ");
            String direccion = sc.nextLine();
            direcciones [i]= direccion;    
        }
        System.out.println("=========================================");
        System.out.println("         REGISTRO DE DATOS               ");
        System.out.println("=========================================");
        for (int i=0; i< cantPersonas; i++){
            System.out.println("Datos de personas "+(i+1)+ " :");
            System.out.println("Nombre: "+nombres[i]);
            System.out.println("Edad: "+edades[i]);
            System.out.println("Direccion: "+direcciones[i]);
            
        }
    }
    static void ingresoNumeros(){
         Scanner sc= new Scanner (System.in);
         System.out.println("Ingrese la cantidad de numeros que va a registrar");
        int n =sc.nextInt();
        int[] numeros = new int[n];
        for (int i = 0; i<n;i++){
              System.out.println("Ingrese el numero: "+(i+1)+ " :");
              numeros[i]= sc.nextInt();
        }
          System.out.println("Los numeros ingresados en orden son: ");
          for (int i = n-1; i>=0; i--){
              System.out.println(numeros[i]);
          }
    }
}