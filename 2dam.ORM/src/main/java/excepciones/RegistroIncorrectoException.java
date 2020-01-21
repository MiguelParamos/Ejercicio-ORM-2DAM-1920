package excepciones;

/***
 * Esta excepci�n se usa cuando el registro (que hace conexi�n con la base de datos en la funci�n DAO) falla.
 * @author Silver (Ale)
 * @author Pablo
 *
 */
public class RegistroIncorrectoException extends Exception{

	public RegistroIncorrectoException() {
		super("Los datos introducidos para el registro son err�neos o ya coinciden con los ya existentes. Prueba a intentarlo de nuevo.");
	}
}
