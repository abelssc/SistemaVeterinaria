package ModeloVentas;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.mysql.jdbc.PreparedStatement;

import Modelo.Coneccion;

public class GenerarVenta {
	///////////////tiposdeDatos
	private String numComprobante;
	private int cantidadcomprobantes=0;
	private int idventa;
	private int idTipoComprobante;
	//////////////fecha
	LocalDateTime ahora= LocalDateTime.now();
	int año=ahora.getYear();
	int mes=ahora.getMonthValue();
	int dia=ahora.getDayOfMonth();
	int hora=ahora.getHour();
	int minuto=ahora.getMinute();
	int segundo=ahora.getSecond();
	/////////////////coneccion
	Coneccion conexion=new Coneccion();
	PreparedStatement ps;
	ResultSet rs;
	////////////////getters
	public int getIdVenta() {
		return idventa;
	}
	
	public GenerarVenta(int idcliente,String tipocomprobante,float subtotal,float igv,float total) {
		ps=null;
		rs=null;
		
		try {
			ps=(PreparedStatement) conexion.getConexion().prepareStatement("select count(idBoleta) from boleta union all select count(idFactura) from factura");
			rs=ps.executeQuery();
			while(rs.next()) {
				cantidadcomprobantes+=rs.getInt(1);
			}
			cantidadcomprobantes++;
			numComprobante="0000"+cantidadcomprobantes;
			//----------------------------------------------INSERT VENTA----------------------------------------------------------------------
			ps=null;
			rs=null;
			ps=(PreparedStatement) conexion.getConexion().prepareStatement("insert into Venta (numeroComprobante,fechaEmitida,horaEmitida,Empleado_idEmpleado,Cliente_idCliente) values(?,?,?,?,?)");
			ps.setString(1, numComprobante);
			ps.setString(2,año+"-"+mes+"-"+dia);
			ps.setString(3, hora+":"+minuto+":"+segundo);
			ps.setInt(4, 1);
			ps.setInt(5, idcliente);
			ps.executeUpdate();
			//------------------------------------------------SELECT IDVENTA------------------------------------------------------------------------
			ps=null;
			rs=null;
			ps=(PreparedStatement) conexion.getConexion().prepareStatement("select max(idVenta) from Venta");
			rs=ps.executeQuery();
			if(rs.next())idventa=rs.getInt(1);
			//-------------------------------------------------INSERT TIPOCOMPROBANTE----------------------------------------------------------------
			ps=null;
			rs=null;
			ps=(PreparedStatement) conexion.getConexion().prepareStatement("insert into TipoComprobante (nombreTipoComprobante,Venta_idVenta) values(?,?)");
			ps.setString(1, tipocomprobante);
			ps.setInt(2, idventa);
			ps.executeUpdate();
			//------------------------------------------------SELECT IDTIPOCOMPROBANTE----------------------------------------------------------------
			ps=null;
			rs=null;
			ps=(PreparedStatement) conexion.getConexion().prepareStatement("select  idTipoComprobante from TipoComprobante where Venta_idVenta=?");
			ps.setInt(1, idventa);
			rs=ps.executeQuery();
			if(rs.next())idTipoComprobante=rs.getInt(1);
			//-------------------------------------------------INSERT BOLETA/FACTURA----------------------------------------------------------------
			ps=null;
			rs=null;
			if(tipocomprobante.equals("Boleta")) {
				ps=(PreparedStatement) conexion.getConexion().prepareStatement("insert into Boleta (precioTotal,TipoComprobante_idTipoComprobante) values(?,?)");
				ps.setFloat(1, total);
				ps.setInt(2,idTipoComprobante);
				ps.executeUpdate();
			}else if(tipocomprobante.equals("Factura")) {
				ps=(PreparedStatement) conexion.getConexion().prepareStatement("insert into Factura (subTotal,IGV,precioTotal,TipoComprobante_idTipoComprobante) values(?,?,?,?)");
				ps.setFloat(1, subtotal);
				ps.setFloat(2, igv);
				ps.setFloat(3, total);
				ps.setInt(4,idTipoComprobante);
				ps.executeUpdate();
			}
			//-------------------------------------------------INSERT PRODUCTO HAS VENTA----------------------------------------------------------------
			//ps=(PreparedStatement) conexion.getConexion().prepareStatement("insert into Producto_has_Venta (Producto_idProducto,Venta_idVenta,unidades,importe) values(?,?,?,?)");
			

			
		} catch (SQLException e) {
			System.out.println("ERROR AL GENERAR VENTA");
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
