package interfaces;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VerMisArticulos extends JPanel{
	public VerMisArticulos() {
		setSize(new Dimension(500, 500));
		setLayout(null);
		
		//LISTA DE ARTICULOS
		JList listaArticulos = new JList();
		listaArticulos.setBounds(135, 54, 233, 282);
		listaArticulos.setModel(new AbstractListModel() {
			String[] values = new String[] {"Articulo1", "Articulo2", "Articulo3"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		add(listaArticulos);
		
		//BOTÓN VER ARTICULOS
		JButton btnVerArticulos = new JButton("Ver art\u00EDculos");
		btnVerArticulos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnVerArticulos.setBounds(201, 347, 108, 23);
		add(btnVerArticulos);
		
		//BOTÓN ATRÁS
		JButton btnAtras = new JButton("Atr\u00E1s");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnAtras.setBounds(49, 425, 89, 23);
		add(btnAtras);
		
	}
}
