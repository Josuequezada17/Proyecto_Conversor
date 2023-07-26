package mx.com.conversor.modelo;

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

import javax.swing.*;

/**
 * Creara una representacion grafica de una calculadora de divisas
 * 
 * @serial version 1.0
 * @author Josue Quezada
 * 
 */

public class Divisas extends DisenoGlobal implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String[] divisas = { "MXN $ a USD $", "MXN $ a EUR €", "MXN $ a GBP £", "MXN $ a JPY ¥", "MXN $ a KWR ₩",
			"USD $ a MXN $", "EUR € a MXN $", "GBP £ a MXN $", "JPY ¥ a MXN $", "KWR ₩ a MXN $" };

	private JComboBox<String> comboBox = new JComboBox<String>(this.divisas);

	private ImageIcon icon = new ImageIcon("alura_logo.png");

	private JPanel panelTitulo = new JPanel(); // Panel para el titulo
	private JPanel panelDivisas = new JPanel(); // Panel de seleccion de divisas
	private JPanel panelConversion = new JPanel(); // Panel de conversion

	private JLabel labelTitulo = new JLabel(); // Label para el titulo

	private JTextField textField = new JTextField(); // Crea un cuadro de texto

	private JButton botonCanje = new JButton(); // Crea boton para aceptar y canjear

	/**
	 * Constructor de divisas, con diseño heredado
	 * 
	 * @param sizeX           - Medida en anchura de la pagina
	 * @param sizeY           - Medida en altura de la pagina
	 * @param backGroundColor - Color del fondo del frame
	 * @param titulo          - Titulo del frame
	 */
	public Divisas(int sizeX, int sizeY, Color backGroundColor, String titulo) {
		super(sizeX, sizeY, backGroundColor, titulo);
		this.setLayout(new FlowLayout());

		this.comboBox.setFont(new Font("Open Sans", Font.BOLD, 15));
		this.comboBox.addActionListener(this);
		this.comboBox.setForeground(Color.BLACK);
		this.comboBox.setBackground(Color.WHITE);

		this.botonCanje.addActionListener(this);
		this.botonCanje.setText("ACEPTAR");
		this.botonCanje.setBackground(Color.LIGHT_GRAY);

		this.labelTitulo.setText("Divisas");
		this.labelTitulo.setFont(new Font("Century Gothic", Font.BOLD, 25));
		this.labelTitulo.setHorizontalAlignment(JLabel.CENTER);
		this.labelTitulo.setVerticalAlignment(JLabel.CENTER);

		this.panelTitulo.setPreferredSize(new Dimension(420, 50));
		this.panelTitulo.setBackground(Color.ORANGE);
		this.panelTitulo.setLayout(new FlowLayout());

		this.panelDivisas.setPreferredSize(new Dimension(420, 150));
		this.panelDivisas.setBackground(Color.BLUE);
		this.panelDivisas.setLayout(new FlowLayout());

		this.panelConversion.setPreferredSize(new Dimension(420, 50));
		this.panelConversion.setBackground(Color.GRAY);
		this.panelConversion.setLayout(new FlowLayout());
		this.panelConversion.setVisible(false);

		this.textField.setPreferredSize(new Dimension(250, 35));
		this.textField.setFont(new Font("Century Gothic", Font.BOLD, 20));
		this.textField.setForeground(Color.BLACK);
		this.textField.setBackground(Color.WHITE);
		this.textField.setCaretColor(Color.BLACK);

		this.panelDivisas.add(comboBox);
		this.panelTitulo.add(labelTitulo);
		this.panelConversion.add(textField);
		this.panelConversion.add(botonCanje);

		this.add(panelTitulo);
		this.add(panelDivisas);
		this.add(panelConversion);

		this.setVisible(true);
	}

	/**
	 * Se encarga del manejo de los botones, para saber en cual de ellos se hace
	 * click
	 *
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == this.comboBox) {
			this.comboBox.setEnabled(false);
			this.panelConversion.setVisible(true);

		}
		if (e.getSource() == this.botonCanje) {
			try {
				Integer selectedItem = this.comboBox.getSelectedIndex();

				double amount = Double.parseDouble(this.textField.getText());
				double result = convertCurrency(selectedItem, amount);

				DecimalFormat decimalFormat = new DecimalFormat("#.##");
				String formattedResult = decimalFormat.format(result);
				double finalResult = Double.parseDouble(formattedResult);

				JOptionPane.showMessageDialog(null,
						this.comboBox.getSelectedItem() + "\n" + "Resultado: " + finalResult, "Conversor",
						JOptionPane.INFORMATION_MESSAGE);

			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Ingresa un valor numérico válido", "Error",
						JOptionPane.ERROR_MESSAGE);

			} finally {
				this.dispose();
				int opc = JOptionPane.showConfirmDialog(null, "¿Desea continuar?", "Conversor",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);

				switch (opc) {
				case 0:
					new Divisas(520, 320, Color.GRAY, "Divisas");
					break;
				case 1:
					JOptionPane.showMessageDialog(null, "Programa finalizado", "Conversor",
							JOptionPane.INFORMATION_MESSAGE, icon);
					break;
				case 2:
					new Conversor(520, 600, Color.LIGHT_GRAY, "Menu principal");
					break;

				default:
					JOptionPane.showMessageDialog(null, "Finalizando programa", "Conversor",
							JOptionPane.INFORMATION_MESSAGE, icon);
					break;
				}

			}
		}

	}

	/**
	 * Se encarga de realizar las conversiones de las divisas dependiendo de la
	 * opcion elegida por el usuario
	 * 
	 * @param selectedItem
	 * @param cantidad
	 * @return
	 */

	private double convertCurrency(Integer selectedItem, double cantidad) {

		switch (selectedItem) {
		case 0:
			cantidad *= 0.059;
			break;
		case 1:
			cantidad *= 0.0534;
			break;
		case 2:
			cantidad *= 0.046;
			break;
		case 3:
			cantidad *= 8.35;
			break;
		case 4:
			cantidad *= 75.70;
			break;
		case 5:
			cantidad *= 16.95;
			break;
		case 6:
			cantidad *= 18.86;
			break;
		case 7:
			cantidad *= 21.78;
			break;
		case 8:
			cantidad *= 0.12;
			break;
		case 9:
			cantidad *= 0.013;
			break;
		default:
			break;
		}

		return cantidad;
	}

}
