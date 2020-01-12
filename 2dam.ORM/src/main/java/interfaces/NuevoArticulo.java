package interfaces;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class NuevoArticulo extends JPanel{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblValido;
	
	public NuevoArticulo() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(99, 70, 46, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Precio");
		lblNewLabel_1.setBounds(99, 124, 46, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Descripcion");
		lblNewLabel_2.setBounds(99, 174, 69, 14);
		add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(245, 67, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1.setBounds(245, 121, 86, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(214, 163, 139, 60);
		add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnIntroducir = new JButton("Introducir Articulo");
		btnIntroducir.setBounds(242, 234, 127, 23);
		add(btnIntroducir);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(91, 234, 89, 23);
		add(btnSalir);
		
		JLabel lblNewLabel_3 = new JLabel("INSERTAR ARTICULO");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(140, 11, 201, 37);
		add(lblNewLabel_3);
		
		 lblValido = new JLabel("");
		lblValido.setForeground(Color.RED);
		lblValido.setBounds(341, 124, 99, 14);
		add(lblValido);
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				try {
					float precio=Integer.parseInt(textField_1.getText());
					lblValido.setText("");
				}catch(NumberFormatException nfe) {
				lblValido.setText("Numero invalido");	
				}
			}
		});
		
	}
}
