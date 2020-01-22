package interfaces;

import javax.swing.JPanel;

import clases.Usuario;

import javax.swing.JLabel;
import java.awt.Font;

public class EditarUsuario  extends JPanel{
	
	private VentanaPrincipal v;

	/**
	 * @param v
	 */
	public EditarUsuario(VentanaPrincipal v) {
		super();
		this.v = v;
		Usuario user=v.getUsu();
		setSize(500,500);
		setLayout(null);
		
		JLabel lblDatosUsuario = new JLabel("Datos del usuario:");
		lblDatosUsuario.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDatosUsuario.setBounds(25, 20, 211, 29);
		add(lblDatosUsuario);
		
		JLabel lblNombreUsuario = new JLabel("Nombre:"+user.getNombre());
		lblNombreUsuario.setBounds(57, 60, 113, 13);
		add(lblNombreUsuario);
		
		JLabel lblPassUsuario = new JLabel("Contrase\u00F1a:"+user.getPassword());
		lblPassUsuario.setBounds(57, 83, 137, 13);
		add(lblPassUsuario);
		
		JLabel lblEmailUsuario = new JLabel("Email:"+user.getEmail());
		lblEmailUsuario.setBounds(57, 106, 113, 13);
		add(lblEmailUsuario);
		String tienda="No";
		if(user.isEsTienda()) {
			tienda="Si";
		}
		JLabel lblEsTiendaUsuario = new JLabel("Es Tienda:"+tienda);
		lblEsTiendaUsuario.setBounds(57, 129, 113, 13);
		add(lblEsTiendaUsuario);
	}
}
