package Control;

import java.util.logging.Level;
import java.util.logging.Logger;
import Vista.TableroJuego;

public class Hilo extends Thread {

    TableroJuego tableroJ;

    public Hilo(TableroJuego tableroJ) {
        this.tableroJ = tableroJ;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(4);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
            }
            tableroJ.repaint();
        }
    }

}
