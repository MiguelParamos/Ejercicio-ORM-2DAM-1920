package interfaces;
/**
 * @author Ivan Diaz
 * @author Jose Maria Osuna
 */

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import clases.Articulo;

import javax.swing.JButton;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

public class NuevoArticulo extends JPanel{
	private JTextField textFieldNombre, textFieldPrecio;
	private JTextArea textFieldDescripcion;

	public NuevoArticulo(VentanaPrincipal v) {

		setBackground(Color.decode("#5b9dc3"));
		setSize(500,500);
		setLayout(null);

		//JLabel utilizados como etiquetas.
		JLabel lblCabecera = new JLabel("Nuevo Articulo");
		lblCabecera.setHorizontalAlignment(SwingConstants.CENTER);
		lblCabecera.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCabecera.setBounds(102, 41, 270, 37);
		add(lblCabecera);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(125, 108, 81, 14);
		add(lblNombre);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrecio.setBounds(139, 145, 58, 14);
		add(lblPrecio);

		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDescripcion.setBounds(102, 186, 91, 14);
		add(lblDescripcion);

		//TextField para rellenar los campos de Nombre, precio y descripcion del articulo.
		//Precio y descripcion usan DocumentFilter
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(194, 106, 178, 20);
		add(textFieldNombre);
		textFieldNombre.setColumns(10);

		textFieldPrecio = new JTextField();
		DocumentFilter filter = new UppercaseDocumentFilter();
		((AbstractDocument) textFieldPrecio.getDocument()).setDocumentFilter(filter);
		textFieldPrecio.setBounds(194, 144, 178, 20);
		add(textFieldPrecio);
		textFieldPrecio.setColumns(10);

		textFieldDescripcion = new JTextArea();
		textFieldDescripcion.setDocument(new JTextFieldLimit());
		textFieldDescripcion.setLineWrap(true);
		textFieldDescripcion.setBounds(194, 186, 178, 90);
		add(textFieldDescripcion);
		textFieldDescripcion.setColumns(10);

		//Boton para introducir nuevo articulo.
		JButton btnIntroducir = new JButton("Introducir");
		btnIntroducir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnIntroducir.setBounds(179, 320, 166, 37);
		add(btnIntroducir);

		//Boton para salir.
		JButton btnAtras = new JButton("Atras");
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAtras.setBounds(179, 367, 166, 37);
		add(btnAtras);

		/**
		 * Evento Boton Introducir
		 * Se comprueba que los campos de texto no estan vacios, de lo contrario la variable error pasa a 1 y cambiara el color del campo a rojo,
		 * si esto ocurre el programa no seguira con el ingreso del nuevo articulo.
		 */
		btnIntroducir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int error = 0;
				if(textFieldNombre.getText().isEmpty()) {
					textFieldNombre.setBorder(new LineBorder(Color.red,2));
					error = 1;
				}

				if(textFieldPrecio.getText().isEmpty()) {
					textFieldPrecio.setBorder(new LineBorder(Color.red,2));
					error = 1;
				}

				if(textFieldDescripcion.getText().isEmpty()) {
					textFieldDescripcion.setBorder(new LineBorder(Color.red,2));
					error = 1;
				}

				if(error!=1) {
					//Crea el nuevo articulo.
					Articulo articulo=new Articulo(textFieldNombre.getText(), Float.parseFloat(textFieldPrecio.getText()), textFieldDescripcion.getText());

					//Limpia los campos de texto para facilitar la ayuda a un nuevo articulo y devuelve el color original del campo.
					textFieldNombre.setText("");
					textFieldNombre.setBorder(new LineBorder(Color.white,1));
					try {
						textFieldPrecio.getDocument().remove(0, textFieldPrecio.getText().length());
					} catch (BadLocationException e) {
						e.printStackTrace();
					}
					textFieldPrecio.setBorder(new LineBorder(Color.white,1));
					textFieldDescripcion.setText("");
					textFieldDescripcion.setBorder(new LineBorder(Color.white,1));
					JOptionPane.showMessageDialog(null, "�Articulo introducido!");
				}else{
					JOptionPane.showMessageDialog(null, "Por favor no deje datos sin rellenar");
				}
				//ventana.irAMenu();
			}
		});

		/**
		 * Evento Boton Atras
		 */
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//ventana.irAMenu();
			}
		});
	}

	/**
	 * Limitamos el numero maximo de caracteres por linea y en total del JTextField, lo usamos para el campo descripcion.
	 * El numero *120* indica el maximo permitido.
	 */
	public class JTextFieldLimit extends PlainDocument {
		public void insertString(int offset, String  str, AttributeSet attr) throws BadLocationException {
			if (str == null) return;
	    	if ((getLength() + str.length()) <= 120){
	    		super.insertString(offset, str, attr);
	    	}
	    }
    }

	/**
	 * Limita el uso de cualquier caracter que no sea numerico en el campo precio.
	 */
	public class UppercaseDocumentFilter extends DocumentFilter {
		public void replace(DocumentFilter.FilterBypass fb, int offset, int length,String text, javax.swing.text.AttributeSet attr) throws BadLocationException {
			fb.insertString(offset, text.replaceAll("[^0-9.]", ""), attr);
		}
	}
}
