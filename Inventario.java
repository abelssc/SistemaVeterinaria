import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import Modelo.Coneccion;
import ModeloInventario.ImgInventario;
import ModeloInventario.MostrarImagen;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.CompoundBorder;


public class Inventario extends JPanel {
	private JTable table;
	private Coneccion conexion=new Coneccion();
	PreparedStatement ps;
	ResultSet rs;

	/**
	 * Create the panel.
	 */
	public Inventario() {
		setBounds(320,20,1260,760);
		setOpaque(false);
		setLayout(null);
		
		JLabel lblInventario = new JLabel("Inventario");
		lblInventario.setForeground(Color.WHITE);
		lblInventario.setFont(new Font("JetBrainsMono Nerd Font Mono", Font.PLAIN, 30));
		lblInventario.setBounds(30, 30, 500, 30);
		add(lblInventario);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 100, 800, 620);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		scrollPane.getViewport().setBorder(null);
		add(scrollPane);
		
		JPanel panel_imagen = new JPanel();
		panel_imagen.setBorder(new CompoundBorder(new LineBorder(new Color(128, 128, 128), 5, true), null));
		panel_imagen.setBounds(840, 100, 410, 410);
		add(panel_imagen);
		/////////////////////////////////////////////////////////TABLE AND DEFAULT TABLE
		DefaultTableModel modelotabla= new DefaultTableModel();
		String titulos[]= {"Categoria","Nombre","Codigo","Precio Unitario","Stock","Imagen"};
		for(String e:titulos)modelotabla.addColumn(e);
		
		
		
		ps=null;
		rs=null;
		try {
			ps=(PreparedStatement) conexion.getConexion().prepareStatement("select nombreTipoProducto,nombre,codigo,precio,stock from producto left join tipoproducto"
					+ " on tipoproducto.idTipoProducto=producto.TipoProducto_idTipoProducto order by nombreTipoProducto,precio");
			rs=ps.executeQuery();
			while(rs.next()) {
				String categoria=rs.getString(1);
				String nombre=rs.getString(2);
				String codigo=rs.getString(3);
				Float precio=rs.getFloat(4);
				int stock=rs.getInt(5);
				JLabel imagen=new JLabel(new ImageIcon(getClass().getResource("/imagenes/search.png")));
				modelotabla.addRow(new Object[] {categoria,nombre,codigo,precio,stock,imagen});
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
			System.out.println("ERROR AL MOSTRAR INVENTARIO");
			e.printStackTrace();
		}
		table = new JTable(modelotabla) {
			@Override
			public boolean isCellEditable(int row, int column) {
				if(column==5) {
					
					panel_imagen.removeAll();
					ps=null;
					rs=null;
					String codigo=(String) table.getValueAt(row, 2);
					try {
						ps=(PreparedStatement) conexion.getConexion().prepareStatement("select imagen from producto where codigo=?");
						ps.setString(1, codigo);
						rs=ps.executeQuery();
						if(rs.next()) {
							InputStream binaryimg=rs.getBinaryStream(1);
							BufferedImage compacimg=ImageIO.read(binaryimg);
							int ancho=panel_imagen.getWidth();
							int alto=panel_imagen.getHeight();
							MostrarImagen pintar=new MostrarImagen(ancho,alto,compacimg);
							panel_imagen.add(pintar);
							panel_imagen.repaint();
						}
						ps.close();
						rs.close();
					} catch (Exception e) {
						System.out.println("ERROR AL BUSCAR IMAGEN");
						e.printStackTrace();
					}
					return true;
				}
				else return false;
			}
		};
		table.setSelectionBackground(Color.LIGHT_GRAY);
		table.setDefaultRenderer(Object.class, new ImgInventario());
		table.setRowHeight(30);
		table.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 35));
		table.getTableHeader().setFont(new Font("JetBrainsMono Nerd Font Mono", Font.PLAIN, 14));
		table.getTableHeader().setBackground(new Color(255,99,71));
		
		table.setOpaque(false);//-------------------------------------------------------------edit PONER OPAQUE FALSE Y LUEGO PINTAR , ESTO ARREGLA EL BUG DE SOBREPINTADO
		table.setBackground(new Color(0,true));
		
		table.setForeground(Color.WHITE);
		scrollPane.setViewportView(table);
		
		
	}
}
