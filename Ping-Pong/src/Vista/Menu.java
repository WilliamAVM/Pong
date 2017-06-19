package Vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import org.w3c.dom.events.EventException;

public class Menu extends JFrame {
	public Clip clipFondo;
	public Clip clipBoton;
	public String ruta = "/multimedia/";
	private JPanel panel;
	private Color colorRojo;
	private JLabel fondoParaGif, titulo;
	private JButton jugar, ajustes, salir, soundOn, soundOff, volver;
	private JRadioButton op1, op2, op3, op4;
	private int tipoJuego = 1;

	public Menu() {
		setResizable(false);
		setTitle("Ping Pong");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 500, 900, 600);
		setLocationRelativeTo(null);
		colorRojo = new Color(213, 44, 60);
		panel = new JPanel(null);
		panel.setBackground(Color.BLACK);
		setContentPane(panel);

		try {
			sonido("Ping_Pong", 1);
		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		titulo = new JLabel();
		titulo.setIcon(new javax.swing.ImageIcon("src/multimedia/Titulo.png"));
		titulo.setBounds(300, -200, 400, 500);
		panel.add(titulo);

		jugar = new JButton("Jugar");
		jugar.setBackground(colorRojo);
		jugar.setForeground(Color.WHITE);
		jugar.setFont(new Font("Roboto", Font.BOLD, 30));
		jugar.setBounds(370, 200, 150, 39);
		panel.add(jugar);

		ajustes = new JButton("Ajustes");
		ajustes.setBackground(colorRojo);
		ajustes.setForeground(Color.WHITE);
		ajustes.setFont(new Font("Roboto", Font.BOLD, 30));
		ajustes.setBounds(370, 300, 150, 39);
		panel.add(ajustes);

		ActionListener accionJuego= new ActionListener() {
			int tipoJ =0;
			@Override
			public void actionPerformed(ActionEvent e) {
				switch(e.getActionCommand()){
				case "Human vs Human": tipoJ=1;break;
				case "Human vs Agent": tipoJ=2;break;
				case "Agent vs Human": tipoJ=3;break;
				case "Agent vs Agent": tipoJ=4;break;
				}
				tipoJuego=tipoJ;
			}
		};
		op1 = new JRadioButton("Human vs Human");
		op1.setActionCommand("Human vs Human");
		op1.setBackground(colorRojo);
		op1.setForeground(Color.WHITE);
		op1.setFont(new Font("Roboto", Font.BOLD, 30));
		op1.setBounds(310, 210, 280, 45);
		op1.setVisible(false);
		
		panel.add(op1);

		op2 = new JRadioButton("Human vs Agent");
		op2.setActionCommand("Human vs Agent");
		op2.setBackground(colorRojo);
		op2.setForeground(Color.WHITE);
		op2.setFont(new Font("Roboto", Font.BOLD, 30));
		op2.setBounds(310, 270, 270, 45);
		op2.setVisible(false);
		panel.add(op2);


		op3 = new JRadioButton("Agent vs Human");
		op3.setActionCommand("Agent vs Human");

		op3.setBackground(colorRojo);
		op3.setForeground(Color.WHITE);
		op3.setFont(new Font("Roboto", Font.BOLD, 30));
		op3.setBounds(310, 330, 270, 45);
		op3.setVisible(false);
		panel.add(op3);

		op4 = new JRadioButton("Agent vs Agent");
		op4.setActionCommand("Agent vs Agent");

		op4.setBackground(colorRojo);
		op4.setForeground(Color.WHITE);
		op4.setFont(new Font("Roboto", Font.BOLD, 30));
		op4.setBounds(320, 390, 250, 45);
		op4.setVisible(false);
		panel.add(op4);
		
		op1.addActionListener(accionJuego);
		op2.addActionListener(accionJuego);
		op3.addActionListener(accionJuego);
		op4.addActionListener(accionJuego);
		
		soundOn = new JButton();
		soundOn.setIcon(new ImageIcon("src/multimedia/volume_up.png"));
		soundOn.setBackground(colorRojo);
		soundOn.setForeground(Color.WHITE);
		soundOn.setFont(new Font("Roboto", Font.BOLD, 30));
		soundOn.setBounds(350, 450, 45, 45);
		soundOn.setVisible(false);
		panel.add(soundOn);

		soundOff = new JButton();
		soundOff.setIcon(new ImageIcon("src/multimedia/volume_off.png"));
		soundOff.setBackground(colorRojo);
		soundOff.setForeground(Color.WHITE);
		soundOff.setFont(new Font("Roboto", Font.BOLD, 30));
		soundOff.setBounds(500, 450, 45, 45);
		soundOff.setVisible(false);
		panel.add(soundOff);

		volver = new JButton();
		volver.setIcon(new ImageIcon("src/multimedia/arrow_back.png"));
		volver.setBackground(colorRojo);
		volver.setBounds(50, 500, 50, 50);
		volver.setVisible(false);
		panel.add(volver);

		salir = new JButton("Salir");
		salir.setBackground(colorRojo);
		salir.setForeground(Color.WHITE);
		salir.setFont(new Font("Roboto", Font.BOLD, 30));
		salir.setBounds(390, 400, 105, 35);
		panel.add(salir);

		fondoParaGif = new JLabel();
		fondoParaGif.setIcon(new javax.swing.ImageIcon("src/multimedia/fondoPrincipal.gif"));
		fondoParaGif.setBounds(0, -15, 900, 600);
		panel.add(fondoParaGif);

		jugar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				dispose();
				VentanaPrincipal vp = new VentanaPrincipal(tipoJuego);
				 vp.setVisible(true );
				try {
					sonido("ping_pong_8bit_beeep", 2);
				} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}


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
				// sonido al precionar boton
				try {
					sonido("ping_pong_8bit_beeep", 2);
				} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
					// sonido al precionar boton
					try {
						sonido("ping_pong_8bit_beeep", 2);
					} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
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
					// sonido al precionar boton
					try {
						sonido("ping_pong_8bit_beeep", 2);
					} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
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
					// sonido al precionar boton
					try {
						sonido("ping_pong_8bit_beeep", 2);
					} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
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
					// sonido al precionar boton
					try {
						sonido("ping_pong_8bit_beeep", 2);
					} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});

		soundOn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				// sonido al precionar boton
				try {
					sonido("ping_pong_8bit_beeep", 2);
					sonido("Ping_Pong", 1);
				} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		soundOff.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				// sonido al precionar boton
				
				clipFondo.stop();
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
				// sonido al precionar boton
				try {
					sonido("ping_pong_8bit_beeep", 2);
				} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		salir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
				// sonido al precionar boton
				try {
					sonido("ping_pong_8bit_beeep", 2);
				} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}

	public void sonido(String archivo, int n)
			throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		if (n == 1) {
			try {
				clipFondo = AudioSystem.getClip();
				clipFondo.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream(ruta + archivo + ".wav")));
				clipFondo.loop(20);
			} catch (EventException e) {
				// TODO: handle exception
			}
		} else {
			if (n == 2) {
				try {
					clipBoton = AudioSystem.getClip();
					clipBoton.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream(ruta + archivo + ".wav")));
					clipBoton.start();
				} catch (EventException e) {
					// TODO: handle exception
				}
			}
		 else {
			if (n == 3) {
				try {
					clipFondo = AudioSystem.getClip();
					clipFondo.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream(ruta + archivo + ".wav")));
					clipFondo.stop();
				} catch (EventException e) {
					// TODO: handle exception
				}
			}
		}

		}
	}
}
	



