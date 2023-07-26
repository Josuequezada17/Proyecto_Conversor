package mx.com.conversor.test;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestComboBox {

	public static void main(String[] args) {

		    JFrame frame = new JFrame();
		        JPanel panel = new JPanel();
		        JComboBox<String> comboBox = new JComboBox<String>(new String[] { "Opción 1", "Opción 2", "Opción 3" });
		        comboBox.setEditable(true);
		        comboBox.setSelectedIndex(0);
		        comboBox.setEnabled(false);
		        panel.add(comboBox);
		        frame.add(panel);
		        frame.pack();
		        frame.setVisible(true);

		    
		}

}
