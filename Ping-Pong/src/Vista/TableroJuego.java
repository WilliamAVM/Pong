package Vista;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Modelo.Pelota;
import Modelo.Raqueta;
import sun.java2d.loops.CompositeType;
import sun.java2d.loops.DrawLine;
import sun.java2d.loops.SurfaceType;

/**
 *
 * @author william
 */
public class TableroJuego extends JPanel {
    Pelota pelota= new Pelota(400, 200);
    Raqueta r1 = new Raqueta(10,200);
    Raqueta r2 = new Raqueta(770,200);
    public JLabel puntage1,puntage2;
    
    public TableroJuego() {
        setBackground(Color.DARK_GRAY);
        
        puntage1 = new JLabel("puntage");
        puntage1.setForeground(Color.LIGHT_GRAY);
        /*puntage1.setFont(new Font("Digifacewide", Font.BOLD, 18));
        
        */add(puntage1);
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.BLACK);
        Dibujar(g2);
        Actualizar();
    }
    
    public void Dibujar(Graphics2D g){
        g.drawLine(380, 500,380, 0);
        g.fill(pelota.getPelota());
        g.fill(r1.getRaqueta());
        g.fill(r2.getRaqueta());
    }
    
    public void Actualizar(){
        pelota.mover(getBounds(),coolision(r1.getRaqueta()),coolision(r2.getRaqueta()));
        r1.MoverRaqueta1(getBounds());
        r2.MoverRaqueta2(getBounds());
    }
    
    public void Iterarjuego(){
        while(true){
            repaint();
            try {
                Thread.sleep(6);
            } catch (InterruptedException ex) {
                Logger.getLogger(TableroJuego.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private boolean coolision(Rectangle2D r){
        return pelota.getPelota().intersects(r);
    }
}
