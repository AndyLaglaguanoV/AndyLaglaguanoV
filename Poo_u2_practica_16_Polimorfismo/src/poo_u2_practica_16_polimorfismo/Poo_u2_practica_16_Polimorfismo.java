
package poo_u2_practica_16_polimorfismo;

public class Poo_u2_practica_16_Polimorfismo {
    


    public static void main(String[] args) {
       //llamamos al metodo mostrar datos de figuras
       System.out.println("Figuras ");
       System.out.println("");
       
       System.out.println("Triangulo");
        mostrarDatosFigura(new Triangulo(4,5, "Amarillo"));
        System.out.println("Circulo");
        mostrarDatosFigura(new Circulo(6,"Verde"));
        System.out.println("Cuadrado");
        mostrarDatosFigura(new Cuadrado(4,"Azul"));
        System.out.println("Rectangulo");
         mostrarDatosFigura(new Rectangulo(4,5,"Gris"));
    }
    private static void mostrarDatosFigura(Figura f){
        //aqui está el polimorfismo, este es el metodo
        //la ventaja d esto, es la reutlización de codigo, al forzar a todas las clases a tener el mismo formato del metodo
        //esta expresión, vale para cualquier subClase de figura
        //cuyos objetos vengan aqui como parametros
        
        System.out.println("Color: "+f.getColor());
        System.out.println("Superficie: " + f.superficie());
        System.out.println("");
    }
}