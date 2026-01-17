
package Paquete;
// Importaciones necesarias
import Control.Conexion;  // Importa la clase para manejar la conexión a la base de datos
import com.mysql.jdbc.PreparedStatement;  // Importa la clase para manejar consultas preparadas
import java.awt.*;  // Importa las clases para manejar gráficos y componentes visuales
import java.awt.Graphics;  // Importa la clase Graphics para dibujar en el panel
import java.awt.image.BufferedImage;  // Importa la clase BufferedImage para manejar imágenes
import java.io.File;  // Importa la clase File para manejar archivos
import java.io.IOException;  // Importa la clase IOException para manejar excepciones de entrada/salida
import java.sql.Connection;  // Importa la clase Connection para manejar la conexión a la base de datos
import java.util.ArrayList;  // Importa la clase ArrayList para manejar listas dinámicas
import java.util.List;  // Importa la clase List para manejar listas
import javax.imageio.ImageIO;  // Importa la clase ImageIO para manejar la carga de imágenes
import javax.sound.sampled.AudioInputStream;  // Importa la clase AudioInputStream para manejar archivos de sonido
import javax.sound.sampled.AudioSystem;  // Importa la clase AudioSystem para manejar el sistema de audio
import javax.sound.sampled.Clip;  // Importa la clase Clip para manejar clips de audio
import javax.sound.sampled.LineUnavailableException;  // Importa la clase LineUnavailableException para manejar excepciones de audio
import javax.sound.sampled.UnsupportedAudioFileException;  // Importa la clase UnsupportedAudioFileException para manejar excepciones de audio
import javax.swing.JOptionPane;  // Importa la clase JOptionPane para mostrar mensajes y diálogos
import javax.swing.JPanel;  // Importa la clase JPanel para crear un panel gráfico

// Clase para el panel del juego de Snake
public class PanelSnake extends JPanel {
    // Declaración de variables de instancia
    
    // Conexión a la base de datos MySQL
    Conexion cc = new Conexion();
     String playerName;
    Connection con = (Connection) cc.conexion();  // Establece la conexión a la base de datos

   
     
    
     // Declaración de variables para manejo de sonidos
    private Clip eatClip;  // Clip de sonido para cuando la serpiente come
    private Clip crashClip;  // Clip de sonido para choque con obstáculos
    private Clip limitClip;  // Clip de sonido para choque con límites
    
    // Declaración de imágenes de fondo, serpiente y obstáculos
    private BufferedImage imagenfondo;  // Imagen de fondo del juego
    private BufferedImage imagenSerpiente;  // Imagen de la serpiente
    private BufferedImage imagenObstaculo;  // Imagen de los obstáculos
   // Declaración de listas para coordenadas de obstáculos y serpiente
    List<int[]> obstaculos = new ArrayList<>();  // Lista de coordenadas de obstáculos
    List<int[]> snake = new ArrayList<>();  // Lista de coordenadas de la serpiente
    
    // Declaración de variables para dimensiones y características del juego
    int tammax, tam, can, res;  // Variables relacionadas con dimensiones y tamaños
    
    // Declaración de variables para puntuación y colores
    int score = 0;  // Puntuación actual del jugador
    Color colosnake = Color.green;  // Color de la serpiente
    Color colorcomida = Color.red;  // Color de la comida
    
    // Declaración de coordenadas de la comida y direcciones
    int[] comida = new int[2];  // Coordenadas de la comida
    String direccion = "de";  // Dirección actual de la serpiente
    String direccionproxima = "de";  // Dirección que se tomará en el próximo movimiento
    
    // Declaración de hilo y objeto Caminante para controlar el movimiento
    Thread hilo;  // Hilo para manejar la lógica del juego
    Caminante camino;  // Objeto que implementa la lógica de movimiento
    
