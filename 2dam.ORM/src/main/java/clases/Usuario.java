package clases;
import java.sql.Connection;
import java.sql.DriverManager;
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

import excepciones.LoginIncorrectoException;

public class Usuario implements Comparable<Usuario>{
	private String nombre;
	private String password;
	private String email;
	private float saldo;
	private boolean esTienda;//True si es tienda, False si no lo es.
	private ArrayList<Articulo> articulosComprados;
	Connection conexion = null;
	
	
	public Usuario(String nombre, String password, String email, float saldo, boolean esTienda,
			ArrayList<Articulo> articulosComprados) throws SQLException {
		super();
		setNombre(nombre);
		setPassword(password);
		setEmail(email);
		setSaldo(saldo);
		setEsTienda(esTienda);
		setArticulosComprados(articulosComprados);
	}

	public Usuario(String nombre, String password) throws LoginIncorrectoException {
		super();
		comprobarLogin(nombre, password);
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
	 * @throws LoginIncorrectoException 
	 */
	public void comprobarLogin(String nombre, String contrasenia) throws LoginIncorrectoException {
		
		try {
			conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/nombredb", "2dam", "2dam");
			
			String query = "SELECT * FROM Usuario WHERE nombre = '"+nombre+"' AND contrase�a = '"+contrasenia+"'";			
			Statement sMent = conexion.createStatement();
			ResultSet rSet = sMent.executeQuery(query);
			
			while(rSet.next()) {
				this.nombre= rSet.getString("nombre");
				this.email= rSet.getString("email");
				this.password= rSet.getString("contrase�a");
				this.saldo=rSet.getFloat("saldo");
				this.esTienda=rSet.getBoolean("esTienda");
			}			
		}catch (Exception e) {
			throw new LoginIncorrectoException();
		}finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Función que devuelve todos los datos de los usuarios registrados en la base de datos
	 * Devuelve un TreeSet para evitar duplicidad
	 * @return Set con los datos de los usuarios
	 * @author Darash
	 */
	public static TreeSet<Usuario> todosLosUsuarios() {
		Connection conexion=null;
		Statement st=null;
		ResultSet rSetUsuarios=null;
		ResultSet rSetArticulos=null;
		ResultSet rsDatosArticulos=null;
		ArrayList<Usuario> listaUsuarios=new ArrayList<Usuario>();
		try {
			// Creacion de conexiones y statements
			conexion=DriverManager.getConnection("jdbc:mysql://85.214.120.213:3306/2dam", "2dam", "2dam");
			st=conexion.createStatement();
			
			// Recoge los datos de todos los usuarios registrados (sin Artículos comprados)
			rSetUsuarios=st.executeQuery("SELECT * FROM Usuario");
			while (rSetUsuarios.next()) {
				listaUsuarios.add(new Usuario(rSetUsuarios.getString("nombre"), rSetUsuarios.getString("contraseña"), rSetUsuarios.getString("email"), rSetUsuarios.getFloat("saldo"), rSetUsuarios.getBoolean("esTienda"), null));
			}
			rSetUsuarios.close();
			
			// Recoge los datos de los artículos comprados por el usuario 
			for (Usuario usuario : listaUsuarios) {
				ArrayList<Articulo> listaArticulos=new ArrayList<Articulo>();
				rSetArticulos=st.executeQuery("SELECT nombreArticulos FROM ArticulosComprados WHERE nombreUsuario='"+usuario.getNombre()+"'");
				while (rSetArticulos.next()) {
					listaArticulos.add(new Articulo(rSetArticulos.getString("nombreArticulos"), 0, null));
				}
				rSetArticulos.close();
				
				for (Articulo art : listaArticulos) {
					rsDatosArticulos=st.executeQuery("SELECT * FROM Articulo WHERE nombre='"+art.getArtName()+"'");
					while (rsDatosArticulos.next()) {
						art.setArtPrice(rsDatosArticulos.getFloat("precio"));
						art.setArtDesc(rsDatosArticulos.getString("descripcion"));
					}
					rsDatosArticulos.close();
				}
				usuario.setArticulosComprados(listaArticulos); // Una vez obtenido todos los datos del articulo, se le mete al objeto Usuario
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			// Cierre de todos los ResultSets, Statements y Conexiones
			try {
				if (rsDatosArticulos!=null) {
					rsDatosArticulos.close();
				}
				if (rSetArticulos!=null) {
					rSetArticulos.close();
				}
				if (rSetUsuarios!=null) {
					rSetUsuarios.close();
				}
				if (st!=null) {
					st.close();
				}
				if (conexion!=null) {
					conexion.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		Collections.sort(listaUsuarios); // Ordenación de la lista usando la interfaz Comparable (compareTo)
		TreeSet<Usuario> setUsuarios=new TreeSet<Usuario>(listaUsuarios); // Se crea un nuevo TreeSet a partir del ArrayList
		
		return setUsuarios;
	}

	/**
	 * Función que va comparando nombres de usuario para el ordenamiento. Usa la interfaz Comparabale
	 * Nota: A la hora de ordenar tiene mayor prioridad nombres que empiezan por mayúsculas. 
	 * @author Darash
	 */
	public int compareTo(Usuario u) {
		return this.nombre.compareTo(u.getNombre());
	}
	
	
}
