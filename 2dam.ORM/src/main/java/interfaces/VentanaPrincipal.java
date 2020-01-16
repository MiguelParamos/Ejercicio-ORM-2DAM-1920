package interfaces;

import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame {
    private Registro pantallaRegistro;
    private PantallaInicial pantallaInicial;
	public VentanaPrincipal() {
		pantallaInicial= new PantallaInicial();
		this.setSize(500,500);
		this.setTitle("Tienda Cenec");
		this.setVisible(true);
		irAPantallaInicial();
	}
	 
	//Esta función nos sirve para movernos a la pantalla inicial
	  public void irAPantallaInicial(){
		   if(this.pantallaRegistro!=null) {
			   this.pantallaRegistro.setVisible(false);
		   }
		   this.setTitle("pantallaMenu");
		   this.setContentPane(this.pantallaInicial);
		   this.pantallaInicial.setVisible(true);
		   
	   }
	  
	  public void irAMenu() {
		  
	  }
	  
	  public void irARegistro() {
		  
	  }
}
