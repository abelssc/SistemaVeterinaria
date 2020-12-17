package Modelo;

import java.io.File;
import java.io.FileInputStream;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

public class GuardarProductos {
	Coneccion conexion=new Coneccion();
	PreparedStatement ps;
	public GuardarProductos(String nombre,float precio,String codigo,int stock,File imagen,int categoria) {
		ps=null;
		FileInputStream imagenbinario=null;
		try {
			ps=(PreparedStatement) conexion.getConexion().prepareStatement("insert into producto (nombre,precio,codigo,stock,imagen,TipoProducto_idTipoProducto) values(?,?,?,?,?,?)");
			ps.setString(1, nombre);
			ps.setFloat(2, precio);
			ps.setString(3, codigo);
			ps.setInt(4, stock);
			imagenbinario=new FileInputStream(imagen);
			ps.setBinaryStream(5, imagenbinario, (int) imagen.length());
			ps.setInt(6, categoria);
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "PRODUCTO AÑADIDO");
			ps.close();
		} catch (Exception e) {
			System.out.println("ERROR AL GUARDAR PRODUCTO");
			e.printStackTrace();
		}
		
		
		
	}
	
	
}
