package Modelo;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import Control.ControlJugadores;

public class Raqueta {

	private ControlJugadores cJugadores = ControlJugadores.cJugadores;
	private int x, y;
	private int dy = 1;

	public Raqueta(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Rectangle2D getRaqueta() {
		return new Rectangle2D.Double(x, y, 15, 60);
	}

	public void MoverRaqueta1(Rectangle limites) {
		if (y > limites.getMinY()) {
			if (cJugadores.w) {
				y--;
			}
		}
		if (y < 410) {
			if (cJugadores.s) {
				y++;
			}
		}
	}

	public void MoverRaqueta2(Rectangle limites) {
		if (y > limites.getMinY()) {
			if (cJugadores.arriba) {
				y--;
			}
		}
		if (y < 410) {
			if (cJugadores.abajo) {
				y++;
			}
		}

	}
}
