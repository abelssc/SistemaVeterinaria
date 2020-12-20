package ModeloVentas;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.mysql.jdbc.PreparedStatement;

import Modelo.Coneccion;

public class InfoCliente {
	private int id;
	private String dniRuc="--";
	private String nombres;
	private String apellidos="";
	private String tipoCliente;
	
	
	public int getId() {
		return id;
	}

	public void setId(int idClienteNatural) {
		this.id = idClienteNatural;
	}

	public String getDniRuc() {
		return dniRuc;
	}

	public void setDniRuc(String dni) {
		this.dniRuc = dni;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente=tipoCliente;
	}
	public String getTipoCliente() {
		return tipoCliente;
	}
	public  String toString() {
		return this.nombres +" "+ this.apellidos;
	}

	Coneccion conexion=new Coneccion();
	PreparedStatement ps;
	ResultSet rs;
	
	public Vector<InfoCliente> obtenerInfo(){
		ps=null;
		rs=null;
		Vector<InfoCliente> vectorclientes=new Vector<InfoCliente>();
		InfoCliente clientes=null;
		clientes=new InfoCliente();
		clientes.setNombres("Seleccione cliente.....");
		vectorclientes.add(clientes);
		
		try {
			ps=(PreparedStatement) conexion.getConexion().prepareStatement("Select idClienteNatural,nombres,apellidos,TipoCliente_idTipoCliente,dni from clientenatural");
			rs=ps.executeQuery();
			while(rs.next()) {
				clientes=new InfoCliente();
				clientes.setId(rs.getInt(1));
				clientes.setNombres(rs.getString(2));
				clientes.setApellidos(rs.getString(3));
				clientes.setTipoCliente(rs.getString(4));
				clientes.setDniRuc(rs.getString(5));
				vectorclientes.add(clientes);
			};
			ps=null;
			rs=null;
			ps=(PreparedStatement) conexion.getConexion().prepareStatement("Select idClienteJuridico,nombreEmpresa,TipoCliente_idTipoCliente,RUC from clientejuridico");
			rs=ps.executeQuery();
			while(rs.next()) {
				clientes=new InfoCliente();
				clientes.setId(rs.getInt(1));
				clientes.setNombres(rs.getString(2));
				clientes.setTipoCliente(rs.getString(3));
				clientes.setDniRuc(rs.getString(4));
				vectorclientes.add(clientes);
			};
			ps.close();
			rs.close();
			
		} catch (SQLException e) {
			System.out.println("Error al ESTABLECER CLIENTES");
			e.printStackTrace();
		}
		
		return vectorclientes;
	}
	
}
