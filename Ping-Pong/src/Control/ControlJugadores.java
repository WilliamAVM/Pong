package Control;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author william
 */
public class ControlJugadores extends KeyAdapter {

    public static ControlJugadores cJugadores = new ControlJugadores();
	
	private ControlAgent cAgent;
	
	public static boolean w, s, arriba, abajo;
	public ControlJugadores(){
		
		
		cAgent = ControlAgent.cAgent;
	}
    @Override
    public void keyPressed(KeyEvent e) {
        int id;
        id = e.getKeyCode();
        if (id == KeyEvent.VK_W) {
            w = true;
        }
        if (id == KeyEvent.VK_S) {
            s = true;
        }
        if (id == KeyEvent.VK_UP) {
            arriba = true;
        }
        if (id == KeyEvent.VK_DOWN) {
             abajo= true;
        }
    }
    
    public void keyReleased(KeyEvent e){
        int id;
        id = e.getKeyCode();
        if (id == KeyEvent.VK_W) {
            w = false;
        }
        if (id == KeyEvent.VK_S) {
            s = false;
        }
        if (id == KeyEvent.VK_UP) {
            arriba = false;
        }
        if (id == KeyEvent.VK_DOWN) {
             abajo= false;
        }
    }
}
