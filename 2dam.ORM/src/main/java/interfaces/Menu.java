package interfaces;

import javax.swing.JPanel;

import componentes.BotonMenu;
import main.Usuario;

public class Menu extends JPanel{
	
	public Menu(VentanaPrincipal v, Usuario usuaruo) {
		
		if (usuaruo.isEsTienda()) {
			
			BotonMenu logout = new BotonMenu("Logout");
			BotonMenu verStock = new BotonMenu("Ver Stock");
			BotonMenu annadirStock = new BotonMenu("Añadir Stock");
			BotonMenu annadirArticulo = new BotonMenu("Añadir Artículo");
			BotonMenu verUsuarios = new BotonMenu("Ver Usuarios");
			
		} else {
			
			BotonMenu logout = new BotonMenu("Logout");
			BotonMenu verMisArticulos = new BotonMenu("Ver mis Articulos");
			BotonMenu comprar = new BotonMenu("Comprar");
			BotonMenu annadirSaldo = new BotonMenu("AñadirSaldo");
			
		}
		
	}

}
