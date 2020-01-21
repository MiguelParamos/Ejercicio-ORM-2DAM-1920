package main;

import java.sql.SQLException;

import interfaces.VentanaPrincipal;

public final class Main {

	public static void main(String[] args) {
		try {
			VentanaPrincipal ventanaPrincipal=new VentanaPrincipal();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
