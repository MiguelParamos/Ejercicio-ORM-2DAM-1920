package interfaces;

import javax.swing.JPanel;

import main.Usuario;

import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;

public class Comprar extends JPanel {
	
	private Usuario user;
	private VentanaPrincipal ventana;
	
	public Comprar(Usuario user, VentanaPrincipal ventana) {
		this.user=user;
		this.ventana=ventana;
	}
	
	public Comprar() {
		setLayout(null);
		
		JList listaComprar = new JList();
		listaComprar.setBounds(10, 36, 419, 253);
		add(listaComprar);
		
		JLabel lblComprar = new JLabel("COMPRAR");
		lblComprar.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		lblComprar.setBounds(10, 11, 117, 23);
		add(lblComprar);
	}
}
