package interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;

import clases.Articulo;
import clases.Usuario;

/**
 * JFrame personalizado que corresponde a la ventana de la aplicaci�n. Herede de JFrame.
 * @author Sara Pedrosa
 * @author Alvaro de Francisco
 */
public class VentanaPrincipal extends JFrame {

	private Registro pantallaRegistro; // Panel de Registro
	private PantallaInicial pantallaInicial; // Panel Inicial
	private Menu pantallaMenu; // Panel Men�
	private Comprar pantallaComprar; // Panel de Comprar
	private MasSaldo pantallaMasSaldo;
	private MasStock pantallaMasStock;
	private NuevoArticulo pantallaNuevoArticulo;
	private VerMisArticulos pantallaVerMisArticulos;
	private VerUsuarios pantallaVerUsuarios;
	private EditarUsuario pantallaEditarUsuario;
	private Usuario usu;
	
	/**
	 * Constructor de la ventana principal de la aplicaci�n.
	 * @throws SQLException 
	 */
	public VentanaPrincipal() throws SQLException {

		//usu = new Usuario("Alvaro", "uwu", "a@a.com", 1900f, true, null);
		pantallaInicial = new PantallaInicial(this);
		this.setSize(500,500);
		this.setTitle("Tienda Cenec");
		this.setVisible(true);

		irAPantallaInicial();
		//irAEditarUsuario();

	}

	/**
	 * Esta funci�n nos sirve para movernos a la pantalla inicial.
	 */
	public void irAPantallaInicial() {

		if (this.pantallaRegistro != null) { 

			this.pantallaRegistro.setVisible(false); 

		}

		this.setTitle("pantallaMenu");
		this.setSize(500, 500);
		this.setContentPane(this.pantallaInicial);
		this.pantallaInicial.setVisible(true);

	}

	public void irAMenu() {
		
		if (this.pantallaInicial != null) { 

			this.pantallaInicial.setVisible(false); 

		}

		this.pantallaMenu = new Menu(this, usu);
		this.setTitle("Menú");
		this.setSize(575, 350);
		this.setContentPane(this.pantallaMenu);
		this.pantallaMenu.setVisible(true);
		
	}

	/**
	 * Funcion que permite ir al panel de Registro
	 * @author alfre
	 * @author TataGolosa
	 */
	public void irARegistro() {
		if(this.pantallaMenu!=null) {
			this.pantallaMenu.setVisible(false);
		}
		pantallaRegistro=new Registro(this);
		this.setTitle("Registro");
		this.setSize(500, 500);
		this.setContentPane(this.pantallaRegistro);
		this.pantallaRegistro.setVisible(true);
		
	}

	/**
	 * Funci�n que permite cambiar al panel de Comprar.
	 * @author Sara Pedrosa
	 * @author Alvaro de Francisco
	 */
	public void irAComprar() {

		if (this.pantallaMenu != null) { 

			this.pantallaMenu.setVisible(false); 

		}
		
		pantallaComprar = new Comprar(usu, this);
		this.setTitle("Comprar");
		this.setSize(500, 500);
		this.setContentPane(this.pantallaComprar);
		this.pantallaComprar.setVisible(true);

	}

	/**
	 * Funci�n que permite cambiar al panel de M�s Saldo.
	 * @author Sara Pedrosa
	 * @author Alvaro de Francisco
	 */
	public void irAMasSaldo() {

		if (this.pantallaMenu != null) { 

			this.pantallaMenu.setVisible(false); 

		}
		
		pantallaMasSaldo = new MasSaldo(this, usu);
		this.setTitle("Más Saldo");
		this.setSize(500, 500);
		this.setContentPane(this.pantallaMasSaldo);
		this.pantallaMasSaldo.setVisible(true);

	}

	/**
	 * Funci�n que permite cambiar al panel de M�s Stock.
	 * @author Sara Pedrosa
	 * @author Alvaro de Francisco
	 */
	public void irAMasStock() {
			
		if (this.pantallaMenu != null) { 

			this.pantallaMenu.setVisible(false); 

		}
		
		pantallaMasStock = new MasStock(this);
		this.setTitle("Más Stock");
		this.setSize(500, 500);
		this.setContentPane(this.pantallaMasStock);
		this.pantallaMasStock.setVisible(true);
		
	}

	/**
	 * Funci�n que permite cambiar al panel de Nuevo Art�culo.
	 * @author Sara Pedrosa
	 * @author Alvaro de Francisco
	 */
	public void irANuevoArticulo() {
		
		if (this.pantallaMenu != null) { 

			this.pantallaMenu.setVisible(false); 

		}
		
		pantallaNuevoArticulo = new NuevoArticulo(this);
		this.setTitle("Nuevo Artículo");
		this.setSize(500, 500);
		this.setContentPane(this.pantallaNuevoArticulo);
		this.pantallaNuevoArticulo.setVisible(true);
		
	}

	/**
	 * Funci�n que permite cambiar al panel de Mis Art�culos.
	 * @author Sara Pedrosa
	 * @author Alvaro de Francisco
	 */
	public void irAVerMisArticulos() {
		
		if (this.pantallaMenu != null) { 

			this.pantallaMenu.setVisible(false); 

		}
		
		pantallaVerMisArticulos = new VerMisArticulos(this, usu);
		this.setTitle("Ver mis Artículos");
		this.setContentPane(this.pantallaVerMisArticulos);
		this.pantallaVerMisArticulos.setVisible(true);
		
	}

	/**
	 * Funci�n que permite cambiar al panel de Ver Usuarios.
	 * @author Sara Pedrosa
	 * @author Alvaro de Francisco
	 */
	public void irAVerUsuarios() {
		
		if (this.pantallaMenu != null) { 

			this.pantallaMenu.setVisible(false); 

		}
		
		pantallaVerUsuarios = new VerUsuarios(this);
		this.setTitle("Ver Usuarios");
		this.setSize(500, 525);
		this.setContentPane(this.pantallaVerUsuarios);
		this.pantallaVerUsuarios.setVisible(true);
		
	}
	
	/**
	 * Funci�n que permite cambiar al panel de Editar Usuario.
	 * @author Sara Pedrosa
	 * @author Alvaro de Francisco
	 * 
	 * TODO: Comprobar cuando implementen los companneros la clase EditarUsuario.
	 */
	public void irAEditarUsuario() {
		
		if (this.pantallaMenu != null) { 

			this.pantallaMenu.setVisible(false); 

		}
		
		pantallaEditarUsuario = new EditarUsuario(this);
		this.setTitle("Editar Usuario");
		this.setSize(500, 500);
		this.setContentPane(this.pantallaEditarUsuario);
		this.pantallaEditarUsuario.setVisible(true);
		
	}

	public Usuario getUsu() {
		return usu;
	}

	public void setUsu(Usuario usu) {
		this.usu = usu;
	}

}
