package interfaces;

import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame {
    private Registro pantallaRegistro;
    private Menu pantallaMenu;
	public VentanaPrincipal() {
		pantallaMenu= new Menu(this,null);
		this.setSize(500,500);
		this.setTitle("Tienda Cenec");
		this.setVisible(true);
	}
	 
	//Esta función nos sirve para movernos a la pantalla inicial
	  public void irPantallaMenu(){
		   if(this.pantallaRegistro!=null) {
			   this.pantallaRegistro.setVisible(false);
		   }
		   this.setTitle("pantallaMenu");
		   this.setContentPane(this.pantallaMenu);
		   this.pantallaMenu.setVisible(true);
		   
	   }
	  
	  public void irAMenu() {
		  
	  }
	  
	  public void irARegistro() {
		  
	  }
}
