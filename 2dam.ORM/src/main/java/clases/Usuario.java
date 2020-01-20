package clases;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/***
 * @author Silver (Alejandro)
 * @author Pablo Castellanos
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

import com.mysql.cj.protocol.Resultset;

public class Usuario implements Comparable<Usuario>{
	private String nombre;
	private String password;
	private String email;
	private float saldo;
	private boolean esTienda;//True si es tienda, False si no lo es.
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
	 * Esta funci�n se encarga de recoger los datos de usuario de la base de datos.
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
	
	/**
	 * Función que guarda todos los usuarios de la base de datos en un TreeSet
	 * @return el TreeSet con todos los usuariops
	 */
	public static TreeSet<Usuario> todosLosUsuarios() {
		Connection conexion=null;
		Statement st=null;
		ArrayList<Usuario> listaUsuarios=new ArrayList<Usuario>(); 
		try {
			conexion=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/nombredb", "2dam", "2dam");
			st=conexion.createStatement();
			
			// ResultSet con todos los usuarios registrados (sin los artículos comprados)
			ResultSet rSetUsuario=st.executeQuery("SELECT * FROM Usuario");
			while (rSetUsuario.next()) {
				listaUsuarios.add(new Usuario(rSetUsuario.getString("nombre"), rSetUsuario.getString("contraseña"), rSetUsuario.getString("email"), rSetUsuario.getFloat("saldo"), rSetUsuario.getBoolean("esTienda"), null));
			}
			
			
			ResultSet rSetArticulosComprados=null;
			ResultSet rSetArticulo=null;
			for (Usuario usuario : listaUsuarios) {
				ArrayList<Articulo> articulos=new ArrayList<Articulo>();
				rSetArticulosComprados=st.executeQuery("SELECT nombreArticulos FROM ArticulosComprados WHERE nombreUsuario='"+usuario.getNombre()+"'");
				while (rSetArticulosComprados.next()) {
					String nombreArticulo=rSetArticulosComprados.getString("nombreArticulos");
					rSetArticulo=st.executeQuery("SELECT * FROM Articulo WHERE nombre='"+nombreArticulo+"'");
					if (rSetArticulo.next()) {
						articulos.add(new Articulo(rSetArticulo.getString("nombre"), rSetArticulo.getFloat("precio"), rSetArticulo.getString("descripcion")));
					}
				}
				usuario.setArticulosComprados(articulos);
			}
			
			rSetUsuario.close();
			rSetArticulosComprados.close();
			rSetArticulo.close();
			st.close();
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Collections.sort(listaUsuarios);
		TreeSet<Usuario> setUsuarios=new TreeSet<Usuario>(listaUsuarios);
		return setUsuarios;
	}

	/**
	 * Función implementada de desde la interfaz 'Comparable'
	 * Se usa para order la lista de usuarios
	 */
	public int compareTo(Usuario u) {
		return this.getNombre().compareTo(u.getNombre());
	}
	
	
}