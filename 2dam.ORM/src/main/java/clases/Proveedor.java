package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import excepciones.LoginIncorrectoException;
import excepciones.ProveedorNoExisteException;
import excepciones.RegistroIncorrectoException;

/***
 * Constructor con todos los datos del proveedor para su registro en la base de datos.
 * @author Pepe Exp�sito
 * @throws RegistroIncorrectoException
 */

public class Proveedor {

	private String nombre;
	private String nombreCiudad;
	private ArrayList <Articulo>articulosEnVenta;
	private Connection conn;
	
	public Proveedor(String nombre, String nombreCiudad, ArrayList<Articulo> articulosEnVenta) throws RegistroIncorrectoException {
		super();
		this.nombre = nombre;
		this.nombreCiudad = nombreCiudad;
		this.articulosEnVenta = articulosEnVenta;
		registraProveedor(nombre, nombreCiudad, articulosEnVenta);
	}
	
	public Proveedor(String nombre) {
		super();
		this.nombre = nombre;
		try {
			buscaProveedor(nombre);
		} catch (ProveedorNoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		try {
			actualizar(nombre, this.getNombreCiudad());
		} catch (ProveedorNoExisteException e) {
			e.printStackTrace();
		}
	}

	public String getNombreCiudad() {
		return nombreCiudad;
	}

	public void setNombreCiudad(String nombreCiudad) {
		try {
			actualizar(this.getNombre(), nombreCiudad);
		} catch (ProveedorNoExisteException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Articulo> getArticulosEnVenta() {
		return articulosEnVenta;
	}

	public void setArticulosEnVenta(ArrayList<Articulo> articulosEnVenta) {
		this.articulosEnVenta = articulosEnVenta;
	}
	
	/***
	 * Funci�n que registra al Proveedor en base de datos con su nombre y el nombre de la ciudad
	 * @param nom : nombre del proveedor
	 * @param nomCiu: ciudad del proveedor
	 * @param av: articulos en venta del proveedor
	 * @throws RegistroIncorrectoException
	 */
	
	private void registraProveedor(String nom, String nomCiu, ArrayList <Articulo> av) throws RegistroIncorrectoException {
		
		try {
			conn=DriverManager.getConnection("jdbc:mysql://85.214.120.213:3306/2dam", "2dam", "2dam");
			PreparedStatement pSment = conn.prepareStatement("INSERT into Proveedores VALUES (?,?,?)");
			
			String query = "SELECT * FROM Proveedores WHERE nombre = '"+nom+"'";			
			Statement sMent = conn.createStatement();
			ResultSet rSet = sMent.executeQuery(query);
			
			if(rSet.next()) {
				throw new RegistroIncorrectoException();
			}else {
				pSment.setString(1,nombre);
				pSment.setString(2,nombreCiudad);
				
				pSment.execute();
				
			}	
						
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	/***
	 * Funci�n que busca en la base de datos un proveedor y sus atributos a partir del nombre proporcionado para la b�squeda
	 * @author Pepe Exposito
	 * @param nombre: nombre del proveedor que se quiere consultar en la base de datos
	 * @throws ProveedorNoExisteException
	 */
	
	private void buscaProveedor(String nombre) throws ProveedorNoExisteException {
		
		// Creacion de conexiones y statements
		Statement st = null;
		ResultSet rSetProveedor = null;
		String nombreBD;
		String ciudadBD;
		ArrayList <Articulo> articulosEnVenta = null;
		
					try {
						conn=DriverManager.getConnection("jdbc:mysql://85.214.120.213:3306/2dam", "2dam", "2dam");
						
						st=conn.createStatement();
						
						// Recoge los datos de los proveedores registrados (sin Articulos en venta)
						rSetProveedor=st.executeQuery("SELECT * FROM Proveedores WHERE nombre = '"+nombre+"'");
						
						if(rSetProveedor.next()) {
							this.nombre = rSetProveedor.getString("nombre");
							this.nombreCiudad = rSetProveedor.getString("ciudad");
							
						}
	
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						
						try {
							if (rSetProveedor!=null) {
								rSetProveedor.close();
							}
							if (st!=null) {
								st.close();
							}							
							if (conn!=null) {
								conn.close();
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					
	}
	
	/***
	 * Funci�n que actualiza la base de datos con los cambios que se produzcan en los atributos del proveedor, usada para
	 * persistir en los setters de la clase.
	 * @author Pepe Exposito
	 * @param nombreBD
	 * @param ciudadBD
	 * @throws LoginIncorrectoException
	 */
	
	public void actualizar(String nombreBD, String ciudadBD) throws ProveedorNoExisteException {
		
		try {
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://85.214.120.213:3306/2dam", "2dam", "2dam");
		PreparedStatement pStatement = conn.prepareStatement("UPDATE Proveedores SET nombre = ?, ciudad = ?, email = ?, articuloNombre, = ? WHERE nombre = ?");
		
		
			pStatement = conn.prepareStatement("UPDATE Proveedores SET nombre = ?, contrase�a = ?, email = ?, saldo, = ?, esTienda = ? WHERE nombre = ?");
			pStatement.setString(1, nombreBD);
			pStatement.setString(2, ciudadBD);
			
			if(pStatement.executeUpdate() == 0) {
				throw new ProveedorNoExisteException();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
