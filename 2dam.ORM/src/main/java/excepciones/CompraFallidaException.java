package excepciones;

public class CompraFallidaException extends Exception{
public CompraFallidaException() {
	super("El saldo del que dispones es menor a la cantidad de artículos que deseas comprar, o has pedido mas articulos de los que hay en stock");
}
	
}