   // Constructor de PanelSnake
public PanelSnake(int tammax, int can) {
    this.tammax = tammax;  // Establece el tamaño máximo del tablero
    this.can = can;  // Establece la cantidad de celdas en cada dirección
    this.tam = tammax / can;  // Calcula el tamaño de cada celda
    this.res = tammax % can;  // Calcula el espacio restante

    // Inicialización de la serpiente con dos segmentos
    int[] a = {can / 2 - 1, can / 2 - 1};
    int[] b = {can / 2, can / 2 - 1};
    snake.add(a);
    snake.add(b);

    // Generación de la comida
    generarcomida();

    // Inicialización del hilo y el objeto Caminante
    camino = new Caminante(this);  // Crea un objeto Caminante y le pasa esta instancia de PanelSnake
    hilo = new Thread(camino);  // Crea un hilo para ejecutar el objeto Caminante
    hilo.start();  // Inicia el hilo para controlar el movimiento de la serpiente

  // Ubicaciones de los obstáculos
obstaculos.add(new int[]{5, 10});  // Agrega un nuevo obstáculo en la posición (5, 10)

obstaculos.add(new int[]{6, 10});  // Agrega otro obstáculo en la posición (6, 10)

obstaculos.add(new int[]{5, 11});  // Agrega un obstáculo en la posición (5, 11)

obstaculos.add(new int[]{6, 11});  // Agrega un obstáculo en la posición (6, 11)

obstaculos.add(new int[]{23, 10});  // Agrega un obstáculo en la posición (23, 10)

obstaculos.add(new int[]{24, 10});  // Agrega un obstáculo en la posición (24, 10)

obstaculos.add(new int[]{23, 11});  // Agrega un obstáculo en la posición (23, 11)

obstaculos.add(new int[]{24, 11});  // Agrega un obstáculo en la posición (24, 11)

obstaculos.add(new int[]{5, 23});  // Agrega un obstáculo en la posición (5, 23)

obstaculos.add(new int[]{6, 23});  // Agrega un obstáculo en la posición (6, 23)

obstaculos.add(new int[]{5, 24});  // Agrega un obstáculo en la posición (5, 24)

obstaculos.add(new int[]{6, 24});  // Agrega un obstáculo en la posición (6, 24)

obstaculos.add(new int[]{23, 23});  // Agrega un obstáculo en la posición (23, 23)

obstaculos.add(new int[]{24, 23});  // Agrega un obstáculo en la posición (24, 23)

obstaculos.add(new int[]{23, 24});  // Agrega un obstáculo en la posición (23, 24)

obstaculos.add(new int[]{24, 24});  // Agrega un obstáculo en la posición (24, 24)
  try {
    // Cargar la imagen de fondo desde el paquete
    imagenfondo = ImageIO.read(getClass().getResource("imagenfondo.jpg"));
} catch (IOException e) {
    e.printStackTrace();
}
try {
    // Cargar la imagen de la serpiente desde el paquete
    imagenSerpiente = ImageIO.read(getClass().getResource("culebra.jpg"));
} catch (IOException e) {
    e.printStackTrace();  // Imprime la traza de la excepción en caso de error de carga
}

try {
    // Cargar la imagen de los obstáculos desde el paquete
    imagenObstaculo = ImageIO.read(getClass().getResource("enemigo.jpg"));
} catch (IOException e) {
    e.printStackTrace();  // Imprime la traza de la excepción en caso de error de carga
}
// Cargar los sonidos de choque y límites
 try {
    // Cargar el sonido de choque con obstáculos desde el paquete
    AudioInputStream crashSound = AudioSystem.getAudioInputStream(getClass().getResource("perder.wav"));
    crashClip = AudioSystem.getClip();
    crashClip.open(crashSound);
    
    // Cargar el sonido de choque con límites desde el paquete
    AudioInputStream limitSound = AudioSystem.getAudioInputStream(getClass().getResource("perder.wav"));
    limitClip = AudioSystem.getClip();
    limitClip.open(limitSound);
    
    // Cargar el sonido de comer desde el paquete
    AudioInputStream eatSound = AudioSystem.getAudioInputStream(getClass().getResource("son_comer.wav"));
    eatClip = AudioSystem.getClip();
    eatClip.open(eatSound);
} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
    e.printStackTrace();  // Imprime la traza de la excepción en caso de error de carga
}

    }
    
    
   @Override
