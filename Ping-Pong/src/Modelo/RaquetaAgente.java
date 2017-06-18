package Modelo;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import Control.ControlJugadores;
import Vista.TableroJuego;

public class RaquetaAgente {
	
	private Agent agent;
	private boolean arriba, abajo;
	public int x, y;
	private int dy = 1;

	public RaquetaAgente(int x, int y) {
		
		agent = new Agent();
		this.x = x;
		this.y = y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Rectangle2D getRaqueta() {
		return new Rectangle2D.Double(x, y, 15, 60);
	}

	public void mover(TableroJuego tj) {
		int dx = Math.abs(tj.pelota.x-x);
    	int dy = -1*(tj.pelota.y-y);
    	int dxp = (dx*100)/tj.width;
    	int dyp = (dy*100)/tj.height;
    	//asignando    	
    	agent.input(dxp, dyp);
    	arriba = false;
    	abajo = false;
    	//se mueve arriba o abajo  	
    	if(agent.output()>0){
    		arriba= true;
    	}
    	else{
    		abajo = true;
    	}
		if (y > tj.getBounds().getMinY()) {
			if (arriba) {
				y--;
			}
		}
		if (y < 410) {
			if (abajo) {
				y++;
			}
		}

	}

}
