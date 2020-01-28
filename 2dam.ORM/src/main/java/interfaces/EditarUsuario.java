package interfaces;

import javax.swing.JPanel;

import clases.Usuario;
import excepciones.LoginIncorrectoException;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class EditarUsuario  extends JPanel{
	
	private VentanaPrincipal v;
	private JTextField tUser;
	private JTextField tPass;
	private JTextField tMail;

	/**
	 * @param v
	 */
	public EditarUsuario(VentanaPrincipal v) {
		super();
		this.v = v;
		Usuario user;
		try {
			user = new Usuario("Alvaro","uwu");
			
			setSize(500,500);
			setLayout(null);
			
			JLabel lblDatosUsuario = new JLabel("Datos del usuario:");
			lblDatosUsuario.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblDatosUsuario.setBounds(25, 20, 211, 29);
			add(lblDatosUsuario);
			
			final JLabel lblNombreUsuario = new JLabel("Nombre: "+user.getNombre());
			lblNombreUsuario.setBounds(57, 60, 113, 13);
			add(lblNombreUsuario);
			
			final JLabel lblPassUsuario = new JLabel("Contrase\u00F1a: "+user.getPassword());
			lblPassUsuario.setBounds(57, 83, 137, 13);
			add(lblPassUsuario);
			
			final JLabel lblEmailUsuario = new JLabel("Email: "+user.getEmail());
			lblEmailUsuario.setBounds(57, 106, 179, 13);
			add(lblEmailUsuario);
			String tienda="No";
			if(user.isEsTienda()) {
				tienda="Si";
			}
			final JLabel lblEsTiendaUsuario = new JLabel("Es Tienda: "+tienda);
			lblEsTiendaUsuario.setBounds(57, 129, 113, 13);
			add(lblEsTiendaUsuario);
			
			JLabel lblUsuario = new JLabel("Usuario");
			lblUsuario.setBounds(57, 232, 56, 16);
			add(lblUsuario);
			
			JLabel lblNewLabel = new JLabel("Modificaci\u00F3n de datos");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblNewLabel.setBounds(25, 186, 200, 16);
			add(lblNewLabel);
			
			tUser = new JTextField();
			tUser.setBounds(147, 229, 116, 22);
			add(tUser);
			tUser.setColumns(10);
			
			JLabel lblContrasea = new JLabel("Contrase\u00F1a");
			lblContrasea.setBounds(57, 286, 72, 16);
			add(lblContrasea);
			
			tPass = new JTextField();
			tPass.setBounds(147, 283, 116, 22);
			add(tPass);
			tPass.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("Email");
			lblNewLabel_1.setBounds(57, 341, 56, 16);
			add(lblNewLabel_1);
			
			tMail = new JTextField();
			tMail.setBounds(147, 338, 116, 22);
			add(tMail);
			tMail.setColumns(10);
			
			JLabel lblEsTienda = new JLabel("Es tienda");
			lblEsTienda.setBounds(57, 394, 56, 16);
			add(lblEsTienda);
			
			final JCheckBox cTienda = new JCheckBox("");
			cTienda.setBounds(147, 390, 113, 25);
			add(cTienda);
			
			JButton bCambiar = new JButton("Confirmar");
			bCambiar.addActionListener(new ActionListener() {
				Usuario userActivo=user;
				public void actionPerformed(ActionEvent arg0) {
					if(tUser.getText()!="") {
						userActivo.setNombre(tUser.getText().toString());
						lblNombreUsuario.setText("Nombre: " + tUser.getText().toString());
					}
					if(tPass.getText()!="") {
						userActivo.setPassword(tPass.getText().toString());
						lblPassUsuario.setText("Contrase\\u00F1a: " + tPass.getText().toString());
					}
					if(tMail.getText()!="") {
						userActivo.setNombre(tMail.getText().toString());
						lblEmailUsuario.setText("Email: " + tMail.getText().toString());
					}
					if(cTienda.isSelected()) {
						userActivo.setEsTienda(true);
						lblEsTiendaUsuario.setText("Si");
					}
				}
			});
			bCambiar.setBounds(292, 390, 97, 25);
			add(bCambiar);
		} catch (LoginIncorrectoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
