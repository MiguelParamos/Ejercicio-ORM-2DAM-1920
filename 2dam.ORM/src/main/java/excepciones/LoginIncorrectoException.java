package excepciones;

public class LoginIncorrectoException extends Exception{

	public LoginIncorrectoException(String msg) {
		super("Los datos introducidos son incorrectos. Prueba a volver a introducirlos.");
	}
}
