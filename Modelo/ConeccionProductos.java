package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.mysql.jdbc.PreparedStatement;

public class ConeccionProductos {
	private int idProducto;
	private String nombre;
	private float precio;
	private String codigo;
	private int stock;
	private String imagen;
	private int TipoProducto_idTipoProducto;
	//public int idTipoProducto;
	private Coneccion conexion=new Coneccion();
	private PreparedStatement ps;
	private ResultSet rs;
	
	
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public int getTipoProducto_idTipoProducto() {
		return TipoProducto_idTipoProducto;
	}
	public void setTipoProducto_idTipoProducto(int tipoProducto_idTipoProducto) {
		TipoProducto_idTipoProducto = tipoProducto_idTipoProducto;
	}
	@Override
	public String toString() {
		return this.nombre;
	}
	
	public Vector<ConeccionProductos> mostrarProductos(){
		
		ps=null;
		rs=null;
		Vector<ConeccionProductos> vectorproductos=new Vector<ConeccionProductos>();
		ConeccionProductos productos=null;
		
		productos=new ConeccionProductos();
		productos.setIdProducto(-1);
		productos.setNombre("Seleccione Producto");
		vectorproductos.add(productos);
		
		productos=new ConeccionProductos();
		productos.setIdProducto(0);
		productos.setNombre("Nuevo Producto....");
		vectorproductos.add(productos);
		
		try {
			ps=(PreparedStatement) conexion.getConexion().prepareStatement("select idProducto,nombre,precio,codigo,stock from producto where TipoProducto_idTipoProducto=?");
			ps.setInt(1, getTipoProducto_idTipoProducto());
			rs=ps.executeQuery();
			while(rs.next()) {
				productos=new ConeccionProductos();
				productos.setIdProducto(rs.getInt(1));
				productos.setNombre(rs.getString(2));
				productos.setPrecio(rs.getFloat(3));
				productos.setCodigo(rs.getString(4));
				productos.setStock(rs.getInt(5));
				vectorproductos.add(productos);
			}
		} catch (SQLException e) {
			System.out.println("Error al establecer PRODUCTOS");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
			
			} catch (SQLException e) {/*ignored*/}
		
		}
		
		return vectorproductos;
	};
	
}
