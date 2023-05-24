/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poo_09_get_set;

import java.util.Scanner;

/**
 *
 * @author PC-MASTER
 */
public class POO_09_GET_SET {

    public static void main(String[] args) {
     // TODO code application logic here
        
        //Este programa permite solicitar al usuario datos personales
      //los coloca en objetos de la clase persona y luego 
      //muestra en pantalla
      Scanner teclado=new Scanner(System.in);
      //el objeto teclado de la clase Scanner permite el usuario ingresar
      //informacion desde el teclado
      //creamos 3 variables auxiliares que recibiran los datos 
      //ingresados por el usuario via teclado
      String nombre, apellido;
      int edad;
      System.out.print("Ingrese su nombre:");
      nombre=teclado.nextLine();//se almacena en la variable nombre lo que 
                               //el usuario ha digitado
      System.out.println("Ingrese su apellido");
      apellido=teclado.nextLine();//nextLine()recupera la informacion ingresada
                                  //por teclado en formato String
      System.out.println("Ingrese su edad");
      edad=teclado.nextInt();//nextInt() recupera la informacion ingresada
                             //por teclado en formato int
                             
      //vamos a crear un objeto de la clase Persona y vamos a asignar
      //a sus atributos los valores que se han recogido por teclado
      PERSONA persona= new PERSONA(); 
      persona.setNombre(nombre);
      persona.setApellido(apellido);
      persona.setEdad(edad);
      
      //mostrar los valors almacenados en cada atributo
      
      System.out.println("Datos de la persona");
      System.out.println("Nombre:"+persona.getNombre());
      System.out.println("Apellido: "+persona.getApellido());
      System.out.println("Edad: "+persona.getEdad());
      
    }
}
