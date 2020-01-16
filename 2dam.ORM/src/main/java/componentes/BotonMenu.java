package componentes;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import java.awt.SystemColor;

public class BotonMenu extends JButton {
	
	public BotonMenu(String txt) {
		
		super(txt);
		
		this.setForeground(new Color(0, 0, 0));
		this.setFont(new Font("Malgun Gothic", Font.PLAIN, 14));
		this.setBackground(SystemColor.activeCaption);
		
	}
	
}
