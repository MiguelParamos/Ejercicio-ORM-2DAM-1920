package excepciones;

/***
 * Esta excepción se usa cuando el login (que hace conexión con la base de datos en la función DAO) falla.
 * @author Silver (Ale)
 * @author Pablo
 *
 */
public class LoginIncorrectoException extends Exception{

	public LoginIncorrectoException() {
		super("Los datos introducidos son incorrectos. Prueba a volver a introducirlos.");
	}
}
