package mx.com.conversor.modelo;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * Creara una representacion grafica de un menu en el cual se puede escoger
 * Divisas, termometro o salir
 * 
 * @serial version 1.0
 * @author Josue Quezada
 * 
 * */

public class Conversor extends DisenoGlobal implements ActionListener {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ImageIcon divisasIcon = new ImageIcon("signo-de-dolar.png");
	private ImageIcon TempertIcon = new ImageIcon("calor.png");
	private ImageIcon SalirIcon = new ImageIcon("cerrar-sesion.png");
	
	private JRadioButton botonDivisas = new JRadioButton("Divisas");
	private JRadioButton botonTemperatura = new JRadioButton("Temperatura");
	private JRadioButton botonEnd = new JRadioButton("Salir");
	
	private ButtonGroup group = new ButtonGroup();

	/**
	 * Constructor con diseño heredado de DiseñoGlobal
	 @param sizeX - Medida en anchura de la pagina
	 * @param sizeY - Medida en altura de la pagina
	 * @param color - Color del fondo del frame
	 * @param titulo - Titulo del frame
	 * */
	public Conversor(int sizeX, int sizeY, Color color, String titulo) {

		super(sizeX, sizeY, color, titulo);
		this.setLayout(new FlowLayout(100, 100, 70));


		this.botonDivisas.setFocusable(false);
		this.botonTemperatura.setFocusable(false);
		this.botonEnd.setFocusable(false);

		this.botonDivisas.setBackground(Color.LIGHT_GRAY);
		this.botonTemperatura.setBackground(Color.LIGHT_GRAY);
		this.botonEnd.setBackground(Color.LIGHT_GRAY);
		
		this.botonDivisas.addActionListener(this);
		this.botonTemperatura.addActionListener(this);
		this.botonEnd.addActionListener(this);

		this.botonDivisas.setFont(new Font("Century Gothic", Font.BOLD, 30));
		this.botonTemperatura.setFont(new Font("Century Gothic", Font.BOLD, 30));
		this.botonEnd.setFont(new Font("Century Gothic", Font.BOLD, 30));

		this.botonDivisas.setIcon(divisasIcon);
		this.botonTemperatura.setIcon(TempertIcon);
		this.botonEnd.setIcon(SalirIcon);

		this.group.add(botonDivisas);
		this.group.add(botonTemperatura);
		this.group.add(botonEnd);
		
		this.add(botonDivisas);
		this.add(botonTemperatura);
		this.add(botonEnd);
		
		this.pack();
		this.setVisible(true);
	}

	/**
	 * Se encarga del manejo de los botones, para saber
	 * en cual de ellos se hace click
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.dispose();
		if (e.getSource() == this.botonDivisas) {
			new Divisas(520,320,Color.GRAY, "Divisas");

		} else if (e.getSource() == this.botonTemperatura) {
			new Termometro(520, 560, Color.GRAY, "Termometro ");

		} else if (e.getSource() == this.botonEnd) {
			JOptionPane.showMessageDialog(null, "Programa finalizado", "Conversor", JOptionPane.WARNING_MESSAGE);
			System.exit(0);
		}
	}


}
