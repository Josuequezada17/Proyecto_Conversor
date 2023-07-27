package mx.com.conversor.modelo;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public abstract class  DisenoGlobal extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Imagen predeterminada de las ventanas
	 * */
	private ImageIcon icon = new ImageIcon("alura_logo.png");
	
	/**
	 * Constructor de diseño de pagina estandar
	 * @param sizeX
	 * @param sizeY
	 * @param color
	 * @param titulo
	 * */
	public DisenoGlobal(int sizeX, int sizeY, Color color, String titulo) {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(sizeX, sizeY); // 520 ,420
		this.setTitle(titulo);
		this.setIconImage(this.icon.getImage());
		this.setLocationRelativeTo(null); 
		this.getContentPane().setBackground(color);
	}
	
	
}
