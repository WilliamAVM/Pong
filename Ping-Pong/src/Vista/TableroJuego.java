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
	
    private Agent agent;
	
	private Pelota pelota= new Pelota(400, 200);
	private Raqueta r1 = new Raqueta(10,300);
	private RaquetaAgente r2 = new RaquetaAgente(770,200);
	
	private int height = 500;
	private int width = 800;
    
	public JLabel puntage1,puntage2;
    
    public TableroJuego() {
        agent = new Agent();
    	
    	setBackground(Color.DARK_GRAY);
       
        puntage1 = new JLabel("puntaje");
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
        System.out.println(r2.x+" , " + r2.y);
        boolean arriba = getMovAgentArriba();
        boolean abajo = getMovAgentAbajo();
        r2.mover(getBounds(),arriba,abajo);
        
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
    
    
    private boolean getMovAgentArriba(){
    	//inputs agent
    	int dx = Math.abs(pelota.x-r2.x);
    	int dy = -1*(pelota.y-r2.y);
    	int dxp = (dx*100)/width;
    	int dyp = (dy*100)/height;
    	//asignando    	
    	agent.input(dxp, dyp);
    	boolean mov = false;
    	if(agent.output()>0){
    		mov= true;
    	}    	
    	return mov;
    }
    
    private boolean getMovAgentAbajo(){
    	//inputs agent
    	int dx = Math.abs(pelota.x-r2.x);
    	int dy = -1*(pelota.y-r2.y);
    	int dxp = (dx*100)/width;
    	int dyp = (dy*100)/height;
    	//asignando   
    	agent.input(dxp,dyp);
    	boolean mov = false;
    	if(agent.output()<0){
    		mov= true;
    	}    	
    	return mov;
    }
    
    
       
    
}
