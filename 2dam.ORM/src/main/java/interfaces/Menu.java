package interfaces;

import javax.swing.JPanel;

import clases.Usuario;
import componentes.BotonMenu;

public class Menu extends JPanel{
	
	public Menu(VentanaPrincipal v, Usuario usuaruo) {
		
		if (usuaruo.isEsTienda()) {
			
			BotonMenu logout = new BotonMenu("Logout");
			BotonMenu verStock = new BotonMenu("Ver Stock");
			BotonMenu annadirStock = new BotonMenu("A�adir Stock");
			BotonMenu annadirArticulo = new BotonMenu("A�adir Art�culo");
			BotonMenu verUsuarios = new BotonMenu("Ver Usuarios");
			
		} else {
			
			BotonMenu logout = new BotonMenu("Logout");
			BotonMenu verMisArticulos = new BotonMenu("Ver mis Articulos");
			BotonMenu comprar = new BotonMenu("Comprar");
			BotonMenu annadirSaldo = new BotonMenu("A�adirSaldo");
			
		}
		
	}

}
