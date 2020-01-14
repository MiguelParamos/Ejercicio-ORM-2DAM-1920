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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.MatteBorder;
import java.awt.Color;

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
		
		final JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBounds(10, 194, 430, 225);
		add(panel);
		panel.setLayout(null);
		panel.setVisible(false);
		
		final JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(20, 50, 200, 20);
		panel.add(lblNombre);
		
		final JLabel lblContrasenia = new JLabel("Contraseña:");
		lblContrasenia.setBounds(20, 85, 200, 20);
		panel.add(lblContrasenia);
		
		final JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(20, 120, 200, 20);
		panel.add(lblEmail);
		
		final JLabel lblSaldo = new JLabel("Saldo:");
		lblSaldo.setBounds(20, 155, 200, 20);
		panel.add(lblSaldo);
		
		final JLabel lblesAdmin = new JLabel("¿Es Admin?");
		lblesAdmin.setBounds(268, 85, 132, 20);
		panel.add(lblesAdmin);
		
		final JList list = new JList(listModel);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lblNombre.setText("Nombre: "+arrayUsuarios.get(list.getSelectedIndex()).getNombre());
				lblContrasenia.setText("Contraseña: "+arrayUsuarios.get(list.getSelectedIndex()).getPassword());
				lblEmail.setText("Email: "+arrayUsuarios.get(list.getSelectedIndex()).getEmail());
				lblSaldo.setText("Saldo: "+arrayUsuarios.get(list.getSelectedIndex()).getSaldo()+"€");
				lblesAdmin.setText("¿Es Admin? "+(arrayUsuarios.get(list.getSelectedIndex()).isEsTienda()==true?"Si":"No"));
				panel.setVisible(true);
			}
		});
		
		
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(10, 40, 430, 130);
		add(scrollPane);
		
		JLabel lblListaDeUsuarios = new JLabel("Lista de usuarios:");
		lblListaDeUsuarios.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblListaDeUsuarios.setBounds(10, 15, 120, 20);
		add(lblListaDeUsuarios);
		
		JButton btnEliminarUsuario = new JButton("Borrar Usuario");
		btnEliminarUsuario.setBounds(289, 194, 120, 20);
		panel.add(btnEliminarUsuario);
		
		JButton btnArtculosComprados = new JButton("Artículos Comprados");
		btnArtculosComprados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Click para mostrar los artículos comprados (usar clase VerMisArtículos)
			}
		});
		btnArtculosComprados.setBounds(230, 120, 170, 20);
		panel.add(btnArtculosComprados);
		
		btnEliminarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int x=JOptionPane.showOptionDialog(vPrincipal, "¿Estás seguro de que quieres borrar este usuario?", "Borrar Usuario", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, new String[] {"Si", "No"}, "Si");
				if (x==0) { // Si ha pulsado 'Sí'
					JOptionPane.showMessageDialog(vPrincipal, "Usuario borrado");
					// TODO Borrar usuario de la lista y recargar la página
				}
			}
		});
		this.setVisible(true);
	}
}
