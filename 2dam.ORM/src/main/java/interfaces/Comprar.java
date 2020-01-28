package interfaces;
/**
 * @author Javier del Pozo
 * @author Alberto Riera
 */
import javax.swing.JPanel;
import clases.Articulo;
import clases.Usuario;
import componentes.BotonMenu;

import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextField;
import javax.swing.JSpinner;

public class Comprar extends JPanel {

	private Usuario user; // Usuario que se pasa por el constructor
	private VentanaPrincipal ventana; // JFrame que alberga los paneles
	private JList listaComprar; // Jlist que muestra los artículos en stock
	private JTextField saldo; // JTextField que muestra el saldo del que dispone el Usuario
	private JLabel lblComprar; // Label que muestra el texto principal de la pantalla
	private BotonMenu botonComprar; // Boton que lleva al evento que realiza la compra de un articulo
	private JSpinner cantidadSpinner; // Spinner que muestra la cantidad de articulos que el usuario puede comprar
	private SpinnerNumberModel m_numberSpinnerModel; // Numeros maximos y mínimos que se mostraran en el Spinner
	
	/**
	 * Constructor del JPanel Comprar.
	 * @param user Usuario de la aplicacion
	 * @param ventana JFrame de la aplicacion
	 * @author Sara Pedrosa
	 * @author Alvaro de Francisco
	 */
	public Comprar(Usuario user, VentanaPrincipal ventana) {
		
		this.user = user;
		this.ventana = ventana;

		setLayout(null);

		
		// ----------------------- LABEL CON EL TÍTULO DE LA PANTALLA ---------------------------------
		
		this.lblComprar = new JLabel("COMPRAR");
		lblComprar.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		lblComprar.setBounds(10, 11, 117, 23);
		add(lblComprar);		
		
		// ----------------------- JLIST EN LA QUE SE AÑADEN LOS ARTÍCULOS -----------------------------
		
		DefaultListModel model = new DefaultListModel();
		this.listaComprar = new JList(model);
		listaComprar.setBounds(10, 47, 99, 185);
		add(listaComprar);
		
		ArrayList<Articulo> articulo = user.getArticulosComprados();
		
		for	(int i = 0; i < articulo.size(); i++) {
			
			Articulo articuloMostrado = articulo.get(i);
			model.add(i, articuloMostrado.getArtName());
			
		}


		// ----------------------- BOTON QUE REALIZA LA COMPRA -------------------------------------

		this.botonComprar = new BotonMenu("Comprar");
		botonComprar.setBounds(144, 239, 172, 50);
		add(botonComprar);
		
		// ----------------------- JTEXTFIEL QUE MUESTRA EL SALDO -------------------------------------
		
		saldo = new JTextField();
		saldo.setBounds(124, 45, 86, 20);
		add(saldo);
		saldo.setColumns(10);
		saldo.setText(String.valueOf(user.getSaldo()));
		
		// ----------------------- SPINNER QUE MUESTRA LA CANTIDAD QUE SE PUEDE COMPRAR -------------------------------------
		
		int current = 1;
		int min = 1;
		int max = articulo.size();
		int step = 1;
	    this.m_numberSpinnerModel = new SpinnerNumberModel(current, min, max, step);
	   
		this.cantidadSpinner = new JSpinner(m_numberSpinnerModel);
		cantidadSpinner.setBounds(124, 90, 39, 23);
		
		add(cantidadSpinner);
		
		// ------------------ EVENTOS DE LOS BOTONES ------------------

		botonComprar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// TODO ESPERAR A QUE IMPLEMENTEN LA FUNCION DE COMPRAR DEL USUARIO

			}
		});
	}
	
}
