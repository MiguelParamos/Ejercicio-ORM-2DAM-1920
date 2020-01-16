package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaInicial extends JPanel {

	private JTextField tfUsuario;
	private JLabel lblPass;
	private JPasswordField pfPass;
	private JButton btnInicio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaInicial frame = new PantallaInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
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
	

	/**
	 * Create the frame.
	 */
	public PantallaInicial() {

		setSize(500,500);
		setLayout(null);
		
		tfUsuario = new JTextField();
		tfUsuario.setBounds(190, 215, 96, 19);
		this.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		btnInicio = new JButton("Iniciar Sesion");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = getTfUsuario().getText();
				String pass = getPfPass().getText();
				if(user.equals("")||(pass.equals(""))) {
					JOptionPane.showMessageDialog(getFrame(),
						    "Rellene todos los campos" ,
						    "Error!",
						    JOptionPane.WARNING_MESSAGE);
				}
				else if((user=="WilergioVargarado")&&(pass=="CheekyBreeky")){
					JOptionPane.showMessageDialog(getFrame(),
						    "�Hola!" ,
						    "�Bienvenido!",
						    JOptionPane.PLAIN_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(getFrame(),
						    "Usuario o contrase�a incorrectos" ,
						    "Error!",
						    JOptionPane.WARNING_MESSAGE);
				}
			}
		});
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
	}
}