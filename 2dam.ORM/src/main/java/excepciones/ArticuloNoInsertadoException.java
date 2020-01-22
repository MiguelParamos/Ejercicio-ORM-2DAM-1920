package excepciones;

public class ArticuloNoInsertadoException extends Exception {
	
	public ArticuloNoInsertadoException() {
		super("El articulo no se ha podido insertar con éxito. Prueba a intentarlo de nuevo o ponte en contacto con el administrador.");
	}
}
