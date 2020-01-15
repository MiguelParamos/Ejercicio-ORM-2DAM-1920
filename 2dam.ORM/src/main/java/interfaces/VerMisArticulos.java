package interfaces;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import main.Articulo;
import main.Usuario;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Esta clase modela los articulos que ha comprado un usuario.
 * @author Javier Rodríguez y Juan Carlos
 *
 */
public class VerMisArticulos extends JPanel{
	private VentanaPrincipal ventanaPrincipal;
	private Usuario user;
	@SuppressWarnings("unchecked")
	/**
	 * El constructor principal de la clase.
	 * @param vp la clase VentanaPrincipal del programa.
	 * @param us la clase Usuario del programa.
	 */
	public VerMisArticulos(VentanaPrincipal vp,Usuario us) {
		this.ventanaPrincipal=vp;
		this.user=us;
		setSize(new Dimension(500, 500));
		setLayout(null);
		
		//LISTA DE ARTICULOS
		//Foreach para rellenar los articulos que dependan del usuario.
		DefaultListModel dLM=new DefaultListModel<String>();
		for(Articulo a: user.getArticulosComprados()) {
			dLM.addElement(a.getArtName());
		}
		JList listaArticulos = new JList(dLM);
		listaArticulos.setBounds(135, 54, 233, 282);
		add(listaArticulos);
		
		//BOTÓN ATRÁS
		JButton btnAtras = new JButton("Atr\u00E1s");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Boton atrás pendiente para hacer más adelante.
			}
		});
		btnAtras.setBounds(49, 425, 89, 23);
		add(btnAtras);
		
	}
}
