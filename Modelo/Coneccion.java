package Modelo;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class Coneccion {
	private static final String CONTROLADOR="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost:3306/sistemaveterinaria";
	private static final String USER="root";
	private static final String CLAVE="1234";
	static {
		try {
			Class.forName(CONTROLADOR);
		} catch (ClassNotFoundException e) {
			System.out.println("Error al establecer coneccion");
			e.printStackTrace();
		}
	}
	
	public Connection getConexion() {
		Connection conexion=null;
		try {
			conexion=(Connection) DriverManager.getConnection(URL,USER,CLAVE);
		} catch (SQLException e) {
			System.out.println("Error al establecer conexion");
			e.printStackTrace();
		}
		return conexion;
		
		
	}
}
