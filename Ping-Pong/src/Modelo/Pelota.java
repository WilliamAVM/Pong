package Modelo;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import Vista.TableroJuego;

/**
 *
 * @author willi
 */
public class Pelota {

    public static Pelota pelota= new Pelota();
	
	public int x, y,cx,cy,r=20;
    private int dx=1, dy=1;
    
    public Pelota() {
        this.x = 400;
        this.y = 200;
    }
    
    private void calcularCentros(){
    	cx = x + r/2;
    	cy = y + r/2;
    }
    
    
    public Pelota(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public Rectangle2D getPelota() {
    	calcularCentros();
        return new Rectangle2D.Double(x, y, r, r);
    }
        
    
    private void acelerar(){
    	
    }

    public void mover(Rectangle limites, boolean colisionR1, boolean colisionR2) {
        TableroJuego tj = TableroJuego.getInstance();
    	x+=dx;
        y+=dy;
        if(colisionR1 == true ){
            dx=-dx;
            x=25;
        }
        if (colisionR2 == true) {
            dx=-dx;
            x=750;
        }
        if(x>limites.getMaxX()){
            dx=-dx;
            tj.puntoR1();
        }
        if (y>limites.getMaxY()-15){
           dy=-dy;
        }
        if (x<-20){
            dx=-dx;
            tj.puntoR2();
        }
        if (y<0){
            dy=-dy;
        }
        tj.mostrarScore();
        
    }
}
