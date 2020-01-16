package clases;

import java.util.HashMap;

/**
 * 
 * @author Andrés
 * @author Malkien
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
	
	public void AñadirStock(Articulo articulo,short cantidad) {
		try {
			this.HashMap.replace(articulo,(short) (this.HashMap.get(articulo) + cantidad));
		}catch(Exception e) {//Excepcion personalizada
			
		}
		
	}
	
	
}
