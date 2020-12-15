package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class ConeccionNCodigo {
	Coneccion conexion=new Coneccion();
	PreparedStatement ps;
	ResultSet rs;
	
	public int generarCodigo() {
		int codigo=0;
		ps=null;
		rs=null;
		
		try {
			ps=(PreparedStatement) conexion.getConexion().prepareStatement("select count(idProducto) from producto");
			rs=ps.executeQuery();
			if(rs.next())codigo=rs.getInt(1)+1;
			
		} catch (SQLException e) {
			System.out.println("Error al generar CODIGO");
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				rs.close();
				
			} catch (SQLException e) {/*ignored*/}
		}
		return codigo;
	}

	
}
