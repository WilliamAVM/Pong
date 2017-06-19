package Modelo;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import Control.ControlJugadores;
import Vista.TableroJuego;

public class RaquetaAgente {
	
	private Agent agent;
	private boolean arriba, abajo;
	public int x, y,cx,cy,width,height;
	private int dy = 1;

	public RaquetaAgente(int x, int y) {
		
		agent = new Agent();
		this.x = x;
		this.y = y;
		width = 15;
		height = 60;
		
	}
	
	private void calcularCentros(){
		cx = x + width/2;
		cy = y +height/2;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Rectangle2D getRaqueta() {
		return new Rectangle2D.Double(x, y, width, height);
	}

	public void mover() {
		TableroJuego tj = TableroJuego.getInstance();
		calcularCentros();
		int dxx = Math.abs(tj.pelota.cx-cx);
    	int dyy = -1*(tj.pelota.cy-cy);
    	int dxp = (dxx*100)/tj.width;
    	int dyp = (dyy*100)/tj.height;
    	//asignando    	
    	agent.input(dxp, dyp);
    	arriba = false;
    	abajo = false;
    	//se mueve arriba o abajo  	
    	if(agent.output()>=1){
    		arriba= true;
    	}
    	else{
    		abajo = true;
    	}
		if (y > tj.getBounds().getMinY()) {
			if (arriba) {
				y-=dy;
			}
		}
		if (y < 410) {
			if (abajo) {
				y+=dy;
			}
		}

	}

}
