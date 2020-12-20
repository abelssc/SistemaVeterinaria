package ModeloVentas;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import Modelo.Coneccion;

public class Producto_has_Venta {
	Coneccion conexion=new Coneccion();
	PreparedStatement ps;
	ResultSet rs;
	public Producto_has_Venta(int idProducto,int idVenta,int unidades,float importe) {
		ps=null;
		try {
			ps=(PreparedStatement) conexion.getConexion().prepareStatement("insert into Producto_has_Venta (Producto_idProducto,Venta_idVenta,unidades,importe) values(?,?,?,?)");
			ps.setInt(1, idProducto);
			ps.setInt(2, idVenta);
			ps.setInt(3, unidades);
			ps.setFloat(4, importe);
			ps.executeUpdate();
			
			ps.close();
		} catch (SQLException e) {
			System.out.println("Error al generar VENTA-PRODUCTO");
			e.printStackTrace();
		}
		
	}
}
