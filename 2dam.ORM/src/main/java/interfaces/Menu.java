package interfaces;

import javax.swing.JPanel;

import clases.Usuario;
import componentes.BotonMenu;

public class Menu extends JPanel{

	private VentanaPrincipal v;

	public Menu(VentanaPrincipal v, Usuario usuaruo) {

		super();
		this.v = v;

		setLayout(null);


		if (usuaruo.isEsTienda()) {

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

		} else {

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
