package interfaces;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;

public class Comprar extends JPanel {
	public Comprar() {
		setLayout(null);
		
		JList list = new JList();
		list.setBounds(10, 36, 419, 253);
		add(list);
		
		JLabel lblComprar = new JLabel("COMPRAR");
		lblComprar.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		lblComprar.setBounds(10, 11, 117, 23);
		add(lblComprar);
	}
}
