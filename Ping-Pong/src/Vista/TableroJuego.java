package Vista;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Control.ControlAgent;
import Modelo.Agent;
import Modelo.Pelota;
import Modelo.Raqueta;
import Modelo.RaquetaAgente;

/**
 *
 * @author william
 */
public class TableroJuego extends JPanel {
	//singleton
    private static final TableroJuego INSTANCE = new TableroJuego();
		
	public Pelota pelota;
	public RaquetaAgente r1;
	public RaquetaAgente r2;
	
	public int height = 500;
	public int width = 800;
	
	private int ptj1,ptj2;
    
	public JLabel puntaje1,puntaje2,jugador1,jugador2;
    
    private TableroJuego() {        
    	//inicializando elementos
    	pelota= new Pelota(400, 200);
    	r1 = new RaquetaAgente(10,300);
    	r2 = new RaquetaAgente(770,200);
    	//puntajes
    	ptj1 = 0;
    	ptj2 = 0;
    	
    	
    	setBounds(0,0,width, height);
    	setBackground(Color.DARK_GRAY);
       
        puntaje1 = new JLabel("puntaje");
        puntaje1.setForeground(Color.LIGHT_GRAY);
        /*puntage1.setFont(new Font("Digifacewide", Font.BOLD, 18));
        
        */add(puntaje1);
        
        
        //score
        jugador1 = new JLabel(""+ptj1);
        jugador2 = new JLabel(""+ptj2);
        jugador1.setForeground(Color.LIGHT_GRAY);
        jugador2.setForeground(Color.LIGHT_GRAY);
        add(jugador1);
        add(jugador2);
    }
    
    public static TableroJuego getInstance(){
    	return INSTANCE;
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
        g.drawLine(width/2, height,width/2, 0);
        g.fill(pelota.getPelota());
        g.fill(r1.getRaqueta());
        g.fill(r2.getRaqueta());
    }
    
    public void Actualizar(){
        pelota.mover(getBounds(),coolision(r1.getRaqueta()),coolision(r2.getRaqueta()));
        r1.mover();               
        r2.mover();        
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
    
    
   public void mostrarScore(){
	   jugador1.setText(""+ptj1);
	   jugador2.setText(""+ptj2);
   }
   
   public void puntoR1(){
	   ptj1++;
   }
   
   public void puntoR2(){
	   ptj2++;
   }
    
    
}
