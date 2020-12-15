package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.mysql.jdbc.PreparedStatement;

public class ConeccionCategoria {
	private int idTipoProducto;
	private String nombreTipoProducto;
	public Coneccion conexion=new Coneccion();
	public PreparedStatement ps;
	public ResultSet rs;
	
	public int getIdTipoProducto() {
		return idTipoProducto;
	}
	public void setIdTipoProducto(int idTipoProducto) {
		this.idTipoProducto = idTipoProducto;
	}
	public String getNombreTipoProducto() {
		return nombreTipoProducto;
	}
	public void setNombreTipoProducto(String nombreTipoProducto) {
		this.nombreTipoProducto = nombreTipoProducto;
	}
	@Override
	public String toString() {
		return this.nombreTipoProducto;
	}
	public Vector <ConeccionCategoria> mostrarCategoria(){
		ps=null;
		rs=null;
		Vector<ConeccionCategoria> vectorCategoria=new Vector<ConeccionCategoria>();
		ConeccionCategoria categoria=null;
		
		categoria=new ConeccionCategoria();
		categoria.setIdTipoProducto(0);
		categoria.setNombreTipoProducto("Seleccione categoria");
		vectorCategoria.add(categoria);
		
		try {
			ps=(PreparedStatement) conexion.getConexion().prepareStatement("select idTipoProducto,nombreTipoProducto from tipoproducto");
			rs=ps.executeQuery();
			while(rs.next()) {
				categoria=new ConeccionCategoria();
				categoria.setIdTipoProducto(rs.getInt(1));
				categoria.setNombreTipoProducto(rs.getString(2));
				vectorCategoria.add(categoria);
			}
			
		} catch (SQLException e) {
			System.out.println("Error al establecer CATEGORIA");
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				rs.close();
				
			} catch (SQLException e) {/*ignored*/}
			
		}
		return vectorCategoria;
		
	}
}
