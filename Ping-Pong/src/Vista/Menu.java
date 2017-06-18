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

public class Menu extends JFrame{
	
	private JPanel panel;
	private Color colorRojo;
	private JLabel fondoParaGif, titulo;
	private JButton jugar, ajustes, salir; 
	public Menu(){
		setResizable(false);
		setTitle("Ping Pong");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 500, 900, 600);
		setLocationRelativeTo(null);
		
		colorRojo= new Color(213, 44, 60);
		panel = new JPanel(null);
		panel.setBackground(Color.BLACK);
		setContentPane(panel);
		
		titulo= new JLabel();
		titulo.setIcon(new javax.swing.ImageIcon("../src/multimedia/Titulo.png"));
		titulo.setBounds(290, -200, 400, 500);
		panel.add(titulo);
		
		salir= new JButton("Salir");
		salir.setBackground(colorRojo);
		salir.setForeground(Color.WHITE);
		salir.setFont(new Font("Roboto", Font.BOLD, 30));
		salir.setBounds(320, 500, 105, 30);
		panel.add(salir);
		
		fondoParaGif = new JLabel();
		fondoParaGif.setIcon(new javax.swing.ImageIcon("../src/mulltimedia/fondoPrincipal.gif"));
		fondoParaGif.setBounds(0,0, 900, 600);
		panel.add(fondoParaGif);
		
		
		
		
	}
}
