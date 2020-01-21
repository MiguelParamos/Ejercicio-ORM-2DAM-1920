package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import excepciones.StockNoModificadoException;

/**
 * 
 * @author Andr�s
 * @author Malkien
 */
public class Stock {

	private final String baseDatos = "jdbc:mysql://127.0.0.1:3306/nombredb";
	private final String usuario = "2dam";
	private final String contrase�a = "2dam";
	private HashMap<Articulo, Short> HashMap=new HashMap<Articulo, Short>();
	/**
	 * Constructor de la clase Stock
	 * @author Malkien
	 * @param HashMap con clave del tipo Articulo y valores del tipo cantidad
	 */
	public Stock() {
		super();
		
		//CONEXI�N CON BASE DE DATOS, CREACI�N DE STATEMENT Y RESULTSET
		Connection conexion = null;
		
		try {
			conexion = DriverManager.getConnection(baseDatos,usuario,contrase�a);
			Statement statement = conexion.createStatement();
			ResultSet articulosBD=statement.executeQuery("SELECT * FROM Articulo");
			while(articulosBD.next()) {//RECORRO TODOS LOS ARTICULOS DE LA BBDD, SUPONGO QUE HAY TANTOS ARTICULOS EN LA TABLA COMO EN LA TABLA DE STOCK 
				
				Articulo articulo = new Articulo(
						articulosBD.getString("nombre"),
						articulosBD.getFloat("precio"),
						articulosBD.getString("descripcion")
						);
				ResultSet stockBD = statement.executeQuery("SELECT cantidad FROM Stock");
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
	 * Funcion para a�adir stock a la bbdd
	 * @author Malkien
	 * @param articulo el articulo al que le vas a a�adir el stock
	 * @param cantidad la cantidad que le vas a a�adir
	 * @throws StockNoModificadoException 
	 */
	public void A�adirStock(Articulo articulo,short cantidad) throws StockNoModificadoException {
		try {
			
			this.HashMap.replace(articulo,(short) (this.HashMap.get(articulo) + cantidad));
		}catch(Exception e) {//Excepcion personalizada
			throw new StockNoModificadoException();
		}
		
	}
	
	
}
