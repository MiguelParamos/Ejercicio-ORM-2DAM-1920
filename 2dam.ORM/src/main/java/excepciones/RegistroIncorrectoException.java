package excepciones;

public class RegistroIncorrectoException extends Exception{

	public RegistroIncorrectoException(String msg) {
		super("Los datos introducidos para el registro son err�neos o ya coinciden con los ya existentes. Prueba a intentarlo de nuevo.");
	}
}
