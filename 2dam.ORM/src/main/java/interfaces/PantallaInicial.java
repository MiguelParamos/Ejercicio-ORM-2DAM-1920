package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Usuario;
import excepciones.LoginIncorrectoException;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaInicial extends JPanel {

	private JTextField tfUsuario;
	private JLabel lblPass;
	private JPasswordField pfPass;
	private JButton btnInicio;
	private VentanaPrincipal v;
	private Usuario usuario;
	

	/**
	 * Create the frame.
	 */
	public PantallaInicial(VentanaPrincipal v) {
		super();
		this.v=v;
		setSize(500,500);
		setLayout(null);
		
		tfUsuario = new JTextField();
		tfUsuario.setBounds(190, 215, 96, 19);
		this.add(tfUsuario);
		tfUsuario.setColumns(10);
		btnInicio = new JButton("Iniciar Sesion");
		btnInicio.setBounds(173, 301, 131, 21);
		this.add(btnInicio);
		
		JLabel lblUser = new JLabel("Usuario");
		lblUser.setBounds(103, 216, 77, 16);
		this.add(lblUser);
		
		lblPass = new JLabel("Contrase\u00F1a");
		lblPass.setBounds(103, 260, 77, 13);
		this.add(lblPass);
		
		pfPass = new JPasswordField();
		pfPass.setBounds(190, 257, 96, 19);
		this.add(pfPass);
		
		JButton btnRegistro = new JButton("Registro");
		btnRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.irARegistro();
			}
		});
		btnRegistro.setBounds(190, 333, 89, 23);
		add(btnRegistro);
		
		// ActionListnener del boton de inicio de sesion
		btnInicio.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String userLogin = getTfUsuario().getText();
				String passLogin = String.valueOf(getPfPass().getPassword());
				try
				{
					usuario = new Usuario(userLogin, passLogin);
					v.setUsu(usuario);
					v.setUsuarioRegistrado(usuario);
					irAMenu();
				} catch (LoginIncorrectoException e1)
				{
					showLoginError();
					e1.printStackTrace();
				}
			}
		
		});
	}
	
	// Funciones que tienen que ir fuera del action listener, ya que V no puede ser final
	private void irAMenu(){
		v.setUsu(usuario);
		v.irAMenu();
	}
	
	private void showLoginError() {
		JOptionPane.showMessageDialog(v, "No ha sido posible iniciar sesion.", "Error de login", JOptionPane.ERROR_MESSAGE);
	}
	
	// Getters Setters
	public JPanel getFrame() {
		return this;
	}
	
	public JTextField getTfUsuario() {
		return tfUsuario;
	}

	public void setTfUsuario(JTextField tfUsuario) {
		this.tfUsuario = tfUsuario;
	}

	public JPasswordField getPfPass() {
		return pfPass;
	}

	public void setPfPass(JPasswordField pfPass) {
		this.pfPass = pfPass;
	}

	public Usuario getUsuario()
	{
		return usuario;
	}

	public void setUsuario(Usuario usuario)
	{
		this.usuario = usuario;
	}
}
