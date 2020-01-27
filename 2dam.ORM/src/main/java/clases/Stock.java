package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import excepciones.ArticuloNoInsertadoException;
import excepciones.RegistroIncorrectoException;
import excepciones.StockNoModificadoException;

/**
 * Clase del Stock
 * @author Andr�s
 * @author Malkien
 */
public class Stock {
	//CUANDO VEAS ESTO HAY QUE CREAR UNA CLASE CON LAS CONSTANTES
	private final String baseDatos = "jdbc:mysql://85.214.120.213:3306/2dam";//LA BBDD
	private final String usuario = "2dam";//EL USUARIO
	private final String contraseña = "2dam";//LA CONTRASE�A
	private HashMap<Articulo, Short> HashMap=new HashMap<Articulo, Short>();//El HashMap con los Articulos y su Stock
	/**
	 * Constructor de la clase Stock
	 * @author Malkien
	 * @param HashMap con clave del tipo Articulo y valores del tipo cantidad
	 * @throws ArticuloNoInsertadoException 
	 */
	public Stock() {
		super();
		
		//CONEXI�N CON BASE DE DATOS, CREACI�N DE STATEMENT Y RESULTSET
		Connection conexion = null;
		
		try {
			conexion = DriverManager.getConnection(baseDatos,usuario,contraseña);
			Statement statement = conexion.createStatement();
			ResultSet articulosBD=statement.executeQuery("SELECT * FROM Articulo");
			while(articulosBD.next()) {//RECORRO TODOS LOS ARTICULOS DE LA BBDD, SUPONGO QUE HAY TANTOS ARTICULOS EN LA TABLA COMO EN LA TABLA DE STOCK 
				
				Articulo articulo = new Articulo(
						articulosBD.getString("nombre")
						);
				
				ResultSet stockBD = statement.executeQuery("SELECT cantidad FROM Stock WHERE nombre_Articulo='"+articulo.getArtName()+"'");
				stockBD.next();//OBVIO QUE SOLO HAY UNO
				
				HashMap.put(articulo, stockBD.getShort("cantidad"));//A�ADO AL HASHMAP EL ARTICULO Y LA CANTIDAD
				stockBD.close();
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	 * Funcion que a�ade la cantidad que le damos m�s la que tiene un articulo en el stock tanto en la bbdd como en el programa
	 * @author Malkien
	 * @param articulo el articulo al que le vas a a�adir el stock
	 * @param cantidad la cantidad que le vas a a�adir
	 * @throws StockNoModificadoException 
	 */
	public void añadirStock(Articulo articulo,short cantidad) throws StockNoModificadoException {
		
		Short total = (short) (this.HashMap.get(articulo)+cantidad);//Calcula la nueva cantidad que habra en el stock
		modificarStock(articulo,total);//Le pasamos la suma de la cantidad que tiene con la que le a�adimos
		
	}
	/**
	 * Funcion que machaca la cantidad que tiene un articulo en el stock tanto en la bbdd como en el programa
	 * @param articulo el articulo al que vas a modificar el stock
	 * @param cantidad la cantidad que le queremos poner
	 * @throws StockNoModificadoException
	 */
	public void setStock(Articulo articulo, Short cantidad) throws StockNoModificadoException {
		modificarStock(articulo,cantidad);//Le pasamos la cantidad que tendr� ahora
	}
	/**
	 * Funcion para modificar el stock a la bbdd y al HashMap
	 * @author Malkien
	 * @param articulo el articulo al que le vas a modificar el stock
	 * @param cantidad la cantidad que tendra ahora
	 * @throws StockNoModificadoException 
	 */
	private void modificarStock(Articulo articulo, Short cantidad) throws StockNoModificadoException {
		if(cantidad == HashMap.get(articulo)) {
			throw new StockNoModificadoException();//Excepcion personalizada
		}
		Connection conexion = null;
		try {
			conexion = DriverManager.getConnection(baseDatos,usuario,contraseña);
			Statement modificarEnBD = conexion.createStatement();
			//Actualiza el stock en la bbdd
			modificarEnBD.executeUpdate("Update Stock SET cantidad="+cantidad+" WHERE nombre_Articulo='"+articulo.getArtName()+"'");
			//Actualiza el stock en el HashMap
			this.HashMap.replace(articulo, cantidad);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/***
	 * M�todo que resta cantidad de stock al art�culo seleccionado
	 * @author Silver (Alejandro)
	 * @author Pablo Castellanos
	 * @throws StockNoModificadoException
	 */
	public void restarStock(Articulo a,short c) throws StockNoModificadoException {
		
		Connection conexion = null;		
		try {
			conexion = DriverManager.getConnection("jdbc:mysql://85.214.120.213:3306/2dam", "2dam", "2dam");
			
			String query = "SELECT * FROM Stock WHERE nombre_Articulo = '"+a.getArtName()+"'";			
			Statement sMent = conexion.createStatement();
			ResultSet rSet = sMent.executeQuery(query);
			
			if(rSet.next()&&rSet.getShort("cantidad")<c) {
				Statement modificarEnBD = conexion.createStatement();
				modificarEnBD.executeUpdate("Update Stock SET cantidad="+(rSet.getShort("cantidad")-c)+" WHERE nombre_Articulo='"+a.getArtName()+"'");
			}else {
				throw new StockNoModificadoException();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
