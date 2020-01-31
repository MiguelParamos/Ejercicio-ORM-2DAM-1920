package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TreeSet;
import excepciones.ArticuloNoExisteException;
import excepciones.ArticuloNoInsertadoException;

/*
 * Esta clase modela Articulo
 * @Author Juan Miguel 
 * @Author Alvarop627
 * @Author Juan Carlos
 * @Author Javier Rodr�guez
 */

public class Articulo {
	// INTERNAL VAR
	private String artName;// Nombre de los articulos
	private float artPrice;// Precio de los articulos
	private String artDesc;// Descripcion de los articulos.
	private String proveedor;
	Connection conexion = null;
	
	

	// CONSTRUCTOR
	/**
	 * Constructor articulo
	 * @param artName  Nombre de los articulos que recibe de variable interna.
	 * @param artPrice Precio de los articulos que recibe de variable interna.
	 * @param artDesc  Descripcion de los articulos que recibe de variable interna.
	 * @throws ArticuloNoInsertadoException 
	 */
	public Articulo(String artName, float artPrice, String artDesc,Proveedor proveedor) throws ArticuloNoInsertadoException {
		super();
		try {
			insert(artName,artPrice,artDesc,proveedor);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Articulo(String artName) {

	
		try {
			buscarUnArticulo(artName);
		} catch (ArticuloNoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/***
	 * Funcion que se encarga de recorrer los articulos en la base da datos
	 * obteniendo nombre, precio y descripcion.
	 * @author Juan Miguel
	 * @return Devuelve los datos de los articulos existentes en la BD
	 * @throws ArticuloNoExisteException como resultado de un articulo inexistente.
	 */
	public void buscarUnArticulo(String artName) throws ArticuloNoExisteException {
		try {
			//TODO cambiar la conexion al servidor
			String cons = "SELECT * FROM Articulo WHERE nombre = '" + artName + "'";
			conexion = DriverManager.getConnection("jdbc:mysql://85.214.120.213:3306/2dam", "2dam", "2dam");
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery(cons);

			if (rs.next()) {
				this.artName = rs.getString("nombre");
				this.artPrice = rs.getFloat("precio");
				this.artDesc = rs.getString("descripcion");
				this.proveedor=rs.getString("nombreProveedor");
			}else {
				throw new ArticuloNoExisteException();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	// GETTERS AND SETTERS
	public String getArtName() {
		return artName;
	}

	public void setArtName(String artName){
		try {
			try {
				update(artName,this.getArtPrice(),this.getArtDesc());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ArticuloNoInsertadoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public float getArtPrice() {
		return artPrice;
	}

	public void setArtPrice(float artPrice) {
		try {
			try {
				update(this.getArtName(),artPrice,this.getArtDesc());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ArticuloNoInsertadoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getArtDesc() {
		return artDesc;
	}

	public void setArtDesc(String artDesc) {
		try {
			try {
				update(this.getArtName(),this.getArtPrice(),artDesc);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ArticuloNoInsertadoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * FUNCION QUE CARGA LOS ARTICULOS DE BASE DE DATO A UN TREESET
	 * @param todosLosArticulos pasamos el TreeSet de articulos que contienen todos los articulos que agregamos posteriormente.
	 * @author Javier Rodriguez.
	 * @author Juan Carlos.
	 * @throws ArticuloNoInsertadoException 
	 */
	public static TreeSet<Articulo> todosLosArticulos() {
		// INICIALIZACI�N DE VARIABLES
		Connection conexion = null;
		TreeSet<Articulo> articuloTS = null;
		try {
			// CONEXI�N CON BASE DE DATOS, CREACI�N DE STATEMENT Y RESULTSET
			conexion = DriverManager.getConnection("jdbc:mysql://85.214.120.213:3306/2dam", "2dam", "2dam");
			Statement articuloStatement = conexion.createStatement();
			ResultSet articulosBD = articuloStatement.executeQuery("SELECT nombre FROM Articulo");

			// RECORRE TODOS LOS ARTICULOS DE LA BASE DE DATOS, METIENDOLOS EN EL TREESET
			while (articulosBD.next()) {
			

				articuloTS.add(new Articulo(articulosBD.getString("nombre")));
			}
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return articuloTS;
	}
	
	/***
	 * Funcion que se encarga de crear un nuevo articulo a partir de parametros.
	 * @author Alvarop627
	 * @throws ArticuloNoInsertadoException como resultado de un articulo que no se puede crear.
	 * @throws SQLException 
	 */
	public void insert(String artName, float artPrice, String artDesc, Proveedor proveedor) throws ArticuloNoInsertadoException, SQLException {
		
		final String INSERT = "INSERT INTO Articulo(nombre,precio,descripcion) VALUES(?,?,?)";
		conexion=DriverManager.getConnection("jdbc:mysql://85.214.120.213:3306/2dam", "2dam", "2dam");
		PreparedStatement pstm = conexion.prepareStatement(INSERT);
		try {
			try {
				
				pstm.setString(1, artName);
				pstm.setFloat(2, artPrice);
				pstm.setString(3, artDesc);
				if(pstm.executeUpdate()==0) {
					throw new ArticuloNoInsertadoException();
				}
			}finally {
				pstm.close();
			}
		} catch (SQLException e) {
			throw new ArticuloNoInsertadoException();
		}
	}
	
	/***
	 * Funcion que se encarga de actualizar los datos de un art�culo.
	 * @author Alvarop627
	 * @throws ArticuloNoInsertadoException como resultado de un articulo que no se ha podido modificar.
	 * @throws SQLException 
	 */
	public void update(String nombre, float precio, String desc) throws ArticuloNoInsertadoException, SQLException {
		
		
		final String UPDATE = "UPDATE Articulo SET precio = ?, descripcion = ? WHERE nombre = ?";
		conexion=DriverManager.getConnection("jdbc:mysql://85.214.120.213:3306/2dam", "2dam", "2dam");
		PreparedStatement pstm = conexion.prepareStatement(UPDATE);
		try {
			try {
				pstm = conexion.prepareStatement(UPDATE);
				pstm.setString(1, nombre);
				pstm.setFloat(2, precio);
				pstm.setString(3, desc);
				if(pstm.executeUpdate()==0) {
					throw new ArticuloNoInsertadoException();
				}
			}catch (SQLException e) {
				throw new ArticuloNoInsertadoException();
			}
		}finally {
				try {
					pstm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} 
		
	}

