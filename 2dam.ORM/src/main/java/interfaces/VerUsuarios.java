package interfaces;

import javax.swing.JPanel;
import main.Usuario;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

/**
 * Clase que muestra los datos de los usuarios registrados
 * @author Darash
 *
 */
public class VerUsuarios extends JPanel{
	private VentanaPrincipal vPrincipal; // Variable para la ventana principal de la aplicación
	private ArrayList<Usuario> arrayUsuarios; // Array con todos los usuarios registrados
	private VerUsuarios thisRef; // Variable auxiliar de VerUsuarios 
	
	/**
	 * Constructor del JPanel
	 * @param vp Ventana principal
	 */
	public VerUsuarios(VentanaPrincipal vp) {
		this.vPrincipal=vp;
		thisRef=this;
		arrayUsuarios=new ArrayList<Usuario>();
		initComponents();
	}
	
	/**
	 * Función con todos los componentes del JPanel
	 */
	public void initComponents() {
		setLayout(null);
		DefaultListModel<String> listModel=new DefaultListModel<String>();
		for (Usuario usuario : arrayUsuarios) {
			listModel.addElement(usuario.getNombre()+" - Rol: "+(((usuario.isEsTienda()?"Admin":"Usuario"))));
		}
		final JList list = new JList(listModel);
		
		JButton btnMostrarInformacion = new JButton("Mostrar Información");
		btnMostrarInformacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Mostrar información del usuario, en otra ventana si es posible (Preguntar a Miguel)
			}
		});
		btnMostrarInformacion.setBounds(10, 378, 150, 30);
		add(btnMostrarInformacion);
		
		JButton btnEliminarUsuario = new JButton("Borrar Usuario");
		btnEliminarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int x=JOptionPane.showOptionDialog(vPrincipal, "¿Estás seguro de que quieres borrar este usuario?", "Borrar Usuario", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, new String[] {"Si", "No"}, "Si");
				if (x==0) { // Si ha pulsado 'Sí'
					JOptionPane.showMessageDialog(vPrincipal, "Usuario borrado");
					// TODO Borrar usuario de la lista y recargar la página
				}
			}
		});
		btnEliminarUsuario.setBounds(290, 378, 150, 30);
		add(btnEliminarUsuario);
		
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(10, 40, 430, 308);
		add(scrollPane);
		
		JLabel lblListaDeUsuarios = new JLabel("Lista de usuarios:");
		lblListaDeUsuarios.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblListaDeUsuarios.setBounds(10, 15, 120, 20);
		add(lblListaDeUsuarios);
		this.setVisible(true);
	}
}
