package interfaces;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import clases.Usuario;

public class MasStock extends JPanel {
	private JTextField campoNumericoMasStock;
	private Usuario usuario;
	private VentanaPrincipal ventana;
	
	/**
	 * Create the panel.
	 */
	public MasStock(VentanaPrincipal v) {
		setLayout(null);
		
		//Boton atras
		JButton btnAtrasMasStock = new JButton("Atras");
		btnAtrasMasStock.setBounds(332, 252, 89, 23);
		add(btnAtrasMasStock);
		//Label "a�adir stock"
		JLabel lblA�adirStock = new JLabel("A\u00F1adir Stock");
		lblA�adirStock.setBounds(29, 256, 70, 14);
		add(lblA�adirStock);
		//JTextField "campoNumericoMasStock"
		campoNumericoMasStock = new JTextField();
		campoNumericoMasStock.setToolTipText("");
		campoNumericoMasStock.setBounds(94, 253, 86, 20); 
		add(campoNumericoMasStock);
		campoNumericoMasStock.setColumns(10);
		//Boton  a�adir stock a la lista
		JButton btnA�adirMasStock = new JButton("A\u00F1adir");
		btnA�adirMasStock.setBounds(233, 252, 89, 23);
		add(btnA�adirMasStock);
		//Select sin uso.
		String selectArticulo = "SELECT * FROM Articulo";
		
	}
}
