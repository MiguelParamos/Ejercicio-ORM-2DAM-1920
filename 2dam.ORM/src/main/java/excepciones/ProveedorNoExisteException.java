package excepciones;

public class ProveedorNoExisteException extends Exception{

	public ProveedorNoExisteException() {
		super("El proveedor introducido no existe.");
	}
}
