package interfaces;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import clases.Usuario;
import componentes.BotonMenu;

/**
 * El panel Menu de la aplicacion. Hereda de JPanel.
 * @author Sara Pedrosa
 * @author Alvaro de Francisco
 * @author Alvarop627
 */
public class Menu extends JPanel {

	private VentanaPrincipal v; // El JFrame personalizado que alberga el panel
	private Usuario u; // El Usuario que utiliza la aplicacion
	
	/**
	 * Constructor de Menu
	 * @param v El JFrame personalizado que alberga el panel
	 * @param usuario El Usuario que utiliza la aplicacion
	 */
	public Menu(VentanaPrincipal ventana, Usuario usuario) {

		super();
		this.v = ventana;
		this.u = usuario;

		setLayout(null);
		
		if (usuario.isEsTienda()) { // Comprueba si el Usuario es una Tienda

			BotonMenu logout = new BotonMenu("Logout");
			BotonMenu verStock = new BotonMenu("Ver Stock");
			BotonMenu annadirStock = new BotonMenu("Anadir Stock");
			BotonMenu annadirArticulo = new BotonMenu("Anadir Articulo");
			BotonMenu verUsuarios = new BotonMenu("Ver Usuarios");
			BotonMenu editarUsuario = new BotonMenu("Editar Usuario");
			BotonMenu annadirProveedor = new BotonMenu("Anadir Proveedor");

			logout.setBounds(10, 58, 172, 50);
			verStock.setBounds(191, 58, 172, 50);
			annadirStock.setBounds(373, 58, 172, 50);
			annadirArticulo.setBounds(191, 141, 172, 50);
			verUsuarios.setBounds(10, 141, 172, 50);
			editarUsuario.setBounds(373, 141, 172, 50);
			annadirProveedor.setBounds(191, 224, 172, 50);

			add(logout);
			add(verStock);
			add(annadirStock);
			add(annadirArticulo);
			add(verUsuarios);
			add(editarUsuario);
			add(annadirProveedor);
			
			// ------------------ EVENTOS DE LOS BOTONES ------------------
			
			logout.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
	                v.irAPantallaInicial();
				}
			});
			
			annadirStock.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
	                v.irAMasStock();
				}
			});
			
			annadirArticulo.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
	                v.irANuevoArticulo();
				}
			});
			
			verStock.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
	                //  TODO v.irAVerStock(); Todavia no se ha creado la función
				}
			});
			

			verUsuarios.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
	                v.irAVerUsuarios();
				}
			});
			
			editarUsuario.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
	                v.irAEditarUsuario();
				}
			});
			
			annadirProveedor.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
	                v.irANuevoProveedor();
				}
			});

		} else { // Comprueba si el Usuario NO es una Tienda

			BotonMenu logout = new BotonMenu("Logout");
			BotonMenu verMisArticulos = new BotonMenu("Ver mis Articulos");
			BotonMenu comprar = new BotonMenu("Comprar");
			BotonMenu annadirSaldo = new BotonMenu("Añadir Saldo");
			BotonMenu editarUsuario = new BotonMenu("Editar Usuario");

			logout.setBounds(10, 58, 172, 50);
			verMisArticulos.setBounds(191, 58, 172, 50);
			comprar.setBounds(373, 58, 172, 50);
			annadirSaldo.setBounds(95, 141, 172, 50);
			editarUsuario.setBounds(276, 141, 172, 50);

			add(logout);
			add(verMisArticulos);
			add(comprar);
			add(annadirSaldo);
			add(editarUsuario);
			
			// ------------------ EVENTOS DE LOS BOTONES ------------------
			
			logout.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
	                v.irAPantallaInicial();
				}
			});
			
			verMisArticulos.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
	                v.irAVerMisArticulos();
				}
			});
			
			comprar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
	                v.irAComprar();
				}
			});
			
			annadirSaldo.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
	                v.irAMasSaldo();
				}
			});
			
			editarUsuario.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
	                v.irAEditarUsuario();
				}
			});
			
			
			comprar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
	                v.irAComprar();;
				}
			});
			

		}

		setVisible(true);

	}

}
