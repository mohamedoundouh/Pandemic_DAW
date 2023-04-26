import javax.swing.*;
import java.awt.*;
import java.util.*;

public class mapa extends JPanel {
    
    private int[] xCoordenadas;
    private int[] yCoordenadas;
    private String[] nombresCiudades;
    private Image mapa;
    
    public mapa(int[] xCoordenadas, int[] yCoordenadas, String[] nombresCiudades, String archivoMapa) {
        this.xCoordenadas = xCoordenadas;
        this.yCoordenadas = yCoordenadas;
        this.nombresCiudades = nombresCiudades;
        this.mapa = new ImageIcon(archivoMapa).getImage();
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Dibujamos la imagen del mapa del mundo
        g.drawImage(mapa, 0, 0, this);
        
        // Configuramos el estilo de la fuente para los nombres de las ciudades
        Font font = new Font("Arial", Font.BOLD, 12);
        g.setFont(font);
        
        // Dibujamos cada ciudad en el mapa
        for (int i = 0; i < xCoordenadas.length; i++) {
            g.setColor(Color.RED);
            g.fillOval(xCoordenadas[i], yCoordenadas[i], 10, 10);
            g.setColor(Color.BLACK);
            g.drawString(nombresCiudades[i], xCoordenadas[i] + 10, yCoordenadas[i] - 10);
        }
    }
    
    public static void main(String[] args) {
        // Coordenadas de algunas ciudades
        int[] xCoordenadas = {235, 300, 320, 350};
        int[] yCoordenadas = {315, 280, 320, 280};
        String[] nombresCiudades = {"San Francisco", "Chicago", "Atlanta", "Montreal"};
        String archivoMapa = ".\\src\\mapa_mundo.png";
        
        // Creamos el panel con el mapa y las ciudades
        mapa panel = new mapa(xCoordenadas, yCoordenadas, nombresCiudades, archivoMapa);
        
        // Creamos la ventana
        JFrame ventana = new JFrame("Mapa de ciudades");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.add(panel);
        ventana.setSize(1288, 575);
        ventana.setVisible(true);
    }
}
