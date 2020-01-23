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
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import clases.Articulo;
import clases.Stock;
import clases.Usuario;
import excepciones.ArticuloNoInsertadoException;
import excepciones.StockNoModificadoException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MasStock extends JPanel {
	private JTextField campoNumericoMasStock;
	private Usuario usuario;
	private VentanaPrincipal ventana;
	private final String baseDatos = "jdbc:mysql://127.0.0.1:3306/nombredb";//LA BBDD
	private final String usuarioBd = "2dam";//EL USUARIO
	private final String contrase�a = "2dam";//LA CONTRASE�A
	private HashMap<Articulo, Short> HashMap=new HashMap<Articulo, Short>();//El HashMap con los Articulos y su Stock
	 private  Articulo articulo ;
	/**
	 * Create the panel.
	 */
	public MasStock(VentanaPrincipal v) {
		setLayout(null);
		Connection conexion = null;
		
		try {
			/**
			 * Conexi�n a la bd 
			 */
			conexion = DriverManager.getConnection(baseDatos,usuarioBd,contrase�a);
			Statement statement = conexion.createStatement();
			ResultSet articulosBD=statement.executeQuery("SELECT * FROM Articulo");
			while(articulosBD.next()) {
				
				try {
					articulo= new Articulo(
							articulosBD.getString("nombre"),
							articulosBD.getFloat("precio"),
							articulosBD.getString("descripcion")
							);
				} catch (ArticuloNoInsertadoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ResultSet stockBD = statement.executeQuery("SELECT cantidad FROM Stock WHERE nombre_Articulo="+articulo.getArtName());
				stockBD.next();
				
				// Se a�ade al 'HasMap' el art�culo y la cantidad del stock 
				HashMap.put(articulo, stockBD.getShort("cantidad"));
				stockBD.close();
			}

		//Boton atras
		JButton btnAtrasMasStock = new JButton("Atras");
		btnAtrasMasStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.setVisible(true);
			}
		});
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
		
		String n = campoNumericoMasStock.getText();
		int CantidadNumero=Integer.parseInt(n);
		 final short campoNumeroStock =(short)CantidadNumero;
		 
		//Boton  a�adir stock a la lista
		JButton btnA�adirMasStock = new JButton("A\u00F1adir");
		btnA�adirMasStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Stock s=new Stock();		
				try {
					s.a�adirStock(articulo,campoNumeroStock);
				} catch (StockNoModificadoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		
		btnA�adirMasStock.setBounds(237, 252, 89, 23);
		add(btnA�adirMasStock);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	
	}
}
