package clases;

import java.util.HashMap;

/**
 * 
 * @author Andrés
 *
 */
public class Stock {

	private HashMap<Articulo, Short> HashMap=new HashMap<Articulo, Short>();

	/**
	 * Constructor de la clase Stock
	 * @param HashMap con clave del tipo Articulo y valores del tipo cantidad
	 */
	public Stock(HashMap<Articulo, Short> HashMap) {
		super();
		this.HashMap = HashMap;
	}

	/**
	 * @return the HashMap
	 */
	public HashMap<Articulo, Short> getHashMap() {
		return HashMap;
	}

	/**
	 * @param HashMap the HashMap to set
	 */
	public void setHashMap(HashMap<Articulo, Short> HashMap) {
		this.HashMap = HashMap;
	}
	
	
}
