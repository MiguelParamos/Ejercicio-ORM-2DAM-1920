package excepciones;

/***
 * Esta excepci�n se usa cuando el login (que hace conexi�n con la base de datos en la funci�n DAO) falla.
 * @author Silver (Ale)
 * @author Pablo
 *
 */
public class LoginIncorrectoException extends Exception{

	public LoginIncorrectoException() {
		super("Los datos introducidos son incorrectos. Prueba a volver a introducirlos.");
	}
}
