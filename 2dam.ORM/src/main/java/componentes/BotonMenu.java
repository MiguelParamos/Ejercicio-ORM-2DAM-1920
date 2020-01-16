package componentes;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import java.awt.SystemColor;

/**
 * Boton personalizado para la aplicacion. Hereda de JButton. 
 * @author Sara Pedrosa
 * @author Alvaro de Francisco
 */
public class BotonMenu extends JButton {
	
	/**
	 * Constructor de BotonMenu.
	 * @param txt El mensaje informativo que contiene el boton por dentro.
	 */
	public BotonMenu(String txt) {
		
		super(txt);
		
		this.setForeground(new Color(0, 0, 0));
		this.setFont(new Font("Malgun Gothic", Font.PLAIN, 14));
		this.setBackground(SystemColor.activeCaption);
		
	}
	
}
