package interfaces;

import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame {
	
	
    private Registro pantallaRegistro;
    private PantallaInicial pantallaInicial;
    private Menu pantallaMenu;
    private NuevoArticulo pantallaNuevoArticulo;
    
    
	public VentanaPrincipal() {
		pantallaInicial= new PantallaInicial();
		pantallaMenu=new Menu(this,null);//En el sitio de null irá el usuario introducido
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
		   this.setTitle("pantallaInicial");
		   this.setContentPane(this.pantallaInicial);
		   this.pantallaInicial.setVisible(true);
		   
	   }
	  
	  public void irAMenu() {
		  if(this.pantallaNuevoArticulo!=null) {
			   this.pantallaNuevoArticulo.setVisible(false);
		   }
		   this.setTitle("pantallaMenu");
		   this.setContentPane(this.pantallaMenu);
		   this.pantallaMenu.setVisible(true);
	  }
	  
	  public void irARegistro() {
		  
	  }
}
