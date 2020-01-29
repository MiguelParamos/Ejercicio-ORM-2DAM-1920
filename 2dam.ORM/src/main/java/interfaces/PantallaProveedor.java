package interfaces;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import clases.Proveedor;
import excepciones.RegistroIncorrectoException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/**
 * 
 * @author Juan Miguel 
 * @author Alvarop627
 *
 */


public class PantallaProveedor extends JPanel {
	private VentanaPrincipal ventana;
	private JTextField tfNombreProveedor;
	private JTextField tfCiudadProveedor;
	private	Proveedor p;
	
	
	public PantallaProveedor(VentanaPrincipal v) {
		ventana = v;
		setBackground(new Color(91, 157, 195));
		setSize(500,500);
		setLayout(null);
	
		
		// JLabels para nombre del proveedor y ciudad del proveedor
		JLabel lblNombreProveedor = new JLabel("Nombre Proveedor");
		lblNombreProveedor.setBounds(56, 99, 145, 21);
		lblNombreProveedor.setFont(new Font("Dialog", Font.BOLD, 16));
		add(lblNombreProveedor);
		
		JLabel lblCiudadProveedor = new JLabel("Ciudad Proveedor");
		lblCiudadProveedor.setBounds(56, 131, 139, 21);
		lblCiudadProveedor.setFont(new Font("Dialog", Font.BOLD, 16));
		add(lblCiudadProveedor);
		
		
		//Botones para añadir proveedor y otro para volver a menu
		JButton btnAnadirProveedor = new JButton("Añadir Proveedor");
		btnAnadirProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tfNombreProveedor.getText()!="" && tfCiudadProveedor.getText()!="") {
				try {
					p = new Proveedor(tfNombreProveedor.getText(), tfCiudadProveedor.getText(), null);
				} catch (RegistroIncorrectoException e) {
					e.printStackTrace();
				}
				}
				
			}
		});
		btnAnadirProveedor.setBounds(181, 281, 153, 25);
		btnAnadirProveedor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(btnAnadirProveedor);
		
		JButton btnAtras = new JButton("Volver a Menu");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAtras.setBounds(181, 331, 153, 25);
		add(btnAtras);
		
		
		//Campos de texto para introducir el nombre del proveedor y la ciudad del proveedor.
		tfNombreProveedor = new JTextField();
		tfNombreProveedor.setBounds(237, 102, 169, 20);
		add(tfNombreProveedor);
		tfNombreProveedor.setColumns(10);
		
		tfCiudadProveedor = new JTextField();
		tfCiudadProveedor.setBounds(237, 134, 169, 20);
		add(tfCiudadProveedor);
		tfCiudadProveedor.setColumns(10);
	}
}
