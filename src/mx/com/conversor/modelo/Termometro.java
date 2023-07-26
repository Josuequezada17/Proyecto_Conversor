package mx.com.conversor.modelo;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.event.*;

/**
 * Creara una representacion grafica de un termometro
 * 
 * @serial version 1.0
 * @author Josue Quezada
 * 
 */

public class Termometro extends DisenoGlobal implements ChangeListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel panelTermometro = new JPanel();
	private JPanel panelGrados = new JPanel();
	private JPanel panelBoton = new JPanel();

	private JLabel cLabel = new JLabel();
	private JLabel fLabel = new JLabel();
	private JLabel kLabel = new JLabel();

	private JSlider slider = new JSlider(0, 100, 50);// Minimo, Maximo, Inicio

	private JButton boton = new JButton();

	/**
	 * Constructor de termometro Con diseño heredado
	 * 
	 * @param sizeX  - Medida en anchura de la pagina
	 * @param sizeY  - Medida en altura de la pagina
	 * @param color  - Color del fondo del frame
	 * @param titulo - Titulo del frame
	 */
	public Termometro(int sizeX, int sizeY, Color color, String titulo) {

		super(sizeX, sizeY, color, titulo);
		this.setLayout(new FlowLayout());

		this.panelTermometro.setPreferredSize(new Dimension(110, 400));
		this.panelTermometro.setBackground(Color.LIGHT_GRAY);

		this.panelGrados.setPreferredSize(new Dimension(420, 50));
		this.panelGrados.setBackground(Color.ORANGE);

		this.panelBoton.setBackground(Color.GRAY);

		this.slider.setFont(new Font("Open Sans", Font.ITALIC, 15));
		this.cLabel.setFont(new Font("Century Gothic", Font.BOLD, 25));
		this.fLabel.setFont(new Font("Century Gothic", Font.BOLD, 25));
		this.kLabel.setFont(new Font("Century Gothic", Font.BOLD, 25));

		this.slider.setPreferredSize(new Dimension(100, 390));
		this.slider.setPaintTicks(true);// Para habilitar los intervalso de valores

		this.slider.setMinorTickSpacing(1);// Espaciamiento entre cada valor pequeños
		this.slider.setPaintTrack(true);// Habilitar espaciamientos grandes

		this.slider.setMajorTickSpacing(10); // Espaciamientos mas grandes
		this.slider.setPaintLabels(true);// Agrega numeros

		this.slider.setSnapToTicks(true); // Fijar las marcas
		this.slider.setForeground(Color.BLACK);

		this.slider.setOrientation(SwingConstants.VERTICAL); // Orientacion del slider
		this.slider.addChangeListener(this);
		this.slider.setBackground(Color.ORANGE);

		this.cLabel.setText("°C = " + this.slider.getValue());
		this.fLabel.setText(" °F = " + ((this.slider.getValue() * 9 / 5) + 32));
		this.kLabel.setText(" °K = " + (this.slider.getValue() + 273));

		this.boton.setText("Menu");
		this.boton.setForeground(Color.BLACK);
		this.boton.setBackground(Color.LIGHT_GRAY);
		this.boton.addActionListener(this);

		this.panelTermometro.add(this.slider);
		this.panelGrados.add(this.cLabel);
		this.panelGrados.add(this.fLabel);
		this.panelGrados.add(this.kLabel);
		this.panelBoton.add(this.boton);

		this.add(this.panelTermometro);
		this.add(this.panelGrados);
		this.add(this.panelBoton);

		this.setVisible(true);
	}

	/**
	 * Este metodo hace que cambien las temperaturas
	 */
	@Override
	public void stateChanged(ChangeEvent e) {
		this.cLabel.setText("°C = " + this.slider.getValue());
		this.fLabel.setText("°F = " + ((this.slider.getValue() * 9 / 5) + 32));
		this.kLabel.setText("°K = " + (this.slider.getValue() + 273));
	}

	/**
	 * Este metodo se encarga de reconocer cuando se hace click en el boton de menu
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.dispose();
		if (e.getSource() == this.boton) {
			new Conversor(520, 600, Color.LIGHT_GRAY, "Menu principal");
		}
	}

}
