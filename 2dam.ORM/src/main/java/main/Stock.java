package main;
/**
 * 
 * @author Andrés
 *
 */
public class Stock {

	private Hashmap<Articulo, cantidad> hashmap=new Hashmap<Articulo, cantidad>();

	/**
	 * Constructor de la clase Stock
	 * @param hashmap con clave del tipo Articulo y valores del tipo cantidad
	 */
	public Stock(Hashmap<Articulo, cantidad> hashmap) {
		super();
		this.hashmap = hashmap;
	}

	/**
	 * @return the hashmap
	 */
	public Hashmap<Articulo, cantidad> getHashmap() {
		return hashmap;
	}

	/**
	 * @param hashmap the hashmap to set
	 */
	public void setHashmap(Hashmap<Articulo, cantidad> hashmap) {
		this.hashmap = hashmap;
	}
	
	
}
