package Modelo;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import Control.ControlJugadores;

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

	public void mover(Rectangle limites, boolean arriba, boolean abajo) {
		
		
		if (y > limites.getMinY()) {
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
