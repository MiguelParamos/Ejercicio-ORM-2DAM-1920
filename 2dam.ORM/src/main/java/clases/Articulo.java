package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TreeSet;
import excepciones.ArticuloNoExisteException;

/*
 * Esta clase modela Articulo
 * @Author Juan Miguel 
 * @Author Juan Carlos
 * @Author Javier Rodríguez
 */

public class Articulo {
	// INTERNAL VAR
	private String artName;// Nombre de los articulos
	private float artPrice;// Precio de los articulos
	private String artDesc;// Descripcion de los articulos.
	private Connection conexion = null;

	// CONSTRUCTOR
	/**
	 * Constructor articulo
	 * @param artName  Nombre de los articulos que recibe de variable interna.
	 * @param artPrice Precio de los articulos que recibe de variable interna.
	 * @param artDesc  Descripcion de los articulos que recibe de variable interna.
	 */
	public Articulo(String artName, float artPrice, String artDesc) {
		super();
		this.artName = artName;
		this.artPrice = artPrice;
		this.artDesc = artDesc;
		//TODO Abrir conexion, persistir, cerrar conexion
	}

	public Articulo(String artName) {

		//TODO Abrir conexion, consultar, coger los datos de BD, cerrar conexion
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
			conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/nombredb", "2dam", "2dam");
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery(cons);

			if (rs.next()) {
				this.artName = rs.getString("nombre");
				this.artPrice = rs.getFloat("precio");
				this.artDesc = rs.getString("descripcion");
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

	public void setArtName(String artName) {
		//Persistir en todos los setters TODO
		this.artName = artName;
	}

	public float getArtPrice() {
		return artPrice;
	}

	public void setArtPrice(float artPrice) {
		this.artPrice = artPrice;
	}

	public String getArtDesc() {
		return artDesc;
	}

	public void setArtDesc(String artDesc) {
		this.artDesc = artDesc;
	}

	/**
	 * FUNCION QUE CARGA LOS ARTICULOS DE BASE DE DATO A UN TREESET
	 * @param todosLosArticulos pasamos el TreeSet de articulos que contienen todos
	 *                          los articulos que agregamos posteriormente.
	 */
	public static void cargarArticulos(TreeSet<Articulo> todosLosArticulos) {
		// INICIALIZACIÓN DE VARIABLES
		Connection conexion = null;
		TreeSet<Articulo> articuloTS = null;
		try {
			// CONEXIÓN CON BASE DE DATOS, CREACIÓN DE STATEMENT Y RESULTSET
			conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/nombredb", "2dam", "2dam");
			Statement articuloStatement = conexion.createStatement();
			ResultSet articulosBD = articuloStatement.executeQuery("SELECT * FROM Articulo");

			// RECORRE TODOS LOS ARTICULOS DE LA BASE DE DATOS, METIENDOLOS EN EL TREESET
			while (articulosBD.next()) {
				String nombre = articulosBD.getString("nombre");
				Float precio = articulosBD.getFloat("precio");
				String descripcion = articulosBD.getString("descripcion");

				Articulo articulo = new Articulo(nombre, precio, descripcion);
				articuloTS.add(articulo);
			}
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
