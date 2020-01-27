package interfaces;
/**
 * @author ecalv (Edu)
 * @author Adrian
 */
import javax.swing.JPanel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

import javax.swing.ComboBoxEditor;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import clases.Articulo;
import clases.Stock;
import clases.Usuario;
import excepciones.ArticuloNoInsertadoException;
import excepciones.StockNoModificadoException;

import java.awt.event.ActionListener;
import java.nio.channels.Selector;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class MasStock extends JPanel {
	private JTextField campoNumericoMasStock;
	private VentanaPrincipal ventana;
	private Articulo articulo;
	/**
	 * Create the panel.
	 */
	public MasStock(VentanaPrincipal v) {
		setLayout(null);
		this.ventana=v;

		//Boton atras
		JButton btnAtrasMasStock = new JButton("Atras");
		btnAtrasMasStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.setVisible(true);
			}
		});
		btnAtrasMasStock.setBounds(332, 252, 89, 23);
		add(btnAtrasMasStock);
		
		//Label "añadir stock"
		JLabel lblAñadirStock = new JLabel("A\u00F1adir Stock");
		lblAñadirStock.setBounds(29, 256, 70, 14);
		add(lblAñadirStock);

		//JTextField "campoNumericoMasStock"
		campoNumericoMasStock = new JTextField();
		campoNumericoMasStock.setToolTipText("");
		campoNumericoMasStock.setBounds(94, 253, 86, 20); 
		add(campoNumericoMasStock);
		campoNumericoMasStock.setColumns(10);
		
		
		
		final JComboBox selector = new JComboBox();
		selector.setBounds(180, 129, 153, 28);
		add(selector);
	
		ArrayList<Articulo> lista=new ArrayList<Articulo>(Articulo.todosLosArticulos());
		for(Articulo art : lista) {
			selector.addItem(art.getArtName());
		}
		String n = campoNumericoMasStock.getText();
		int CantidadNumero=Integer.parseInt(n);
		final short campoNumeroStock =(short)CantidadNumero;
		 
		//Boton  añadir stock a la lista
		JButton btnAñadirMasStock = new JButton("A\u00F1adir");
		btnAñadirMasStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Stock s=new Stock();		
				try {
					s.añadirStock((Articulo)selector.getSelectedItem(),campoNumeroStock);
				} catch (StockNoModificadoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		
		btnAñadirMasStock.setBounds(237, 252, 89, 23);
		add(btnAñadirMasStock);
		
	;
		
		
		
	
	}
}
