package interfaces;
/**
 * @author Ivan Diaz
 * @author Jose Maria Osuna
 * @author Alfredo Molina
 * @author Antonio Martinez
 */

import javax.swing.*;
import javax.swing.border.LineBorder;

import clases.Usuario;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import excepciones.RegistroIncorrectoException;
import java.awt.event.ActionEvent;

public class Registro extends JPanel {
	private VentanaPrincipal ventana;
	private Usuario usuario;
	
	public Registro(VentanaPrincipal v) {
		ventana=v;
		setBackground(new Color(91, 157, 195));
		setSize(500,500);
		setLayout(null);
		
		//JLabel utilizados como etiquetas.
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(124, 109, 72, 19);
		lblNombre.setFont(new Font("Dialog", Font.BOLD, 16));
		add(lblNombre);
		
		JLabel lblPassword = new JLabel("Contrase\u00F1a:");
		lblPassword.setBounds(96, 136, 93, 19);
		lblPassword.setFont(new Font("Dialog", Font.BOLD, 16));
		add(lblPassword);
		
		JLabel lblRepetirPassword = new JLabel("Repetir Contrase\u00F1a:");
		lblRepetirPassword.setFont(new Font("Dialog", Font.BOLD, 16));
		lblRepetirPassword.setBounds(37, 163, 154, 19);
		add(lblRepetirPassword);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(143, 189, 54, 19);
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 16));
		add(lblEmail);
		
		JLabel lblRepetirEmail = new JLabel("Repetir Email:");
		lblRepetirEmail.setFont(new Font("Dialog", Font.BOLD, 16));
		lblRepetirEmail.setBounds(85, 217, 109, 19);
		add(lblRepetirEmail);
		
		//TextField para rellenar los campos de Nombre, Password y Email.
		final JTextField textFieldNombre = new JTextField();
		textFieldNombre.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNombre.setBounds(199, 111, 154, 19);
		add(textFieldNombre);
		
		final JPasswordField textFieldPassword = new JPasswordField();
		textFieldPassword.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldPassword.setEchoChar('*');
		textFieldPassword.setBounds(199, 138, 154, 19);
		add(textFieldPassword);
		
		final JPasswordField textFieldRepetirPassword = new JPasswordField();
		textFieldRepetirPassword.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldRepetirPassword.setEchoChar('*');
		textFieldRepetirPassword.setBounds(199, 165, 154, 19);
		add(textFieldRepetirPassword);

		final JTextField textFieldEmail = new JTextField();
		textFieldEmail.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldEmail.setBounds(199, 191, 154, 19);
		add(textFieldEmail);
		
		final JTextField textFieldRepetirEmail = new JTextField();
		textFieldRepetirEmail.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldRepetirEmail.setBounds(199, 218, 154, 19);
		add(textFieldRepetirEmail);
		
		//Checkbox para indicar si el usuario se registra como tienda o no.
		final JCheckBox checkboxTienda = new JCheckBox("\u00BFTienda?");
		checkboxTienda.setBackground(new Color(91, 157, 195));
		checkboxTienda.setHorizontalAlignment(SwingConstants.CENTER);
		checkboxTienda.setBounds(201, 255, 116, 21);
		checkboxTienda.setFont(new Font("Dialog", Font.BOLD, 12));
		add(checkboxTienda);
		
		//Boton para registrar un nuevo usuario.
		JButton btnRegistrar = new JButton("Registro");
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegistrar.setBounds(173, 303, 166, 28);
		add(btnRegistrar);
		
		//Boton para ir a la pagina principal.
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAtras.setBounds(173, 342, 166, 28);
		add(btnAtras);
		
		/**
		 * Evento Boton Registrar
		 * Se comprueba que los campos de texto no estan vacios, de lo contrario la variable error pasa a 1 y cambiara el color del campo a rojo, 
		 * si esto ocurre el programa no seguira con el registro. Si todos los campos son rellenados correctamente se comprueba
		 * que Email/RepetirEmail y Password/RepetirPassword coinciden para terminar con el proceso de registro.
		 */
		btnRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				int error = 0; 
				String usuario = textFieldNombre.getText();
				String password = String.valueOf(textFieldPassword.getPassword());
				String passwordRepetido = String.valueOf(textFieldRepetirPassword.getPassword());
				String email = textFieldEmail.getText();
				String emailRepetido = textFieldRepetirEmail.getText();
				
				if(usuario.isEmpty()) {
					textFieldNombre.setBorder(new LineBorder(Color.red,2));
					error = 1;
				}
				
				if(password.isEmpty()) {
					textFieldPassword.setBorder(new LineBorder(Color.red,2));
					error = 1;
				}
				
				if(passwordRepetido.isEmpty()) {
					textFieldRepetirPassword.setBorder(new LineBorder(Color.red,2));
					error = 1;
				}
				
				if(email.isEmpty()) {
					textFieldEmail.setBorder(new LineBorder(Color.red,2));
					error = 1;
				}
				
				if(emailRepetido.isEmpty()) {
					textFieldRepetirEmail.setBorder(new LineBorder(Color.red,2));
					error = 1;
				}
				
				if(error!=1) {
					if(password.equals(passwordRepetido)) {
						if(email.equals(emailRepetido)) {
							if(checkboxTienda.isSelected()) {
								try {
									Usuario nuevoUsuario = new Usuario(usuario, password, email, 0, true, null);
									JOptionPane.showMessageDialog(null, "Tienda creada");
									ventana.setUsuarioRegistrado(nuevoUsuario);
									ventana.irAMenu();
								} catch (RegistroIncorrectoException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}else {
								try {
									Usuario nuevoUsuario = new Usuario(usuario, password, email, 0, false, null);
									JOptionPane.showMessageDialog(null, "Usuario creado");
									ventana.irAMenu();
								} catch (RegistroIncorrectoException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						}else {
							JOptionPane.showMessageDialog(null, "Ambos email no coinciden");
						}
					}else {
						JOptionPane.showMessageDialog(null, "Ambas contraseñas no coinciden");
					}
				}else {
					JOptionPane.showMessageDialog(null, "Por favor no deje datos sin rellenar");
				}
			}
		});
		//Boton Atras
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
                ventana.irAPantallaInicial();
			}
		});
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
}
