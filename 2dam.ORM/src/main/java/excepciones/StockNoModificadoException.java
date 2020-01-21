package excepciones;

public class StockNoModificadoException extends Exception{
	public StockNoModificadoException() {
		super("NO SE HA PODIDO MODIFICAR EL STOCK COMPRUEBE QUE EXISTE EL ARTICULO Y PONGASE EN CONTACTO CON EL ADMINISTRADOR DE LA BBDD");
	}
}
