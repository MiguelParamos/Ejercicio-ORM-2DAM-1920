package interfaces;

import javax.swing.JPanel;

import clases.Usuario;
import componentes.BotonMenu;

/**
 * El panel Menu de la aplicacion. Hereda de JPanel.
 * @author Sara Pedrosa
 * @author Alvaro de Francisco
 *
 */
public class Menu extends JPanel {

	private VentanaPrincipal v; // El JFrame personalizado que alberga el panel
	
	/**
	 * Constructor de Menu
	 * @param v El JFrame personalizado que alberga el panel
	 * @param usuario El Usuario que utiliza la aplicacion
	 */
	public Menu(VentanaPrincipal v, Usuario usuario) {

		super();
		this.v = v;

		setLayout(null);

		if (usuario.isEsTienda()) { // Comprueba si el Usuario es una Tienda

			BotonMenu logout = new BotonMenu("Logout");
			BotonMenu verStock = new BotonMenu("Ver Stock");
			BotonMenu annadirStock = new BotonMenu("Añadir Stock");
			BotonMenu annadirArticulo = new BotonMenu("Añadir Artículo");
			BotonMenu verUsuarios = new BotonMenu("Ver Usuarios");

			logout.setBounds(10, 108, 172, 50);
			verStock.setBounds(191, 108, 172, 50);
			annadirStock.setBounds(373, 108, 172, 50);
			annadirArticulo.setBounds(192, 186, 172, 50);
			verUsuarios.setBounds(10, 186, 172, 50);

			add(logout);
			add(verStock);
			add(annadirStock);
			add(annadirArticulo);
			add(verUsuarios);

		} else { // Comprueba si el Usuario NO es una Tienda

			BotonMenu logout = new BotonMenu("Logout");
			BotonMenu verMisArticulos = new BotonMenu("Ver mis Articulos");
			BotonMenu comprar = new BotonMenu("Comprar");
			BotonMenu annadirSaldo = new BotonMenu("AñadirSaldo");

			logout.setBounds(10, 108, 172, 50);
			verMisArticulos.setBounds(191, 108, 172, 50);
			comprar.setBounds(373, 108, 172, 50);
			annadirSaldo.setBounds(192, 186, 172, 50);

			add(logout);
			add(verMisArticulos);
			add(comprar);
			add(annadirSaldo);

		}

		setVisible(true);

	}

}
