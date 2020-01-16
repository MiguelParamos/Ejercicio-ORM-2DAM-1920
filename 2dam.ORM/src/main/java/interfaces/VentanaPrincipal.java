package interfaces;

import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame {
    private Registro pantallaRegistro;
    //private Inicio pantallaInicio;
	public VentanaPrincipal() {
		this.setSize(500,500);
		this.setTitle("Tienda Cenec");
		this.setVisible(true);
	}
	  /*public void irPantallaInicio(){
		   if(this.pantallaInicio==null) {
			   this.pantallaInicio=new Inicio(this,null);
		   }
		   this.setTitle("pantallaLogin");
		   this.pantallaRegistro.setVisible(false);
		   this.setContentPane(this.pantallaInicio);
		   this.pantallaInicio.setVisible(true);
		   
	   }*/
}