public void paint(Graphics pintor){
    super.paint(pintor);  // Llama al método paint de la superclase JPanel
    
    pintor.setColor(colosnake);  // Establece el color de dibujo de la serpiente
    
    // Dibujo del fondo
    pintor.drawImage(imagenfondo, 0, 0, this);  // Dibuja la imagen de fondo en la posición (0, 0)
    
    // Dibujo de obstáculos
    for (int[] obstaculo : obstaculos) {
        pintor.setColor(Color.BLUE);  // Establece el color azul para los obstáculos
        pintor.fillRect(res / 2 + obstaculo[0] * tam, res / 2 + obstaculo[1] * tam, tam - 1, tam - 1);  // Dibuja un rectángulo representando el obstáculo
    }
    
    for (int[] obstaculo : obstaculos) {
        // Cambia el siguiente código para dibujar una imagen en lugar de un rectángulo
        int obstaculoX = res / 2 + obstaculo[0] * tam;  // Calcula la posición x del obstáculo
        int obstaculoY = res / 2 + obstaculo[1] * tam;  // Calcula la posición y del obstáculo
        pintor.drawImage(imagenObstaculo, obstaculoX, obstaculoY, tam - 1, tam - 1, this);  // Dibuja la imagen del obstáculo en la posición calculada
    }
    
    // Dibujo de la serpiente y su imagen
    for(int[] par:snake){
        pintor.setColor(Color.GREEN);  // Establece el color verde para la serpiente
        pintor.fillRect(res/2+par[0]*tam, res/2+par[1]*tam, tam-1, tam-1);  // Dibuja un rectángulo representando un segmento de la serpiente
        pintor.drawImage(imagenSerpiente, res / 2 + par[0] * tam, res / 2 + par[1] * tam, tam - 1, tam - 1, this);  // Dibuja la imagen de la serpiente en la posición calculada
    }
    
    // Dibujo de la comida
    pintor.setColor(colorcomida);  // Establece el color rojo para la comida
    pintor.fillRect(res/2+comida[0]*tam, res/2+comida[1]*tam, tam-1, tam-1);  // Dibuja un rectángulo representando la comida
    pintor.setColor(Color.white);  // Establece el color blanco para el texto
    pintor.drawString("Puntuación: " + score, 10, 20);  // Dibuja la puntuación en la esquina superior izquierda
}

