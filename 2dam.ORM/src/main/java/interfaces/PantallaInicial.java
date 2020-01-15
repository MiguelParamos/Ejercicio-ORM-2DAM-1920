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

public class PantallaInicial extends JFrame {

	private JPanel contentPane;
	private JTextField tfUsuario;
	private JLabel lblNewLabel_1;
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
	public JFrame getFrame() {
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
						    "¡Hola!" ,
						    "¡Bienvenido!",
						    JOptionPane.PLAIN_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(getFrame(),
						    "Usuario o contraseña incorrectos" ,
						    "Error!",
						    JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnInicio.setBounds(161, 153, 118, 21);
		contentPane.add(btnInicio);
		
		tfUsuario = new JTextField();
		tfUsuario.setBounds(161, 88, 118, 19);
		contentPane.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(90, 91, 61, 13);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Contrase\u00F1a");
		lblNewLabel_1.setBounds(90, 120, 61, 13);
		contentPane.add(lblNewLabel_1);
		
		pfPass = new JPasswordField();
		pfPass.setBounds(161, 124, 118, 19);
		contentPane.add(pfPass);
	}
}
