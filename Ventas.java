import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Modelo.ConeccionCategoria;
import Modelo.ConeccionProductos;
import ModeloVentas.ActualizarStock;
import ModeloVentas.GenerarVenta;
import ModeloVentas.ImgTabla;
import ModeloVentas.InfoCliente;
import ModeloVentas.Producto_has_Venta;

import javax.swing.JTable;
import javax.swing.border.MatteBorder;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.ListSelectionModel;
import java.awt.Cursor;

public class Ventas extends JPanel {
	private JTable table;
	
	DefaultComboBoxModel<Object> modeloCliente;
	DefaultComboBoxModel<Object> modeloCategoria;
	DefaultComboBoxModel<Object> modeloProductos;
	
	JLabel eliminar=new JLabel();

	
	JLabel lblSubTotal;
	JLabel lbligv;
	JLabel lblTotal;
	
	ButtonGroup grupoRadioBotones;
	/**
	 * Create the panel.
	 */
	public Ventas() {
		setBounds(320,20,1260,760);
		setOpaque(false);//NO SE PUEDE PINTAR MANTIENE SUS VALORES POR DEFECTO
		int margentop=40;
		int margenleft=30;
		setLayout(null);
		/////////////////////////////////////////////////////JUST LABELS less IMPORTANT////////////////
		JLabel lblVentas = new JLabel("Ventas");
		lblVentas.setForeground(Color.WHITE);
		lblVentas.setFont(new Font("JetBrainsMonoMedium Nerd Font", Font.PLAIN, 25));
		lblVentas.setBounds(10, 10, 1240, 40);
		add(lblVentas);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 48, 1240, 2);
		add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 290, 1240, 2);
		add(separator_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 50, 1240, 240);
		panel.setOpaque(false);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setForeground(Color.WHITE);
		lblCliente.setFont(new Font("JetBrainsMono Nerd Font Mono", Font.PLAIN, 14));
		lblCliente.setBounds(20, 20, 820, 30);
		panel.add(lblCliente);
		
		JLabel lblRuc = new JLabel("");
		lblRuc.setForeground(Color.WHITE);
		lblRuc.setFont(new Font("JetBrainsMono Nerd Font Mono", Font.PLAIN, 14));
		lblRuc.setHorizontalAlignment(SwingConstants.CENTER);
		lblRuc.setBorder(new LineBorder(Color.WHITE, 1, true));
		lblRuc.setBounds(900, 50, 300, 30);
		panel.add(lblRuc);
		/////////////////////////////////////////////////COMBO CLIENTE//////////////////////
		
		InfoCliente infocliente=new InfoCliente();
		modeloCliente=new DefaultComboBoxModel(infocliente.obtenerInfo());
		JComboBox cmbCliente = new JComboBox(modeloCliente);
		cmbCliente.setFocusable(false);
		cmbCliente.setBounds(20, 50, 820, 30);
		panel.add(cmbCliente);
		cmbCliente.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				lblRuc.setText(((InfoCliente)modeloCliente.getSelectedItem()).getDniRuc());
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("RUC / DNI");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("JetBrainsMono Nerd Font Mono", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(900, 20, 300, 30);
		panel.add(lblNewLabel_1);
		
		JLabel lblImpuesto = new JLabel("Impuesto");
		lblImpuesto.setForeground(Color.WHITE);
		lblImpuesto.setFont(new Font("JetBrainsMono Nerd Font Mono", Font.PLAIN, 14));
		lblImpuesto.setBounds(20, 100, 200, 30);
		panel.add(lblImpuesto);
		
		JLabel label = new JLabel("18 %");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("JetBrainsMono Nerd Font Mono", Font.PLAIN, 14));
		label.setBorder(new LineBorder(Color.WHITE, 1, true));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(20, 130, 200, 30);
		panel.add(label);
		//////////////////////////////////////////////////////RADIO BOTONES FOR BOLETA AND FACTURA
		JRadioButton rdbtnBoleta = new JRadioButton("Boleta",true);
		rdbtnBoleta.setForeground(Color.WHITE);
		rdbtnBoleta.setActionCommand("Boleta");
		rdbtnBoleta.setOpaque(false);
		rdbtnBoleta.setFocusPainted(false);
		rdbtnBoleta.setBounds(300, 130, 109, 20);
		
		panel.add(rdbtnBoleta);
		
		JRadioButton rdbtnFactura = new JRadioButton("Factura",false);
		rdbtnFactura.setForeground(Color.WHITE);
		rdbtnFactura.setActionCommand("Factura");
		rdbtnFactura.setOpaque(false);
		rdbtnFactura.setFocusPainted(false);
		rdbtnFactura.setBounds(300, 150, 109, 20);
		panel.add(rdbtnFactura);
		
		grupoRadioBotones=new ButtonGroup();
		grupoRadioBotones.add(rdbtnBoleta);
		grupoRadioBotones.add(rdbtnFactura);
		//////////////////////////////////////////////////////JLABEL AND PANEL LESS IMPORTANT
		JLabel lblTipoDeComprobante = new JLabel("Tipo de Comprobante");
		lblTipoDeComprobante.setForeground(Color.WHITE);
		lblTipoDeComprobante.setFont(new Font("JetBrainsMono Nerd Font Mono", Font.PLAIN, 14));
		lblTipoDeComprobante.setBounds(300, 100, 200, 30);
		panel.add(lblTipoDeComprobante);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 300, 1240, 420);
		add(panel_1);
		panel_1.setOpaque(false);;
		panel_1.setLayout(null);
		
		///////////////////////////////////////////////////////////SCROLLPANE AND TABLEMODEL
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 100, 1180, 170);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		panel_1.add(scrollPane);
		
		
		DefaultTableModel modelotabla=new DefaultTableModel();
		String[] titulos= {"Categoria","Artículo","Codigo","Stock","P.Venta","Cantidad","Importe","Eliminar"};
		for(String title:titulos)modelotabla.addColumn(title);
		
		///////////////////////////////////////////////////////////-CREANDO TABLA--------CREANDO FILAS NO EDITABLES Y CREANDO METODO Q ELIMINA FILAS
		table = new JTable(modelotabla) {
			@Override
			public boolean isCellEditable(int row, int column) {
				if(column==5)return true;
				else if(column==7) {
					int fila=table.getSelectedRow();
					modelotabla.removeRow(fila);
					
		//---------------------------ACTUALIZANDO DATOS DEL SUBTOTAL IGV Y TOTAL SI SE ELIMINA UNA FILA
					float total=0;
					for(int i=0;i<table.getRowCount();i++) {
						total+=(float) table.getValueAt(i, 6);
					}
					float igv=(total/18);
					float subtotal=total-igv;
					igv=(float) (Math.round(igv*100.0)/100.0);
					subtotal=(float) (Math.round(subtotal*100.0)/100.0);
					
					lblTotal.setText(String.valueOf(total));
					lbligv.setText(String.valueOf(igv));
					lblSubTotal.setText(String.valueOf(subtotal));
					return true;
				}
				else return false;
			}
		};
		table.setRowSelectionAllowed(false);
		table.setSelectionBackground(Color.LIGHT_GRAY);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//---------------------------------------------------AÑADIENDO STILOS A LA TABLA
		table.setRowHeight(50);
		table.setBackground(new Color(60,60,60));
		table.setForeground(Color.WHITE);
		table.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 35));
		table.getTableHeader().setFont(new Font("JetBrainsMono Nerd Font Mono", Font.PLAIN, 14));
		table.getTableHeader().setBackground(new Color(255,99,71));
		/*---------------CREANDO UNA CLASE IMGTABLA QUE ENVIA A LA TABLA UN ICONO EQUIS-------------------------------*/
		
		table.setDefaultRenderer(Object.class, new ImgTabla());
		
		//----------------------------------------------------AÑADIENDO STYLES A LA TABLA
		DefaultTableCellRenderer cellstyle=new DefaultTableCellRenderer();
		cellstyle.setBackground(new Color(255,99,71));
		cellstyle.setHorizontalAlignment(SwingConstants.CENTER);
		table.getColumnModel().getColumn(5).setCellRenderer(cellstyle);
		scrollPane.setViewportView(table);
		//-----------------------------------------SI SE EJECUTA UN CAMBIO EN LA TABLA EL IMPORTE Y LOS TOTALES SE ACTUALIZANN
		table.getModel().addTableModelListener(new TableModelListener() {
			@Override
			public void tableChanged(TableModelEvent e) {
					try {
						if(e.getType() == TableModelEvent.UPDATE) {
							
							int fila=e.getFirstRow();
							int columna=e.getColumn();
							
							float precio=(float) table.getValueAt(fila, 4);
							float cantidad=Float.parseFloat((String) table.getValueAt(fila, 5));
							float importe=cantidad*precio;
							if(columna==5) {
								table.setValueAt(importe, fila, 6);
								float total=0;
								for(int i=0;i<table.getRowCount();i++) {
									total+=(float) table.getValueAt(i, 6);
								}
								float igv=(total/18);
								float subtotal=total-igv;
								igv=(float) (Math.round(igv*100.0)/100.0);
								subtotal=(float) (Math.round(subtotal*100.0)/100.0);
								
								lblTotal.setText(String.valueOf(total));
								lbligv.setText(String.valueOf(igv));
								lblSubTotal.setText(String.valueOf(subtotal));
							}
						}
					}catch(Error error) {	
						error.printStackTrace();
					}
			}
		});
		///////////////////////////////////////////////////////LABEL LESS IMPORTANT
		JLabel lblBuscarArticulos = new JLabel("Productos");
		lblBuscarArticulos.setForeground(Color.WHITE);
		lblBuscarArticulos.setFont(new Font("JetBrainsMono Nerd Font Mono", Font.PLAIN, 14));
		lblBuscarArticulos.setBounds(310, 10, 100, 30);
		panel_1.add(lblBuscarArticulos);
		
		//////////////////////////////////////////////////////ENVIANDO DATOS ALA TABLA MEDIANTE DEFAULTTABLEMODEL
		JComboBox<Object> cmbProducto = new JComboBox<Object>();
		cmbProducto.setFocusable(false);
		cmbProducto.setBounds(310, 40, 600, 30);
		panel_1.add(cmbProducto);
	
		cmbProducto.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String categoria=((ConeccionCategoria)modeloCategoria.getSelectedItem()).getNombreTipoProducto();
				//String articulo="<html><body>"+((ConeccionProductos)modeloProductos.getSelectedItem()).getNombre()+"</body></html>";
				String codigo=((ConeccionProductos)modeloProductos.getSelectedItem()).getCodigo();
				ConeccionProductos articulo=(ConeccionProductos) modeloProductos.getSelectedItem();
				int stock=((ConeccionProductos)modeloProductos.getSelectedItem()).getStock();
				float pventa=((ConeccionProductos)modeloProductos.getSelectedItem()).getPrecio();
				float importe=0;
				eliminar.setIcon(new ImageIcon(getClass().getResource("/imagenes/delete.png")));
				
				
				Object[] fila= {categoria,articulo,codigo,stock,pventa,0/*cantidad*/,importe,eliminar};
				modelotabla.addRow(fila);
				
			}
		});
		////////////////////////////////////////////////////////LBAL LESS IMPORTANT
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setForeground(Color.WHITE);
		lblCategoria.setFont(new Font("JetBrainsMono Nerd Font Mono", Font.PLAIN, 14));
		lblCategoria.setBounds(20, 10, 100, 30);
		panel_1.add(lblCategoria);
		
	
		//////////////////////////////////////////////////////////COMBO CATEGORIA
		ConeccionCategoria categoria=new ConeccionCategoria();
		modeloCategoria=new DefaultComboBoxModel(categoria.mostrarCategoria());
		JComboBox<Object> cmbCategoria = new JComboBox<Object>(modeloCategoria);
		cmbCategoria.setFocusable(false);
		cmbCategoria.setBounds(20, 40, 200, 30);
		panel_1.add(cmbCategoria);
		cmbCategoria.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ConeccionProductos productos= new ConeccionProductos();
				productos.setTipoProducto_idTipoProducto(((ConeccionCategoria)cmbCategoria.getSelectedItem()).getIdTipoProducto());
				modeloProductos=new DefaultComboBoxModel(productos.mostrarProductos());
				modeloProductos.removeElementAt(1);
				cmbProducto.setModel(modeloProductos);
			}
		});
		///////////////////////////////////////////////////////////LABELS LESS IMPORTANT
		JLabel lbltxtsb = new JLabel("Sub Total: S/");
		lbltxtsb.setForeground(Color.WHITE);
		lbltxtsb.setFont(new Font("JetBrainsMono Nerd Font Mono", Font.PLAIN, 14));
		lbltxtsb.setBorder(new MatteBorder(1, 1, 1, 0, (Color) Color.WHITE));
		lbltxtsb.setHorizontalAlignment(SwingConstants.CENTER);
		lbltxtsb.setBounds(240, 290, 110, 40);
		panel_1.add(lbltxtsb);
		
		lblSubTotal = new JLabel("0.00");
		lblSubTotal.setForeground(Color.WHITE);
		lblSubTotal.setFont(new Font("JetBrainsMono Nerd Font Mono", Font.PLAIN, 14));
		lblSubTotal.setBorder(new MatteBorder(1, 0, 1, 1, (Color) Color.WHITE));
		lblSubTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubTotal.setBounds(350, 290, 70, 40);
		panel_1.add(lblSubTotal);
		
		JLabel lbltxtigv = new JLabel("%IGV: S/");
		lbltxtigv.setForeground(Color.WHITE);
		lbltxtigv.setFont(new Font("JetBrainsMono Nerd Font Mono", Font.PLAIN, 14));
		lbltxtigv.setBorder(new MatteBorder(1, 1, 1, 0, (Color) Color.WHITE));
		lbltxtigv.setHorizontalAlignment(SwingConstants.CENTER);
		lbltxtigv.setBounds(460, 290, 110, 40);
		panel_1.add(lbltxtigv);
		
		lbligv = new JLabel("0.00");
		lbligv.setForeground(Color.WHITE);
		lbligv.setFont(new Font("JetBrainsMono Nerd Font Mono", Font.PLAIN, 14));
		lbligv.setBorder(new MatteBorder(1, 0, 1, 1, (Color) Color.WHITE));
		lbligv.setHorizontalAlignment(SwingConstants.CENTER);
		lbligv.setBounds(570, 290, 70, 40);
		panel_1.add(lbligv);
		
		JLabel lbltxtt = new JLabel("Total: S/");
		lbltxtt.setForeground(Color.WHITE);
		lbltxtt.setFont(new Font("JetBrainsMono Nerd Font Mono", Font.PLAIN, 14));
		lbltxtt.setBorder(new MatteBorder(1, 1, 1, 0, (Color) Color.WHITE));
		lbltxtt.setHorizontalAlignment(SwingConstants.CENTER);
		lbltxtt.setBounds(680, 290, 110, 40);
		panel_1.add(lbltxtt);
		
		lblTotal = new JLabel("0.00");
		lblTotal.setForeground(Color.WHITE);
		lblTotal.setFont(new Font("JetBrainsMono Nerd Font Mono", Font.PLAIN, 14));
		lblTotal.setBorder(new MatteBorder(1, 0, 1, 1, (Color) Color.WHITE));
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotal.setBounds(790, 290, 70, 40);
		panel_1.add(lblTotal);
		///////////////////////////////////////////////////////////////BOTON VENDER Y CANCELAR
		JLabel lblIconoGenerarVenta = new JLabel(" Generar Venta");
		lblIconoGenerarVenta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblIconoGenerarVenta.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
		lblIconoGenerarVenta.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconoGenerarVenta.setFont(new Font("JetBrainsMono Nerd Font Mono", Font.PLAIN, 14));
		lblIconoGenerarVenta.setForeground(Color.WHITE);
		lblIconoGenerarVenta.setOpaque(true);
		lblIconoGenerarVenta.setBackground(Color.ORANGE);
		
		ImageIcon iconoventa= new ImageIcon(getClass().getResource("/imagenes/ventas.png"));
		lblIconoGenerarVenta.setIcon(new ImageIcon(iconoventa.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
		lblIconoGenerarVenta.setBounds(20, 370, 160, 30);
		panel_1.add(lblIconoGenerarVenta);
		lblIconoGenerarVenta.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int idcliente=((InfoCliente)modeloCliente.getSelectedItem()).getId();
				String tipocomprobante=grupoRadioBotones.getSelection().getActionCommand();
				float total=Float.parseFloat(lblTotal.getText());
				float igv=Float.parseFloat(lbligv.getText());
				float subtotal=Float.parseFloat(lblSubTotal.getText());
				GenerarVenta venta=new GenerarVenta(idcliente,tipocomprobante,subtotal,igv,total);
				int idventa=venta.getIdVenta();
				for(int i=0;i<table.getRowCount();i++) {
					int idproducto=((ConeccionProductos)table.getValueAt(i, 1)).getIdProducto();
					int unidades=Integer.parseInt(String.valueOf(table.getValueAt(i, 5)));
					float importe=Float.parseFloat(String.valueOf(table.getValueAt(i, 6)));
					new Producto_has_Venta(idproducto,idventa,unidades,importe);
					int stock=((ConeccionProductos)table.getValueAt(i, 1)).getStock()-unidades;
					new ActualizarStock(stock,idproducto);
				}
				JOptionPane.showMessageDialog(null, "VENTA CONCRETADA");
			}
		});
		
		JLabel lblIconoCancelar = new JLabel("  Cancelar");
		lblIconoCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblIconoCancelar.setOpaque(true);
		lblIconoCancelar.setBackground(Color.PINK);
		lblIconoCancelar.setFont(new Font("JetBrainsMono Nerd Font Mono", Font.PLAIN, 16));
		lblIconoCancelar.setForeground(Color.WHITE);
		lblIconoCancelar.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconoCancelar.setIcon(new ImageIcon(Ventas.class.getResource("/imagenes/equis.png")));
		lblIconoCancelar.setBounds(200, 370, 160, 30);
		panel_1.add(lblIconoCancelar);
		lblIconoCancelar.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				cmbCliente.setSelectedIndex(0);
				cmbCategoria.setSelectedIndex(0);
				while(table.getRowCount()!=0) {
					modelotabla.removeRow(0);
				}
				lblSubTotal.setText("0.00");
				lbligv.setText("0.00");
				lblTotal.setText("0.00");
			}
		});
		
		/////////////////////////////////////////////////////////////////////////BACKGROUND
		JLabel lblBackground = new JLabel();
		lblBackground.setBounds(0, 0, 1260, 760);
		lblBackground.setOpaque(true);//ESTO SE PUEDE CONSEGUIR PONEIENDO UN BACKGROUND NO TRANSPARENTE O PONIENDO UNA OPACITY(FALSE) AL COMPONENTE
		lblBackground.setBackground(new Color(40,40,40,80));//OPACITI FALSE INDICA Q EL COMPONENTE NO SERA PINTADO
		add(lblBackground);//ENTONCES AL NO PODER HACER TRANSPARENTE EL JPANEL SE DEBE CREAR UN JLABEL Q ADQUIERA LOS VALORES DE TRANSPARENCIA.
		
		
		
	
		
	}
}
