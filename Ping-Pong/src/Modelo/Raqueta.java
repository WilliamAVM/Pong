package Modelo;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import Control.ControlJugadores;
import Vista.TableroJuego;

public class Raqueta {

	private ControlJugadores cJugadores = ControlJugadores.cJugadores;
	public int x, y;
	private int dy = 1;

	public Raqueta(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Rectangle2D getRaqueta() {
		return new Rectangle2D.Double(x, y, 15, 60);
	}

	public void mover(){
		TableroJuego tj = TableroJuego.getInstance();
		if((tj.width/2)<x){
			MoverRaqueta2(tj.getBounds());
		}else{
			MoverRaqueta1(tj.getBounds());
		}
	}
	
	
	private void MoverRaqueta1(Rectangle limites) {
		if (y > limites.getMinY()) {
			if (cJugadores.w) {
				y-=dy;
			}
		}
		if (y < 410) {
			if (cJugadores.s) {
				y+=dy;
			}
		}
	}

	private void MoverRaqueta2(Rectangle limites) {
		if (y > limites.getMinY()) {
			if (cJugadores.arriba) {
				y-=dy;
			}
		}
		if (y < 410) {
			if (cJugadores.abajo) {
				y+=dy;
			}
		}

	}
}
