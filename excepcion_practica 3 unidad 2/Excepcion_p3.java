/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package excepcion_p3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Excepcion_p3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String nombre = br.readLine();
            int div = 8/0;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ArithmeticException e) {
            System.out.println("No se puede dividir entre 0: " + e.getMessage());
        }
    }
}