package interfaces;

import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame {
    private Registro pantallaRegistro;
    private PantallaInicial pantallaInicial;
	public VentanaPrincipal() {
		this.setSize(500,500);
		this.setTitle("Tienda Cenec");
		this.setVisible(true);
	}
	  public void irPantallaInicial(){
		   if(this.pantallaInicial==null) {
			   this.pantallaInicial=new PantallaInicial();
		   }
		   this.setTitle("pantallaInicial");
		   this.pantallaRegistro.setVisible(false);
		   this.setContentPane(this.pantallaInicial);
		   this.pantallaInicial.setVisible(true);
		   
	   }
	  
	  public void irAMenu() {
		  
	  }
	  
	  public void irARegistro() {
		  
	  }
}
