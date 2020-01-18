package interfaces;

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
	 */
	public VentanaPrincipal() {

		usu = new Usuario("Alvaro", "uwu", "a@a.com", 1900f, true, null); // PRUEBA DE ALVARO Y SARA PARA VER QUE FUNCIONABA
		pantallaInicial = new PantallaInicial();
		this.setSize(500,500);
		this.setTitle("Tienda Cenec");
		this.setVisible(true);

		irAPantallaInicial();

	}

	/**
	 * Esta funci�n nos sirve para movernos a la pantalla inicial.
	 */
	public void irAPantallaInicial() {

		if (this.pantallaRegistro != null) { 

			this.pantallaRegistro.setVisible(false); 

		}

		this.setTitle("pantallaMenu");
		this.setContentPane(this.pantallaInicial);
		this.pantallaInicial.setVisible(true);

	}

	public void irAMenu() {
		
		if (this.pantallaInicial != null) { 

			this.pantallaInicial.setVisible(false); 

		}

		this.setTitle("Men�");
		this.setContentPane(this.pantallaMenu);
		this.pantallaMenu.setVisible(true);
		
	}

	public void irARegistro() {

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
		
		pantallaComprar = new Comprar();
		this.setTitle("Comprar");
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
		this.setTitle("M�s Saldo");
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
		this.setTitle("M�s Stock");
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
		this.setTitle("Nuevo Art�culo");
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
		this.setTitle("Ver mis Art�culos");
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
		this.setContentPane(this.pantallaVerUsuarios);
		this.pantallaVerUsuarios.setVisible(true);
		
	}
	
	/**
	 * Funci�n que permite cambiar al panel de Ver Stock.
	 * @author Sara Pedrosa
	 * @author Alvaro de Francisco
	 * 
	 * TODO: Preguntar a Miguel por el Panel: verStock, no existe
	 */
	public void irAVerStock() {
		
		if (this.pantallaMenu != null) { 

			this.pantallaMenu.setVisible(false); 

		}
		
		pantallaMasStock = new MasStock(this);
		this.setTitle("Ver Stock");
		this.setContentPane(this.pantallaMasStock);
		this.pantallaMasStock.setVisible(true);
		
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
		this.setContentPane(this.pantallaEditarUsuario);
		this.pantallaEditarUsuario.setVisible(true);
		
	}

}
