package Vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.applet.AudioClip;

public class Menu extends JFrame{
	
	private JPanel panel;
	private Color colorRojo;
	private JLabel fondoParaGif, titulo;
<<<<<<< HEAD
	private JButton jugar, ajustes, salir, soundOn, soundOff, volver;
	private JRadioButton op1, op2, op3, op4;
	private int tipoJuego = 0;
	private AudioClip sonidoFondo;
	public Menu() {
		
		//initComponets
=======
	private JButton jugar, ajustes, salir; 
	
	public Menu(){
	    ImageIcon icon = new ImageIcon("src/multimedia/icono.png");
        setIconImage(icon.getImage());
>>>>>>> d241d63bf06835e2b20f9bd82ca3a8a17afe88da
		setResizable(false);
		setTitle("Ping Pong");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 500, 900, 600);
		setLocationRelativeTo(null);
<<<<<<< HEAD
		sonidoFondo = java.applet.Applet.newAudioClip(getClass().getResourceAsStream("C:/Users/windows/Documents/ping pong/Ping-Pong/src/multimedia/cancionDeFondo.wav"));
		sonidoFondo.play();
		colorRojo = new Color(213, 44, 60);
		panel = new JPanel(null);
		panel.setBackground(Color.BLACK);
		setContentPane(panel);

		titulo = new JLabel();
		titulo.setIcon(
		new javax.swing.ImageIcon("C:/Users/windows/Documents/ping pong/Ping-Pong/src/multimedia/Titulo.png"));
		titulo.setBounds(300, -200, 400, 500);
=======
		
		colorRojo= new Color(213, 44, 60);
		panel = new JPanel(null);
		panel.setBackground(Color.BLACK);
		setContentPane(panel);
		
		titulo= new JLabel();
		titulo.setIcon(new javax.swing.ImageIcon("src/multimedia/Titulo.png"));
		titulo.setBounds(290, -200, 400, 500);
>>>>>>> d241d63bf06835e2b20f9bd82ca3a8a17afe88da
		panel.add(titulo);
		
		salir= new JButton("Salir");
		salir.setBackground(colorRojo);
		salir.setForeground(Color.WHITE);
		salir.setFont(new Font("Roboto", Font.BOLD, 25));
		salir.setBounds(320, 500, 105, 30);
		panel.add(salir);
	
		jugar= new JButton("Jugar");
		jugar.setBackground(colorRojo);
		jugar.setForeground(Color.WHITE);
		jugar.setFont(new Font("Roboto", Font.BOLD, 25));
		jugar.setBounds(450, 500, 105, 30);
		panel.add(jugar);
		
		fondoParaGif = new JLabel();
		fondoParaGif.setIcon(new javax.swing.ImageIcon("src/multimedia/fondoPrincipal.gif"));
		fondoParaGif.setBounds(0,0, 900, 600);
		panel.add(fondoParaGif);
<<<<<<< HEAD

		jugar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// VentanaPrincipal vp = new VentanaPrincipal();
				// vp.setVisible(true );

			}
		});

		ajustes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jugar.setVisible(false);
				ajustes.setBounds(370, 150, 150, 39);
				op1.setVisible(true);
				op2.setVisible(true);
				op3.setVisible(true);
				op4.setVisible(true);
				soundOff.setVisible(true);
				soundOn.setVisible(true);
				volver.setVisible(true);
				salir.setBounds(390, 510, 105, 35);
			}
		});
		op1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (op1.isSelected() == true) {
					op1.setSelected(true);
					op2.setSelected(false);
					op3.setSelected(false);
					op4.setSelected(false);
					tipoJuego = 1;
					
				}

			}
		});

		op2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (op2.isSelected() == true) {
					op2.setSelected(true);
					op1.setSelected(false);
					op3.setSelected(false);
					op4.setSelected(false);
					tipoJuego = 2;
				}
			}
		});

		op3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (op3.isSelected() == true) {
					op3.setSelected(true);
					op1.setSelected(false);
					op2.setSelected(false);
					op4.setSelected(false);
					tipoJuego = 3;
				}
			}
		});

		op4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (op4.isSelected() == true) {
					op4.setSelected(true);
					op1.setSelected(false);
					op2.setSelected(false);
					op3.setSelected(false);
					tipoJuego = 4;
				}
			}
		});

		soundOn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
			}
		});
		
		volver.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jugar.setVisible(true);
				ajustes.setBounds(370, 300, 150, 39);
				op1.setVisible(false);
				op2.setVisible(false);
				op3.setVisible(false);
				op4.setVisible(false);
				soundOff.setVisible(false);
				soundOn.setVisible(false);
				volver.setVisible(false);
				salir.setBounds(390, 400, 105, 35);
			}
		});

		salir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
	}

=======
	}
	
>>>>>>> d241d63bf06835e2b20f9bd82ca3a8a17afe88da
}
