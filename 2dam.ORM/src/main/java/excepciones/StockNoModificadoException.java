package excepciones;
/**
 * Clase Con la Excepcion si da error al modificar el stock :C
 * @author Malkien
 *
 */
public class StockNoModificadoException extends Exception{
	
	public StockNoModificadoException() {
		super("NO SE HA PODIDO MODIFICAR EL STOCK COMPRUEBE QUE EXISTE EL ARTICULO Y PONGASE EN CONTACTO CON EL ADMINISTRADOR DE LA BBDD");
	}
	
}