// Método para avanzar la serpiente
public void avanzar() {
    igualardir();  // Igualar las direcciones
    
    int[] ultimo = snake.get(snake.size() - 1);  // Obtener las coordenadas del último segmento de la serpiente
    int agregarx = 0;
    int agregary = 0;
    
    switch (direccion) {
        // Determinar el cambio en las coordenadas según la dirección   
        case "de":
            agregarx = 1;
            break;
        case "iz":
            agregarx = -1;  // Cambia aquí de 1 a -1
            break;
        case "ar":
            agregary = -1;  // Cambia aquí de 1 a -1
            break;
        case "ab":
            agregary = 1;  // Cambia aquí de 1 a -1
            break;
    }

    int[] nuevo = {
        Math.floorMod(ultimo[0] + agregarx, can),  // Calcula la nueva coordenada x
        Math.floorMod(ultimo[1] + agregary, can)   // Calcula la nueva coordenada y
    };
        
    boolean existe=false;
    
    // Cuando choca con un obstáculo
    if (haChocadoConObstaculo(nuevo)) {
        crashClip.setFramePosition(0);  // Reiniciar el clip al principio
        crashClip.start();  // Reproducir el sonido
        // Resto del código para tratar la colisión
    }

    // Cuando choca con los límites
    if (haLlegadoAlBorde(nuevo)) {
        limitClip.setFramePosition(0);  // Reiniciar el clip al principio
        limitClip.start();  // Reproducir el sonido
        // Resto del código para tratar la colisión con los límites
    }
    
  for (int i = 0; i < snake.size(); i++) {
    if (nuevo[0] == snake.get(i)[0] && nuevo[1] == snake.get(i)[1]) {
        existe = true;  // Si la nueva posición coincide con alguna parte del cuerpo de la serpiente, existe colisión
        break;  // Salir del ciclo, ya que no es necesario seguir buscando
    }
}
    
  if (existe || haLlegadoAlBorde(nuevo) || haChocadoConObstaculo(nuevo)) {
    // Mostrar mensaje de pérdida y puntuación
    JOptionPane.showMessageDialog(this, "Has perdido. Puntuación: " + score);

    // Detener el juego
    camino.parar();
    } else {
        if (nuevo[0] == comida[0] && nuevo[1] == comida[1]) {
            // Reiniciar el clip de sonido de comer
            eatClip.setFramePosition(0);
            // Reproducir el sonido de comer
            eatClip.start();
            
            // Agregar la nueva posición de la serpiente
            snake.add(nuevo);
            // Generar una nueva posición para la comida
            generarcomida();
            // Incrementar la puntuación
            incrementarScore();
        } else {
            // Agregar la nueva posición de la serpiente
            snake.add(nuevo);
            // Remover la posición más antigua de la serpiente
            snake.remove(0);
        }
    }
    
if (haExcedidoTiempoLimite()) {
    // Mostrar mensaje de tiempo agotado
    JOptionPane.showMessageDialog(this, "Tiempo agotado. Has jugado 60 segundos.");
    
    // Solicitar al jugador que ingrese su nombre
    playerName = JOptionPane.showInputDialog(this, "¡Juego completado!\nIngrese su nombre:", "Final del Juego", JOptionPane.PLAIN_MESSAGE);

    if (playerName != null && !playerName.isEmpty()) {
        // Crear mensaje con nombre y puntaje
        String message = "Jugador: " + playerName + "\n" +
                         "Puntaje: " + score;
        // Mostrar resultado del juego
        JOptionPane.showMessageDialog(this, message, "Resultado del Juego", JOptionPane.INFORMATION_MESSAGE);
    } else {
        // Mostrar mensaje de error si no se ingresó un nombre válido
        JOptionPane.showMessageDialog(this, "Debes ingresar un nombre válido.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    // Insertar los datos del jugador en la base de datos
    insertarDatos();
    
    // Detener el juego
    camino.parar();
    return;
}
    
    if (haChocadoConObstaculo(nuevo)) {
        // Reiniciar el clip de sonido de choque
        crashClip.setFramePosition(0);
        // Reproducir el sonido de choque
        crashClip.start();
        
        // Mostrar mensaje de colisión con obstáculo y puntuación
        JOptionPane.showMessageDialog(this, "Has chocado con un obstáculo. Tu puntuación: " + score);
        
        // Solicitar al jugador que ingrese su nombre
        playerName = JOptionPane.showInputDialog(this, "Ingresa tu nombre:");
        
        if (playerName != null && !playerName.isEmpty()) {
            // Mostrar resultado del juego si se proporciona un nombre válido
            String message = "Jugador: " + playerName + "\n" +
                             "Puntaje: " + score;
            JOptionPane.showMessageDialog(this, message, "Resultado del Juego", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Mostrar mensaje de error si no se ingresó un nombre válido
            JOptionPane.showMessageDialog(this, "Debes ingresar un nombre válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        // Insertar los datos del jugador en la base de datos
        insertarDatos();
        
        // Detener el juego
        camino.parar();
        return;
    }
    
   if (haLlegadoAlBorde(nuevo)) {
    crashClip.setFramePosition(0);  // Reiniciar el clip al principio
    crashClip.start();  // Reproducir el sonido

    // Mostrar mensaje de colisión con los límites y la puntuación
    JOptionPane.showMessageDialog(this, "Has chocado con un obstáculo. Tu puntuación: " + score);
    
    // Solicitar al jugador que ingrese su nombre
    playerName = JOptionPane.showInputDialog(this, "Ingresa tu nombre:");
    
    // Verificar si se ingresó un nombre válido
    if (playerName != null && !playerName.isEmpty()) {
        // Mostrar resultado del juego con nombre y puntaje
        String message = "Jugador: " + playerName + "\n" +
                         "Puntaje: " + score;
        JOptionPane.showMessageDialog(this, message, "Resultado del Juego", JOptionPane.INFORMATION_MESSAGE);
    } else {
        // Mostrar mensaje de error si no se ingresó un nombre válido
        JOptionPane.showMessageDialog(this, "Debes ingresar un nombre válido.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    // Insertar los datos del jugador en la base de datos
    insertarDatos();
    
    // Detener el juego
    camino.parar();
    return;
}
}
    
 // Método para verificar si la serpiente ha chocado con un obstáculo
private boolean haChocadoConObstaculo(int[] posicion) {
    for (int[] obstaculo : obstaculos) {
        if (posicion[0] == obstaculo[0] && posicion[1] == obstaculo[1]) {
            return true;  // Retorna verdadero si la posición de la serpiente coincide con la posición del obstáculo
        }
    }
    return false;  // Retorna falso si no se encontró ninguna colisión con obstáculos
}

// Método para verificar si la serpiente ha llegado al borde del tablero
private boolean haLlegadoAlBorde(int[] posicion) {
    return posicion[0] == 0 || posicion[0] == can-1 || posicion[1] == 0 || posicion[1] == can-1;
}

// Método para incrementar la puntuación del jugador y actualizar la interfaz
private void incrementarScore() {
    score += 10;  // Ajusta la cantidad de puntos por comida si es necesario
    repaint();    // Vuelve a dibujar el componente para actualizar la puntuación mostrada
}

// Método para generar la ubicación de la comida de manera aleatoria
public void generarcomida() {
    // Variable para verificar si ya existe una ubicación válida para la comida
    boolean existe = false;
    // Coordenadas para la nueva ubicación de la comida
    int a, b;

    // Generar coordenadas aleatorias para la comida
    do {
       // Generar valores aleatorios para 'a' y 'b' dentro del rango (1, can - 2)
a = (int) (Math.random() * (can - 2) + 1);  // Generar un valor aleatorio para 'a'
b = (int) (Math.random() * (can - 2) + 1);  // Generar un valor aleatorio para 'b'

        // Verificar si las coordenadas generadas coinciden con la posición de la serpiente
       for (int[] par : snake) {  // Itera a través de cada segmento de la serpiente
    if (par[0] == a && par[1] == b) {  // Comprueba si las coordenadas generadas coinciden con la posición de la serpiente
        existe = true;  // Marca la existencia de una coincidencia
        break;  // Sale del ciclo for, ya que no es necesario verificar más segmentos
   
    }
}

        // Verificar si las coordenadas generadas coinciden con la posición de la serpiente
for (int[] par : snake) {
    if (par[0] == a && par[1] == b) {
        existe = true;  // Si las coordenadas coinciden, marcar que existe
        break;  // Salir del ciclo 'for' ya que no es necesario seguir verificando
    }
}
    } while (existe); // Repetir el proceso si ya existe una ubicación válida

  this.comida[0] = a;  // Asigna la coordenada x generada a la comida
this.comida[1] = b;  // Asigna la coordenada y generada a la comida

}

// Método para cambiar la dirección de movimiento de la serpiente
public void cambiardireccion(String dir) {
    // Verificar si la dirección actual es "derecha" o "izquierda" y si la dirección próxima es "arriba" o "abajo"
    if (this.direccion.equals("de") || this.direccion.equals("iz") && (dir.equals("ar") || dir.equals("ab"))) {
        // Asignar la dirección próxima
        this.direccionproxima = dir;
    }
        
    // Verificar si la dirección actual es "arriba" o "abajo" y si la dirección próxima es "izquierda" o "derecha"
    if (this.direccion.equals("ar") || this.direccion.equals("ab") && (dir.equals("iz") || dir.equals("de"))) {
        // Asignar la dirección próxima
        this.direccionproxima = dir;
    }
}

// Método para igualar la dirección actual y la próxima
public void igualardir() {
    this.direccion = this.direccionproxima;
}

// Método para verificar si ha excedido el tiempo límite establecido
private boolean haExcedidoTiempoLimite() {
    long currentTime = System.currentTimeMillis();
    return (currentTime - camino.startTime) > camino.tiempoLimite;
}

// Método para insertar los datos del jugador en la base de datos
public void insertarDatos() {
    try {
        // Definir la consulta SQL para insertar los datos en la tabla "snake"
        String SQL = "INSERT INTO snake(estu_nombre, estu_score) VALUES (?, ?)";
        
        // Preparar una declaración para ejecutar la consulta SQL
        PreparedStatement pst = (PreparedStatement) con.prepareStatement(SQL);

        // Asignar los valores a los parámetros en la consulta SQL
        pst.setString(1, playerName); // playerName es el nombre del jugador
        pst.setInt(2, score);         // score es la puntuación del jugador

        // Ejecutar la consulta SQL para insertar los datos en la base de datos
        pst.execute();
        
        // Mostrar un mensaje de éxito si la inserción fue exitosa
        JOptionPane.showMessageDialog(null, "Registro guardado exitosamente");
    } catch (Exception e) {
        // En caso de error, mostrar un mensaje de error que incluye la descripción del error
        JOptionPane.showMessageDialog(null, "Error al guardar el registro: " + e);
    }
}
}