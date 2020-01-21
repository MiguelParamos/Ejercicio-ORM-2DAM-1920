package excepciones;

/***
 * Esta excepción se usa cuando el registro (que hace conexión con la base de datos en la función DAO) falla.
 * @author Silver (Ale)
 * @author Pablo
 *
 */
public class RegistroIncorrectoException extends Exception{

	public RegistroIncorrectoException() {
		super("Los datos introducidos para el registro son erróneos o ya coinciden con los ya existentes. Prueba a intentarlo de nuevo.");
	}
}
