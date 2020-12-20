package modeloVentasGeneradas;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import Modelo.Coneccion;

public class MostrarVentasGeneradas {
	/*----------------------------------------PROPIERDADES-----------------------------------------------------------------*/

	private String numerocomprobante;
	private String fechaemitida;
	private String horaemitida;
	private String nombrecliente;
	private String dniruc;
	private String tipocliente;
	private String direccion;
	private String categoria;
	private String producto;
	private int unidades;
	private String comprobante;
	private float importe;
	

	
	/*----------------------------------------CONECCIONES---------------------------------------------------------------*/
	Coneccion conexion=new Coneccion();
	PreparedStatement ps;
	ResultSet rs;
	/*----------------------------------------END CONECCIONES---------------------------------------------------------------*/

	public MostrarVentasGeneradas(DefaultTableModel modelotabla) {
		ps=null;
		rs=null;
		try {
			ps=(PreparedStatement) conexion.getConexion().prepareStatement("select numeroComprobante,fechaEmitida,horaEmitida,concat_ws(\" \",clientenatural.nombres,clientejuridico.nombreEmpresa) NombreCliente,\r\n" + 
					"concat_ws(\"\",dni,clientejuridico.RUC) dniRuc,nombreTipoCliente,direccion,tipoproducto.nombreTipoProducto,producto.nombre,unidades,\r\n" + 
					"tipocomprobante.nombreTipoComprobante,importe from Venta \r\n" + 
					"inner join cliente\r\n" + 
					"on venta.Cliente_idCliente=cliente.idCliente\r\n" + 
					"inner join tipocliente\r\n" + 
					"on tipocliente.idTipoCliente=cliente.TipoCliente_idTipoCliente\r\n" + 
					"left join clientenatural\r\n" + 
					"on tipocliente.idTipoCliente=clientenatural.TipoCliente_idTipoCliente\r\n" + 
					"left join clientejuridico\r\n" + 
					"on tipocliente.idTipoCliente=clientejuridico.TipoCliente_idTipoCliente\r\n" + 
					"left join producto_has_venta\r\n" + 
					"on venta.idVenta=producto_has_venta.Venta_idVenta\r\n" + 
					"left join producto\r\n" + 
					"on producto_has_venta.Producto_idProducto=producto.idProducto\r\n" + 
					"left join tipoproducto\r\n" + 
					"on producto.TipoProducto_idTipoProducto=tipoproducto.idTipoProducto\r\n" + 
					"left join tipocomprobante\r\n" + 
					"on venta.idVenta=tipocomprobante.Venta_idVenta");
			rs=ps.executeQuery();
			while(rs.next()) {
				numerocomprobante=rs.getString(1);
				fechaemitida=rs.getString(2);
				horaemitida=rs.getString(3);
				nombrecliente="<html><body>"+rs.getString(4)+"</body></html>";
				dniruc=rs.getString(5);
				tipocliente="<html><body>"+rs.getString(6)+"</body></html>";
				direccion="<html><body>"+rs.getString(7)+"</body></html>";
				categoria=rs.getString(8);
				producto="<html><body>"+rs.getString(9)+"</body></html>";
				unidades=rs.getInt(10);
				comprobante=rs.getString(11);
				importe=rs.getFloat(12);
				
				modelotabla.addRow(new Object[] {numerocomprobante,fechaemitida,horaemitida,nombrecliente,dniruc,tipocliente,direccion,categoria,producto,unidades,comprobante,importe});
				
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
			System.out.println("ERROR AL ADQUIRIR LAS VENTAS GENERADAS");
			e.printStackTrace();
		}	
	}
}
