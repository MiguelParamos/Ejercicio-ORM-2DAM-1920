package interfaces;

import javax.swing.JPanel;

import componentes.BotonMenu;
import main.Usuario;

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
			
			logout.setBounds(0, 0, 100, 100);
			verStock.setBounds(120, 0, 100, 100);
			annadirStock.setBounds(240, 0, 100, 100);
			annadirArticulo.setBounds(360, 0, 100, 100);
			verUsuarios.setBounds(480, 0, 100, 100);
			
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
			
			logout.setBounds(0, 0, 100, 100);
			verMisArticulos.setBounds(120, 0, 100, 100);
			comprar.setBounds(240, 0, 100, 100);
			annadirSaldo.setBounds(360, 0, 100, 100);

			add(logout);
			add(verMisArticulos);
			add(comprar);
			add(annadirSaldo);
			
		}
		
		setVisible(true);
		
	}
	
}
