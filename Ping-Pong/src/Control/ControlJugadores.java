package Control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ControlJugadores extends KeyAdapter {

	public static ControlJugadores cJugadores = new ControlJugadores();

	private ControlAgent cAgent;

	public static boolean w, s, arriba, abajo, pausa;

	public ControlJugadores() {

		cAgent = ControlAgent.cAgent;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int id;
		id = e.getKeyCode();
		if (id == KeyEvent.VK_W) {
			w = true;

		}
		if (id == KeyEvent.VK_S) {
			s = true;
		}
		if (id == KeyEvent.VK_UP) {
			arriba = true;
		}
		if (id == KeyEvent.VK_DOWN) {
			abajo = true;
		}
		if (id == KeyEvent.VK_P) {
			pausa = true;
			System.out.println("pausaTruepausaTRuepausaTRuepausaTRuepausaTRuepausaTRuepausaTRue");
			try {
				Thread.sleep(0);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public void keyReleased(KeyEvent e) {
		int id;
		id = e.getKeyCode();
		if (id == KeyEvent.VK_W) {
			w = false;
		}
		if (id == KeyEvent.VK_S) {
			s = false;
		}
		if (id == KeyEvent.VK_UP) {
			arriba = false;
		}
		if (id == KeyEvent.VK_DOWN) {
			abajo = false;
		}
		if (id == KeyEvent.VK_P) {
			pausa = false;
			if (pausa == false) {
				try {
					Thread.sleep(9000);

				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}
	}
}
