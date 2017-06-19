package Modelo;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import Vista.TableroJuego;

public class Pelota {

    public static Pelota pelota= new Pelota();
	
	public int x, y,cx,cy,r=20;
    private int dx=1, dy=1;
    private int dmax = 2;
    private int velini = 1;
    private int acel = 1;
    private double t = 0; 
    private double dt = 0.001;
        
    //aceleracion
    private int tmax = 30;
    private int dxini = 1;
    private int dyini = 1;
    
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
<<<<<<< HEAD
     
    /*
    private void acelerar(){
    	if(t<tmax){
    		t+=dt;
    		//if(Math.abs(dy)<dmax)
    			
    	}
    }
    */
    
    
=======
        
>>>>>>> branch 'master' of https://github.com/williamVMA/Pong.git
    private void acelerar(){
    	t+=dt;
    	if(Math.abs(dy)<dmax){
    		if(dy>0)
    			dy = (int) (velini*t+0.5*acel*t*t);
    		else
    			dy = (-1)*(int) (velini*t+0.5*acel*t*t);
    		if(dx>0)
    			dx = (int) (velini*t+0.5*acel*t*t);
    		else
    			dx = (-1)*(int) (velini*t+0.5*acel*t*t);
    		System.out.println("funciona");
    	}
    	System.out.println(dx);
    	
    }

    public void mover(Rectangle limites, boolean colisionR1, boolean colisionR2) {
    	acelerar();
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
