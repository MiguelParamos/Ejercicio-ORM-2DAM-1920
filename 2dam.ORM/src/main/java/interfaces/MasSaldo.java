package interfaces;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class MasSaldo extends JPanel{
	private JTextField AddSaldoText;
	public MasSaldo() {
		setBackground(new Color(65, 105, 225));		
		setLayout(null);	
		JLabel LabelSueldo = new JLabel("A\u00F1adir Saldo :");
		LabelSueldo.setForeground(new Color(255, 165, 0));
		LabelSueldo.setHorizontalAlignment(SwingConstants.CENTER);
		LabelSueldo.setBounds(78, 84, 78, 14);
		add(LabelSueldo);		
		JButton AtrasBoton = new JButton("Atras");
		AtrasBoton.setBackground(new Color(139, 0, 0));
		AtrasBoton.setForeground(new Color(178, 34, 34));
		AtrasBoton.setBounds(10, 326, 89, 23);
		add(AtrasBoton);		
		JButton AddSaldo = new JButton("A\u00F1adir");
		AddSaldo.setForeground(new Color(50, 205, 50));
		AddSaldo.setBackground(new Color(0, 128, 0));
		AddSaldo.setBounds(166, 133, 89, 23);
		add(AddSaldo);		
		AddSaldoText = new JTextField();
		AddSaldoText.setBounds(166, 81, 96, 20);		
		add(AddSaldoText);		
		AddSaldoText.setColumns(10);
	}
}
