
package Paquete;
// Importaciones necesarias

import javax.swing.*;  // Importa clases relacionadas con componentes gráficos y ventanas Swing
import java.awt.*;      // Importa las clases básicas para la creación de GUI y manejo de gráficos
import java.awt.event.ActionEvent;   // Importa la clase para manejar eventos de acción
import java.awt.event.ActionListener;  // Importa la interfaz para implementar escuchadores de eventos de acción
import java.io.IOException;  // Importa la excepción de E/S (entrada/salida) para manejar errores relacionados con archivos
import javax.imageio.ImageIO;  // Importa la clase para trabajar con imágenes y cargarlas
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;  // Importa una constante para configurar el comportamiento de cierre de ventanas

// Clase principal que extiende de JFrame (ventana)
public class InicioBoton extends JFrame {
  private Image imagenFondo;  // Declaración de la variable para almacenar la imagen de fondo

// Constructor de la clase
public InicioBoton() {
    // Configuración de la ventana
    setTitle("Inicio del Juego");  // Establece el título de la ventana
    setDefaultCloseOperation(EXIT_ON_CLOSE);  // Establece el comportamiento de cierre al hacer clic en la "X"

    // Carga y establece la imagen de fondo en el fondo de la ventana
    cargarImagenFondo("fondo.jpg");  // Llama al método para cargar la imagen de fondo
    setContentPane(new JPanel() {    // Crea un JPanel personalizado como contenido de la ventana
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);  // Dibuja la imagen de fondo en el JPanel
        }
    });


    // Cargar la imagen para el botón de inicio
     ImageIcon iconoOriginal = new ImageIcon(getClass().getResource("star_game.jpg"));

    // Escalar la imagen a un tamaño deseado (200 de ancho, altura proporcional)
    Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(200, -1, Image.SCALE_SMOOTH);

   // Crear un nuevo icono con la imagen escalada
   ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);

   // Crear un botón con el icono escalado como contenido
   JButton botonIniciar = new JButton(iconoEscalado);

   // Configurar el aspecto del botón
   botonIniciar.setContentAreaFilled(false);  // No rellenar el área del botón con color
   botonIniciar.setBorderPainted(false);       // No dibujar el borde del botón
   botonIniciar.setFocusPainted(false);        // No resaltar el botón cuando está enfocado
   botonIniciar.setOpaque(false);              // No pintar el fondo del botón

  // Configurar la acción al hacer clic en el botón de inicio
   botonIniciar.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        abrirVentanaJuego();  // Llamar al método para abrir la ventana del juego
    }
});

        // Cargar la imagen para el botón de salir
      ImageIcon iconoSalir = new ImageIcon(getClass().getResource("salir.jpg"));

      // Escalar la imagen a un tamaño deseado (150 de ancho, altura proporcional)
      Image imagenEscaladaSalir = iconoSalir.getImage().getScaledInstance(150, -1, Image.SCALE_SMOOTH);

       // Crear un nuevo icono con la imagen escalada
       ImageIcon iconoEscaladoSalir = new ImageIcon(imagenEscaladaSalir);

       // Crear un botón con el icono escalado como contenido
      JButton botonSalir = new JButton(iconoEscaladoSalir);

// Configurar el aspecto y la acción del botón de salir
    botonSalir.setContentAreaFilled(false);  // No rellenar el área del botón con color
    botonSalir.setBorderPainted(false);       // No dibujar el borde del botón
    botonSalir.setFocusPainted(false);        // No resaltar el botón cuando está enfocado
    botonSalir.setOpaque(false);              // No pintar el fondo del botón

    // Configurar la acción al hacer clic en el botón de salir
    botonSalir.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);  // Salir de la aplicación
    }
});

        // Crear un panel para el título "SNAKE"
JPanel panelTitulo = new JPanel();

// Configurar la transparencia del panel para que el fondo se muestre
panelTitulo.setOpaque(false);

// Crear una etiqueta con el texto "SNAKE" y ajustar su apariencia
JLabel labelTitulo = new JLabel("SNAKE");
labelTitulo.setFont(new Font("Arial Black", Font.BOLD, 50));  // Establecer fuente y tamaño
labelTitulo.setForeground(Color.BLACK);  // Establecer el color del texto

// Agregar la etiqueta al panel de título
panelTitulo.add(labelTitulo);

// Crear un panel para organizar los componentes en el centro
JPanel panelCentro = new JPanel(new GridBagLayout());

// Configurar la transparencia del panel de centro
panelCentro.setOpaque(false);

// Configurar restricciones de diseño (GridBagConstraints)
GridBagConstraints gbc = new GridBagConstraints();
gbc.gridx = 0;
gbc.gridy = 0;
gbc.insets = new Insets(50, 0, 50, 0);  // Espacios entre los componentes

// Agregar el panel de título al panel de centro con las restricciones
panelCentro.add(panelTitulo, gbc);

// Actualizar las restricciones para el siguiente componente
gbc.gridy = 1;
gbc.insets = new Insets(0, 0, 50, 0);

// Agregar el botón de inicio al panel de centro con las restricciones
panelCentro.add(botonIniciar, gbc);

// Actualizar las restricciones para el siguiente componente
gbc.gridy = 2;
gbc.insets = new Insets(0, 0, 50, 0);

   // Agregar el botón de salir al panel de centro con las restricciones
   panelCentro.add(botonSalir, gbc);

// Configurar el diseño general de la ventana y ajustar su tamaño y posición
   setLayout(new BorderLayout());
   add(panelCentro, BorderLayout.CENTER);  // Agregar el panel de centro a la ventana
   setSize(800, 600);  // Establecer el tamaño de la ventana
   setLocationRelativeTo(null);  // Centrar la ventana en la pantalla
}

    // Método para cargar la imagen de fondo desde un archivo
private void cargarImagenFondo(String rutaImagen) {
    try {
        imagenFondo = ImageIO.read(getClass().getResource(rutaImagen));
    } catch (IOException e) {
        e.printStackTrace();
    }
}

// Método para abrir la ventana de juego al hacer clic en el botón de inicio
private void abrirVentanaJuego() {
    // Mostrar un mensaje de bienvenida e instrucciones
    JOptionPane.showMessageDialog(this, "¡Bienvenido al juego!\nEl juego tiene una duración de 1 minuto.", "Instrucciones", JOptionPane.INFORMATION_MESSAGE);
    
    // Crear una instancia de la clase "Vista" (ventana del juego)
    Vista vistaJuego = new Vista();
    
    // Hacer visible la ventana del juego
    vistaJuego.setVisible(true);
}

// Punto de entrada para ejecutar la aplicación
public static void main(String[] args) {
    // Crear una instancia de la clase "InicioBoton" (ventana de inicio)
    InicioBoton inicioBoton = new InicioBoton();
    
    // Hacer visible la ventana de inicio
    inicioBoton.setVisible(true);
}
}
