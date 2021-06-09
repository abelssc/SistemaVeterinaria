import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import com.mysql.jdbc.PreparedStatement;

import Modelo.Coneccion;
import ModeloVentas.ImgTabla;
import modeloVentasGeneradas.FormatoTabla;
import modeloVentasGeneradas.MostrarVentasGeneradas;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class VentasGeneradas extends JPanel {
	private JTable table;
	private JLabel lblTotal; 
	
	private Coneccion conexion=new Coneccion();
	private PreparedStatement ps;
	private ResultSet rs;
	/**
	 * Create the panel.
	 */
	public VentasGeneradas() {
		setBounds(320,20,1260,760);
		setOpaque(false);
		setLayout(null);
		
		JLabel lblIngresosTotales = new JLabel("Ingresos Totales");
		lblIngresosTotales.setForeground(Color.WHITE);
		lblIngresosTotales.setFont(new Font("JetBrainsMono Nerd Font Mono", Font.PLAIN, 30));
		lblIngresosTotales.setBounds(30, 30, 390, 30);
		add(lblIngresosTotales);
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(VentasGeneradas.class.getResource("/imagenes/icons8_money_bag_100px.png")));
		lblNewLabel.setBounds(50, 100, 120, 120);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("S/");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBorder(new MatteBorder(1, 1, 1, 0, (Color) Color.WHITE));
		lblNewLabel_1.setBounds(230, 140, 40, 60);
		lblNewLabel_1.setFont(new Font("JetBrainsMono Nerd Font Mono", Font.PLAIN, 30));
		add(lblNewLabel_1);
		
		lblTotal = new JLabel("");
		lblTotal.setForeground(Color.WHITE);
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotal.setBorder(new MatteBorder(1, 0, 1, 1, (Color) Color.WHITE));
		lblTotal.setBounds(270, 140, 150, 60);
		lblTotal.setFont(new Font("JetBrainsMono Nerd Font Mono", Font.PLAIN, 30));
		add(lblTotal);
		dineroTotal();
		
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		JLabel lblVentasGeneradas = new JLabel("Ventas Generadas");
		lblVentasGeneradas.setForeground(Color.WHITE);
		lblVentasGeneradas.setFont(new Font("JetBrainsMono Nerd Font Mono", Font.PLAIN, 25));
		lblVentasGeneradas.setBounds(30, 231, 300, 30);
		add(lblVentasGeneradas);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 280, 1240, 380);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		add(scrollPane);
		
		DefaultTableModel modelotabla=new DefaultTableModel();
		String titulos[]= {"N° Comprobante","Fecha","Hora","Nombre Cliente","Ruc/Dni","Tipo de Cliente","Direccion","Categoria","Nombre Articulo","Cantidad","Boleta/Factura","Importe"};
		for(String e:titulos)modelotabla.addColumn(e);
		
		MostrarVentasGeneradas ventasgeneradas=new MostrarVentasGeneradas(modelotabla);
		
		DefaultTableCellRenderer styletop=new DefaultTableCellRenderer();
		styletop.setVerticalAlignment(SwingConstants.TOP);
		
		DefaultTableCellRenderer stylecenter=new DefaultTableCellRenderer();
		stylecenter.setHorizontalAlignment(SwingConstants.CENTER);
		
		table = new JTable(modelotabla) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		table.setDefaultRenderer(Object.class, new FormatoTabla());
		table.setSelectionBackground(Color.LIGHT_GRAY);
		table.setOpaque(false);
		table.setBackground(new Color(0,0,0,0));
		//table.setBackground(new Color(60,60,60));
		table.setForeground(Color.WHITE);
		table.getTableHeader().setBackground(new Color(255,99,71));
		table.getTableHeader().setPreferredSize(new Dimension(0,35));
		table.getTableHeader().setFont(new Font("JetBrainsMono Nerd Font Mono", Font.PLAIN, 14));
		scrollPane.setViewportView(table);
		
		
		
	}
	public void dineroTotal() {
		ps=null;
		rs=null;
		try {
			ps=(PreparedStatement) conexion.getConexion().prepareStatement("select precioTotal from boleta union all select precioTotal from factura");
			rs=ps.executeQuery();
			float ingreso=0;
			while(rs.next()) {
				ingreso+=rs.getFloat(1);
			}
			lblTotal.setText(String.valueOf(ingreso));
			ps.close();
			rs.close();
		} catch (SQLException e) {
			System.out.println("ERROR AL OBTENER INGRESO TOTAL");
			e.printStackTrace();
		}
	}
}
