package clases;
/***
 * @author Silver (Alejandro)
 * @author Pablo Castellanos
 */
import java.util.ArrayList;

public class Usuario {
	private String nombre;
	private String password;
	private String email;
	private float saldo;
	private boolean esTienda;
	private ArrayList<Articulo> articulosComprados;
	
	
	public Usuario(String nombre, String password, String email, float saldo, boolean esTienda,
			ArrayList<Articulo> articulosComprados) {
		super();
		this.nombre = nombre;
		this.password = password;
		this.email = email;
		this.saldo = saldo;
		this.esTienda = esTienda;
		this.articulosComprados = articulosComprados;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getPassword() {
		return password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public float getSaldo() {
		return saldo;
	}


	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}


	public boolean isEsTienda() {
		return esTienda;
	}


	public void setEsTienda(boolean esTienda) {
		this.esTienda = esTienda;
	}


	public ArrayList<Articulo> getArticulosComprados() {
		return articulosComprados;
	}


	public void setArticulosComprados(ArrayList<Articulo> articulosComprados) {
		this.articulosComprados = articulosComprados;
	}
	
	
	
}