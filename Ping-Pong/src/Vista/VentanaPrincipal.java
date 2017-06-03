package Vista;

import Control.Teclado;
import javax.swing.JFrame;
import Modelo.Hilo;

/**
 *
 * @author william
 */
public class VentanaPrincipal extends JFrame {

    private TableroJuego tj;
    private Hilo hilo;
    public VentanaPrincipal() {
        setTitle("Ping Pong Virtual Proyecto IAD");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tj = new TableroJuego();
        add(tj);
        addKeyListener(new Teclado());
        setVisible(true);
        hilo = new Hilo(tj);
        hilo.start();
    }
}
