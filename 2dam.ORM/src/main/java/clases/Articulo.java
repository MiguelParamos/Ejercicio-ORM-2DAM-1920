package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeSet;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Statement;

/*
 * @Author Juan Miguel 
 * @Author Juan Carlos & Javier Rodriguez
 */

public class Articulo {
	//INTERNAL VAR
	private String artName;
	private float artPrice;
	private String artDesc;
	
	//CONSTRUCTOR
	public Articulo(String artName, float artPrice, String artDesc) {
		super();
		this.artName = artName;
		this.artPrice = artPrice;
		this.artDesc = artDesc;
	}
	
	//GETTERS AND SETTERS
	public String getArtName() {
		return artName;
	}
	public void setArtName(String artName) {
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
	
	//FUNCION QUE CARGA LOS ARTICULOS DE BASE DE DATO A UN TREESET
	public static void cargarArticulos(TreeSet<Articulo> todosLosArticulos) {
		//INICIALIZACIÓN DE VARIABLES
		Connection conexion = null;
		TreeSet<Articulo> articuloTS = null;
		try {
			//CONEXIÓN CON BASE DE DATOS, CREACIÓN DE STATEMENT Y RESULTSET
			conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/nombredb", "2dam", "2dam");
			java.sql.Statement articuloStatement = conexion.createStatement();
			ResultSet articulosBD=articuloStatement.executeQuery("SELECT * FROM Articulo");
			
			//RECORRE TODOS LOS ARTICULOS DE LA BASE DE DATOS, METIENDOLOS EN UN TREESET
			while(articulosBD.next()) {
				String nombre= articulosBD.getString("nombre");
				Float precio= articulosBD.getFloat("precio");
				String descripcion= articulosBD.getString("descripcion");
				
				Articulo articulo= new Articulo(nombre, precio, descripcion);
				articuloTS.add(articulo);
			}
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
