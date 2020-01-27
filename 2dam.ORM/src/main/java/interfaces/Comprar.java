package interfaces;
/**
 * @author Javier del Pozo
 * @author Alberto Riera
 */
import javax.swing.JPanel;
import javax.swing.JTextPane;

import clases.Articulo;
import clases.Usuario;
import classes.Argument;
import componentes.BotonMenu;

import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.ListModel;
import javax.swing.JTextField;

public class Comprar extends JPanel {

	private Usuario user;
	private VentanaPrincipal ventana;
	private JList listaComprar; 
	private JTextField textField;

	

	public Comprar(Usuario user, VentanaPrincipal ventana) {
		
		this.user=user;
		this.ventana=ventana;

		setLayout(null);

		DefaultListModel model = new DefaultListModel();
		this.listaComprar = new JList(model);
		listaComprar.setBounds(10, 47, 99, 185);
		add(listaComprar);

		JLabel lblComprar = new JLabel("COMPRAR");
		lblComprar.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		lblComprar.setBounds(10, 11, 117, 23);
		add(lblComprar);

		BotonMenu comprar = new BotonMenu("Comprar");
		comprar.setBounds(144, 239, 172, 50);
		add(comprar);
		
		JList list = new JList();
		list.setBounds(141, 114, 53, -66);
		add(list);
		
		textField = new JTextField();
		textField.setBounds(124, 45, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		ArrayList<Articulo> articulo = user.getArticulosComprados();
		
		for	(int i = 0; i < articulo.size(); i++) {
			Articulo articuloMostrado = articulo.get(i);
			model.add(i, articuloMostrado.getArtName());
		}

		// ------------------ EVENTOS DE LOS BOTONES ------------------

		comprar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
	}
}
