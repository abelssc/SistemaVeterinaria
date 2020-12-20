package ModeloVentas;

import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import Modelo.Coneccion;

public class ActualizarStock {
	Coneccion conexion=new Coneccion();
	PreparedStatement ps;
	
	public ActualizarStock(int stock,int idproducto) {
		ps=null;
		try {
			ps=(PreparedStatement) conexion.getConexion().prepareStatement("update producto set stock=? where idProducto=?");
			ps.setInt(1, stock);
			ps.setInt(2, idproducto);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("ERROR AL ACTUALIZAR STOCK");
			e.printStackTrace();
		}
	}
}
