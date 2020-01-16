package interfaces;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import clases.Articulo;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NuevoArticulo extends JPanel{
	private JTextField textFieldNombre;
	private JTextField textField_1;
	private JTextField textFieldPrecio;
	private JTextField textFieldDescripcion;
	private JLabel lblValido;
	
	public NuevoArticulo() {
		setLayout(null);
		setBackground(new Color(91, 157, 195));
		
		
		JLabel lblNewLabelNombre = new JLabel("Nombre");
		lblNewLabelNombre.setBounds(99, 70, 46, 14);
		add(lblNewLabelNombre);
		
		JLabel lblNewLabelPrecio = new JLabel("Precio");
		lblNewLabelPrecio.setBounds(99, 124, 46, 14);
		add(lblNewLabelPrecio);
		
		JLabel lblNewLabelDescripcion = new JLabel("Descripcion");
		lblNewLabelDescripcion.setBounds(99, 174, 69, 14);
		add(lblNewLabelDescripcion);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(245, 67, 86, 20);
		add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldPrecio = new JTextField();
		textFieldPrecio.setBounds(245, 121, 86, 20);
		add(textFieldPrecio);
		textFieldPrecio.setColumns(10);
		
		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setBounds(214, 163, 139, 60);
		add(textFieldDescripcion);
		textFieldDescripcion.setColumns(10);
		
		
		/**
		 * Modificado por Ivan Diaz Vera
		 * y José Maria Osuna Liñán
		 */
		JButton btnIntroducir = new JButton("Introducir Articulo");
		btnIntroducir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				String nombre=textFieldNombre.getText();
				String precio=textFieldPrecio.getText();
				String descripcion=textFieldDescripcion.getText();
				
				if(nombre.isEmpty()||precio.isEmpty()||descripcion.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Hay algun campo incompleto");
				}else {
				    Articulo articulo=new Articulo(nombre, Float.parseFloat(precio), descripcion);
				    
				}
			}
		});		
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
