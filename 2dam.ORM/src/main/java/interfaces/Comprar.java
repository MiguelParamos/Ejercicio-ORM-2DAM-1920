package interfaces;
/**
 * @author Javier del Pozo
 * @author Alberto Riera
 */
import javax.swing.JPanel;
import clases.Articulo;
import clases.Stock;
import clases.Usuario;
import componentes.BotonMenu;
import excepciones.CompraFallidaException;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextField;
import javax.swing.JSpinner;

public class Comprar extends JPanel {

	private Usuario user; // Usuario que se pasa por el constructor
	private VentanaPrincipal ventana; // JFrame que alberga los paneles
	private JList listaComprar; // Jlist que muestra los art�culos en stock
	private JTextField saldo; // JTextField que muestra el saldo del que dispone el Usuario
	private JLabel lblComprar; // Label que muestra el texto principal de la pantalla
	private BotonMenu botonComprar; // Boton que lleva al evento que realiza la compra de un articulo
	private JSpinner cantidadSpinner; // Spinner que muestra la cantidad de articulos que el usuario puede comprar
	private SpinnerNumberModel m_numberSpinnerModel; // Numeros maximos y m�nimos que se mostraran en el Spinner
	private Stock stockTienda; // Stock de la tienda 
	private Menu pantallaMenu; //Pantalla Menu

	/**
	 * Constructor del JPanel Comprar.
	 * @param user Usuario de la aplicacion
	 * @param ventana JFrame de la aplicacion
	 * @author Sara Pedrosa
	 * @author Alvaro de Francisco
	 */
	public Comprar(final Usuario user, final VentanaPrincipal ventana) {

		this.user = user;
		this.ventana = ventana;

		setLayout(null);

		// ----------------------- LABEL CON EL T�TULO DE LA PANTALLA ---------------------------------

		this.lblComprar = new JLabel("COMPRAR");
		lblComprar.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		lblComprar.setBounds(10, 11, 117, 23);
		add(lblComprar);		

		// ----------------------- JLIST EN LA QUE SE A�ADEN LOS ART�CULOS -----------------------------

		DefaultListModel model = new DefaultListModel();
		stockTienda=new Stock();
		HashMap <Articulo, Short> articulos = stockTienda.getHashMap();

		Iterator<HashMap.Entry<Articulo, Short>> entries = articulos.entrySet().iterator();

		while (entries.hasNext()) {
			
			int contador = 0;
			
			HashMap.Entry<Articulo, Short> articuloMostrado = entries.next();

			System.out.println("Key = " + articuloMostrado.getKey().getArtName() + ", Value = " + articuloMostrado.getValue());
			
			model.add(contador, articuloMostrado.getKey().getArtName());
			contador++;
			
		}

		this.listaComprar = new JList(model);
		listaComprar.setBounds(10, 47, 99, 185);
		add(listaComprar);

		// ----------------------- BOTON QUE REALIZA LA COMPRA -------------------------------------

		this.botonComprar = new BotonMenu("Comprar");
		botonComprar.setBounds(144, 239, 172, 50);
		add(botonComprar);

		// ----------------------- JTEXTFIEL QUE MUESTRA EL SALDO -------------------------------------

		saldo = new JTextField();
		saldo.setBounds(124, 45, 86, 20);
		add(saldo);
		saldo.setColumns(10);
		final float saldoPrimero = user.getSaldo();
		saldo.setText(String.valueOf(saldoPrimero));

		// ----------------------- SPINNER QUE MUESTRA LA CANTIDAD QUE SE PUEDE COMPRAR -------------------------------------

		int current = 1;
		int min = 1;
		int max = articulos.size();
		int step = 1;
		this.m_numberSpinnerModel = new SpinnerNumberModel(current, min, max, step);

		this.cantidadSpinner = new JSpinner(m_numberSpinnerModel);
		cantidadSpinner.setBounds(124, 90, 39, 23);

		add(cantidadSpinner);

		// ------------------ EVENTOS DE LOS BOTONES ------------------

		botonComprar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					
					float saldoSegundo = saldoPrimero;
					
					user.comprar((Articulo)listaComprar.getSelectedValue(), (Short) cantidadSpinner.getValue());

					if (saldoPrimero >= saldoSegundo) {
						
						JOptionPane.showMessageDialog(null, "Se ha producido un error en su compra", "Error Compra", JOptionPane.WARNING_MESSAGE);
					
					} else {

						JOptionPane.showMessageDialog(null, "Compra realizada correctamente");
						ventana.irAMenu();

					}
					
				} catch (CompraFallidaException e1) {e1.printStackTrace();}
			}
		});
	}

}
