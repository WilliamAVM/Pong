package Vista;

import Control.Hilo;
import Control.ControlJugadores;
import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame {

    private TableroJuego tj;
    private Hilo hilo;
    private int tipoJuego;
    
    public VentanaPrincipal(int tipoJuego) {
    	
        setTitle("Ping Pong Virtual Proyecto IAD");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.tipoJuego =tipoJuego;
        tj = TableroJuego.getInstance();
        tj.initRaquetas(tipoJuego);
        add(tj);
        addKeyListener(new ControlJugadores());
        setVisible(true);
        hilo = new Hilo(tj);
        hilo.start();
    }
}
