package excepciones;

public class ArticuloNoExisteException extends Exception {
	
	public ArticuloNoExisteException() {
		super("El articulo que has introducido no existe.");
	}
}
