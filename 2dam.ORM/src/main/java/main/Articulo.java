package main;

/*
 * @Author Juan Miguel 
 *
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
}
