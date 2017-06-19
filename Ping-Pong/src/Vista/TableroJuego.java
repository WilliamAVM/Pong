package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.w3c.dom.events.EventException;

import Control.ControlAgent;
import Modelo.Agent;
import Modelo.Pelota;
import Modelo.Raqueta;
import Modelo.RaquetaAgente;
import Modelo.RaquetaPadre;

public class TableroJuego extends JPanel {
	// singleton
	private static final TableroJuego INSTANCE = new TableroJuego();
	public Raqueta e;
	public Pelota pelota;
	public static boolean p;
	public RaquetaPadre r1;
	public RaquetaPadre r2;
	public Clip sonidoChoque;
	public String ruta = "/multimedia/";
	public int height = 500;
	public int width = 800;
	private int ptj1, ptj2, ptjmax;
	public JLabel puntaje1, puntaje2, jugador1, jugador2;
	private int tipoJuego;
	private Color colorRojo = new Color(213, 44, 60);
	
	private TableroJuego() {
		// inicializando elementos
		pelota = new Pelota(400, 200);
		init();

	}

	public void initRaquetas(int tipoJuego) {

		switch (tipoJuego) {
		case 1:
			r1 = new Raqueta(10, 200);
			r2 = new Raqueta(770, 200);
			break;

		case 2:
			r1 = new Raqueta(10, 200);
			r2 = new RaquetaAgente(770, 200);
			break;

		case 3:
			r1 = new RaquetaAgente(10, 200);
			r2 = new Raqueta(770, 200);
			break;

		case 4:
			r1 = new RaquetaAgente(10, 200);
			r2 = new RaquetaAgente(770, 200);
			break;
		}

	}

	private void init() {
		// puntajes
		ptj1 = 0;
		ptj2 = 0;
		ptjmax = 2;

		setBounds(0, 0, width, height);
		setBackground(Color.DARK_GRAY);

		puntaje1 = new JLabel("Puntaje");
		puntaje1.setForeground(Color.WHITE);
		puntaje1.setFont(new Font("Roboto", Font.BOLD, 18));
		add(puntaje1);

		// score
		jugador1 = new JLabel("" + ptj1);
		jugador1.setFont(new Font("Roboto", Font.BOLD, 18));
		jugador1.setForeground(Color.WHITE);
		add(jugador1);

		jugador2 = new JLabel("" + ptj2);
		jugador2.setFont(new Font("Roboto", Font.BOLD, 18));
		jugador2.setForeground(Color.WHITE);
		add(jugador2);
	}

	public static TableroJuego getInstance() {
		return INSTANCE;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.BLACK);
		Dibujar(g2);
		Actualizar();
	}

	public void Dibujar(Graphics2D g) {
		g.drawLine(width / 2, height, width / 2, 0);
		g.fill(pelota.getPelota());
		Color colorR1 = colorRojo;
		Color colorR2 = colorRojo;
		if (r1 instanceof Raqueta) {
			colorR1 = Color.green;
		}

		if (r2 instanceof Raqueta) {
			colorR2 = Color.green;
		}
		g.setColor(colorR1);
		g.fill(r1.getRaqueta());
		g.setColor(colorR2);
		g.fill(r2.getRaqueta());
	}

	public void Actualizar() {
		pelota.mover(getBounds(), coolision(r1.getRaqueta()), coolision(r2.getRaqueta()));
		r1.mover();
		r2.mover();
	}

	public void Iterarjuego() throws InterruptedException {
		while (true) {
			repaint();
			try {
				Thread.sleep(6);
			} catch (InterruptedException ex) {
				Logger.getLogger(TableroJuego.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	private boolean coolision(Rectangle2D r) {
		return pelota.getPelota().intersects(r);
	}

	public void mostrarScore() {
		if (ptj1 == ptjmax && ptj1 > ptj2) {
			puntaje1.setText("GANADOR JUGADOR 1");
		}
		if (ptj2 == ptjmax && ptj1 < ptj2) {
			puntaje1.setText("GANADOR JUGADOR 2");
		}
		jugador1.setText("" + ptj1);
		jugador2.setText("" + ptj2);
	}

	public void puntoR1() {
		ptj1++;
	}

	public void puntoR2() {
		ptj2++;
	}

	public void sonido(String archivo) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		try {
			sonidoChoque = AudioSystem.getClip();
			sonidoChoque.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream(ruta + archivo + ".wav")));
			sonidoChoque.start();
		} catch (EventException e) {
			// TODO: handle exception
		}
	}
	
}
