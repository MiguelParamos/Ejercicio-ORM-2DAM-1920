package clases;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/***
 * @author Silver (Alejandro)
 * @author Pablo Castellanos
 */
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Statement;

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
	
	/***
	 * Esta función se encarga de recoger los datos de usuario de la base de datos.
	 * @param datos -> Los datos del usuario que se van a consultar en la base de datos.
	 * @return -> Los datos del usuario de la base de datos.
	 */
	public String funcionDAOString(String datos) {
		
		Connection conexion = null;
		try {
			conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/nombredb", "2dam", "2dam");
			
			PreparedStatement consultaStatement = conexion.prepareStatement("SELECT '"+datos+"' FROM Usuario");
			
			Resultset rSet = (Resultset) consultaStatement.executeQuery();
			
			datos=rSet.toString();
			
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return datos;
		
	}
	
	
}