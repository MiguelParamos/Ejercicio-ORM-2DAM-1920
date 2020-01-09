package componentes;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import java.awt.SystemColor;

public class BotonMenu  extends JButton {
	
	public BotonMenu(String txt) {
		
		super(txt);
		
		this.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		this.setBounds(480, 480, 180, 50);
		this.setHorizontalTextPosition(SwingConstants.CENTER);
		this.setForeground(new Color(0, 0, 0));
		this.setFont(new Font("Malgun Gothic", Font.PLAIN, 22));
		this.setBackground(SystemColor.activeCaption);
		
	}
	
}
