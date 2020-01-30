package interfaces;

import java.util.ArrayList;

import javax.swing.JPanel;
import clases.Proveedor;
import clases.Usuario;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class VerTodosLosProveedores extends JPanel {
	private VentanaPrincipal v;
	private Usuario usuario;
	private ArrayList<Proveedor> arrayProveedores;
	/**
	 * Create the panel.
	 */
	public VerTodosLosProveedores(VentanaPrincipal v) {
		this.v=v;
		this.arrayProveedores=new ArrayList<Proveedor>(Proveedor.todosLosProveedores());
		initComponents();
	}
	private void initComponents() {
		setLayout(null);
		
		
		
		DefaultListModel<String> listModel=new DefaultListModel<String>();
		for (Proveedor proveedor : arrayProveedores) {
			listModel.addElement("Nombre: "+proveedor.getNombre()+" - Ciudad: "+proveedor.getNombreCiudad());
		}
		
		final JList list = new JList(listModel);
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(10, 40, 430, 130);
		add(scrollPane);
		this.setVisible(true);
	}
}
