import java.awt.Color;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FilterInputStream;
import java.nio.channels.Selector;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import Modelo.ConeccionCategoria;
import Modelo.ConeccionNCodigo;
import Modelo.ConeccionProductos;
import Modelo.GuardarProductos;

import java.awt.Cursor;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;

public class Compras extends JPanel {
	JComboBox<Object> JCbCategoria;
	JComboBox<Object> JCbProducto;
	JTextField txtNombre;
	JTextField txtPrecioVenta;
	JTextField txtCodigo;
	JTextField txtStockAniadido;
	JTextField txtStockAntiguo;
	JTextField txtStockFinal;
	JLabel lblSubirImg;
	File archivo;
	
	JLabel btnSubirImg;

	/**
	 * Create the panel.
	 */
	public Compras() {
		setBounds(625,20,650,760);
		setLayout(null);
		setOpaque(false);//NO SE PUEDE PINTAR MANTIENE SUS VALORES POR DEFECTO
		int margentop=40;
		int margenleft;
		int bajar=90;
		
		////////////////////////////////////////////////////////////////////////////////////JLABELS
		JLabel lblTitulo =new JLabel("Registrar Compras");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(new Color(255,255,240));
		lblTitulo.setFont(new Font("JetBrainsMonoMedium NF", Font.BOLD, 25));
		lblTitulo.setBounds(0,margentop,650,40);
		add(lblTitulo);
		
		JLabel lblCategoria = new JLabel("Categoria");
		JLabel lblProducto =new JLabel("Producto");
		JLabel lblNombre = new JLabel("Nombre");
		JLabel lblPrecioVenta = new JLabel("Precio de Venta unitario");
		
		JLabel lblStockAniadido = new JLabel("<html><body>Cantidades Compradas</body></html>");
		JLabel lblStockAntiguo = new JLabel("<html><body>Cantidades Actual del Producto</body></html>");
		JLabel lblStockFinal = new JLabel("<html><body>Cantidades finales del Producto</body></html>");
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblSubirImg = new JLabel("Subir Imagen");
		
		JLabel btnGuardar = new JLabel();
		btnGuardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGuardar.setHorizontalAlignment(SwingConstants.CENTER);
		btnGuardar.setIcon(new ImageIcon(Compras.class.getResource("/imagenes/Guardar.png")));
		btnGuardar.setBounds(160,580+bajar,150,30);
		add(btnGuardar);
		btnGuardar.addMouseListener(guardarProducto);
		btnGuardar.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnGuardar.setIcon(new ImageIcon(Compras.class.getResource("/imagenes/Guardar.png")));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btnGuardar.setIcon(new ImageIcon(Compras.class.getResource("/imagenes/GuardarFocus.png")));			
			}
		});
		
		JLabel btnCancelar = new JLabel();
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setHorizontalAlignment(SwingConstants.CENTER);
		btnCancelar.setIcon(new ImageIcon(Compras.class.getResource("/imagenes/Cancelar.png")));
		btnCancelar.setBounds(330,580+bajar,150,30);
		add(btnCancelar);
		btnCancelar.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnCancelar.setIcon(new ImageIcon(Compras.class.getResource("/imagenes/Cancelar.png")));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCancelar.setIcon(new ImageIcon(Compras.class.getResource("/imagenes/CancelarFocus.png")));			
			}
			@Override
			public void mousePressed(MouseEvent e) {
				JCbProducto.setSelectedIndex(0);
				JCbCategoria.setSelectedIndex(0);
				txtNombre.setText("");
				txtPrecioVenta.setText("0.00");
				txtCodigo.setText("0000");
				txtStockAniadido.setText("00");
				txtStockFinal.setText("0");
				archivo=null;
			}
		});
	
		
		margentop=120;
		margenleft=30;
		JLabel[] labelsDato= {lblCategoria,lblProducto,lblNombre,lblPrecioVenta};
		JLabel[] labelsCant= {lblStockAniadido,lblStockAntiguo,lblStockFinal};
		JLabel[] labelsVisual= {lblCodigo/*,lblSubirImg*/};
		boolean rigth=false,top=true;
		for(JLabel lbl:labelsDato) {
			lbl.setFont(new Font("mononoki Nerd Font Mono", Font.BOLD, 15));
			lbl.setForeground(new Color(255,255,255));
			if(lbl.equals(lblPrecioVenta)) margenleft+=325;
			else margenleft=30;
			lbl.setBounds(margenleft,margentop,265,30);
			add(lbl);
			if(margentop<190) margentop+=70;
			else if(margentop==190)margentop+=90;
	
		}
		//margentop=190;->+30w+30w+30h
		//margenleft=30;
		margenleft=30;
		margentop=280;
		for(JLabel lbl:labelsCant) {
			lbl.setFont(new Font("mononoki Nerd Font Mono", Font.BOLD, 15));
			lbl.setForeground(new Color(255,255,255));
			lbl.setBounds(margenleft,margentop+bajar,190,50);	
			add(lbl);
			margenleft+=210;
		}
		//margentop=280+50+30+30
		//margenleft widthall/3 /3
		margenleft=54;
		margentop=390;
		for(JLabel lbl:labelsVisual) {
			lbl.setFont(new Font("mononoki Nerd Font Mono", Font.BOLD, 15));
			lbl.setForeground(new Color(255,255,255));
			lbl.setHorizontalAlignment(SwingConstants.CENTER);
			lbl.setBounds(margenleft,margentop+bajar,210,30);
			add(lbl);
			margenleft+=320;
		}
		
		////////////////////////////////////////////////////////////////////////////JCOMBOS
		JCbCategoria=new JComboBox<Object>();
		ConeccionCategoria categoria=new ConeccionCategoria();
		DefaultComboBoxModel<Object> modeloCategoria=new DefaultComboBoxModel(categoria.mostrarCategoria());
		JCbCategoria.setModel(modeloCategoria);
		JCbCategoria.addActionListener(mostrarProductos);
		
		
		JCbProducto=new JComboBox<Object>();
		JCbProducto.addActionListener(mostrarItems);
		
		margentop=150;
		int ancho=265;
		JComboBox[] combos= {JCbCategoria,JCbProducto};
		for(JComboBox cmb:combos) {
			cmb.setBounds(30,margentop,ancho,30);
			cmb.setOpaque(true);
			cmb.setBorder(new EmptyBorder(0,0,0,0));
			((JComponent) cmb.getComponent(0)).setBorder(new EmptyBorder(0,0,0,0));
			((AbstractButton) cmb.getComponent(0)).setBorderPainted(false);
			cmb.setBackground(new Color(80,80,80,150));
			cmb.setForeground(new Color(255,255,255));
			cmb.setFocusable(false);
			cmb.setFont(new Font("mononoki Nerd Font Mono", Font.BOLD, 12));
			add(cmb);
			margentop+=70;
			ancho=560;
		}
		///////////////////////////////////////////////////////////////////////////////TEXTFIELDS
		txtNombre=new JTextField("-------------------");
		txtPrecioVenta=new JTextField("0.00");
		
		txtStockAniadido=new JTextField();
		txtStockAniadido.addKeyListener(aniadiendoproductos);
		txtStockAntiguo=new JTextField();
		txtStockAntiguo.setEditable(false);
		txtStockFinal=new JTextField();
		txtStockFinal.setEditable(false);
		
		txtCodigo=new JTextField("0000");
		txtCodigo.setBounds(54,420+bajar,210,30);
		txtCodigo.setOpaque(false);
		txtCodigo.setEditable(false);
		txtCodigo.setFont(new Font("mononoki Nerd Font Mono", Font.BOLD, 15));
		txtCodigo.setForeground(new Color(255,255,255));
		txtCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		add(txtCodigo);
		JLabel	opacity4codigo=new JLabel();
		opacity4codigo.setBounds(54,420+bajar,210,30);
		opacity4codigo.setOpaque(true);
		opacity4codigo.setBackground(new Color(40,40,40,80));
		add(opacity4codigo);
		
		btnSubirImg=new JLabel();
		btnSubirImg.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSubirImg.setHorizontalAlignment(SwingConstants.CENTER);
		btnSubirImg.setIcon(new ImageIcon(Compras.class.getResource("/imagenes/btn.png")));
		btnSubirImg.setBounds(374,420+bajar,210,30);
		btnSubirImg.setOpaque(false);
		add(btnSubirImg);
		
		///////////////////////////////////////////////////////////////////////////////////DATOS
		//margentop=190(lblDatos)+30widthlbs
		margentop=220;
		margenleft=30;
		JTextField[] txtsDato= {txtNombre,txtPrecioVenta};
		for(JTextField txt:txtsDato) {
			txt.setHorizontalAlignment(SwingConstants.CENTER);
			txt.setOpaque(false);
			txt.setEditable(false);
			txt.setBorder(null);
			txt.setForeground(new Color(255,255,255));
			txt.setFont(new Font("mononoki Nerd Font Mono", Font.BOLD, 12));
			txt.setBounds(margenleft,margentop+bajar,265,30);
			add(txt);
			margenleft+=295;
			
		}
		margentop=220;
		margenleft=30;
		JLabel lbl4nombre=new JLabel();
		JLabel lbl4precioventa=new JLabel();
		JLabel[] lblOpacity= {lbl4nombre,lbl4precioventa};
		for(JLabel lbls:lblOpacity) {
			lbls.setBounds(margenleft,margentop+bajar,265,30);
			lbls.setOpaque(true);
			lbls.setBackground(new Color(40,40,40,80));
			add(lbls);
			margenleft+=295;
		
		}
		////////////////////////////////////////////////////////////////////////CANTIDADES
		//margentop=280+50width
		margenleft=30;
		margentop=330;
		
		JTextField[] txtsCant= {txtStockAniadido,txtStockAntiguo,txtStockFinal};
		for(JTextField txt:txtsCant) {
			txt.setBounds(margenleft,margentop+bajar,190,30);
			txt.setOpaque(false);
			txt.setBorder(null);
			txt.setText("00");
			txt.setHorizontalAlignment(SwingConstants.CENTER);
			txt.setForeground(new Color(255,255,255));
			txt.setFont(new Font("mononoki Nerd Font Mono", Font.BOLD, 12));
			add(txt);
			margenleft+=210;	
		}
		margenleft=30;
		margentop=330;
		JLabel lbl4aniadido=new JLabel();
		JLabel lbl4antiguo=new JLabel();
		JLabel lbl4final=new JLabel();
		JLabel[] lblOpacity2= {lbl4aniadido,lbl4antiguo,lbl4final};
		for(JLabel lbls:lblOpacity2) {
			lbls.setBounds(margenleft,margentop+bajar,190,30);
			lbls.setOpaque(true);
			lbls.setBackground(new Color(40,40,40,80));
			add(lbls);
			margenleft+=210;
		}
		//////////////////////////////////////////////////////////////////////////CODIGO+IMG
		/*	margenleft=54;
		margentop=390;
		for(JLabel lbl:labelsVisual) {
			lbl.setFont(new Font("mononoki Nerd Font Mono", Font.BOLD, 15));
			lbl.setForeground(new Color(255,255,255));
			lbl.setHorizontalAlignment(SwingConstants.CENTER);
			lbl.setBounds(margenleft,margentop,210,30);
			add(lbl);
			margenleft+=320;
		}*/
		
	
		
		
		
		
		
		
		
	////////////////////////////////////////////////////////////////////////LINEAS DE SEPARACION
		JSeparator separator = new JSeparator();
		separator.setBorder(null);
		separator.setOpaque(true);
		separator.setForeground(null);
		separator.setBackground(new Color(0,0,0,40));
		separator.setBounds(10, 270, 630, 2);
		
		add(separator);
		
		JSeparator separator2 = new JSeparator();
		separator2.setOpaque(true);
		separator2.setBackground(new Color(0,0,0,40));
		separator2.setForeground(null);

		separator2.setBounds(10, 360, 630, 2);
		add(separator2);
		
		
		
	/////////////////////////////////////////////////////////////////////////BACKGROUND
		JLabel lblBackground = new JLabel();//SOLUCION ALA TRANSPARENCIA
		lblBackground.setBounds(0, 0, 650, 760);//EL OBJETO A LA QUE SE LE APLICA LA TRANSPARENCIA NECSITA BUSCAR UN PADRE QUE NO SEA TRANSPARENTE, que no haya sido pintado
		lblBackground.setOpaque(true);//ESTO SE PUEDE CONSEGUIR PONEIENDO UN BACKGROUND NO TRANSPARENTE O PONIENDO UNA OPACITY(FALSE) AL COMPONENTE
		lblBackground.setBackground(new Color(40,40,40,80));//OPACITI FALSE INDICA Q EL COMPONENTE NO SERA PINTADO
		add(lblBackground);//ENTONCES AL NO PODER HACER TRANSPARENTE EL JPANEL SE DEBE CREAR UN JLABEL Q ADQUIERA LOS VALORES DE TRANSPARENCIA.
		
	}
	public ActionListener mostrarProductos=new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			ConeccionProductos productos= new ConeccionProductos();
			productos.setTipoProducto_idTipoProducto(((ConeccionCategoria)JCbCategoria.getSelectedItem()).getIdTipoProducto());
			DefaultComboBoxModel<Object> modeloProductos=new DefaultComboBoxModel(productos.mostrarProductos());
			JCbProducto.setModel(modeloProductos);
		}
	};
	public ActionListener mostrarItems=new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			ConeccionProductos itemSeleccionado=((ConeccionProductos)JCbProducto.getSelectedItem());
			if(itemSeleccionado.getIdProducto()==0) {
				txtNombre.setEditable(true);
				txtPrecioVenta.setEditable(true);
				ConeccionNCodigo codigo=new ConeccionNCodigo();
				txtCodigo.setText("0000"+codigo.generarCodigo());
				
				txtNombre.setBorder(new LineBorder(new Color(114, 138, 253), 2, true));
				txtPrecioVenta.setBorder(new LineBorder(new Color(114, 138, 253), 2, true));
				txtStockAniadido.setBorder(new LineBorder(new Color(114, 138, 253), 2, true));
				
				btnSubirImg.addMouseListener(subirImg);
				btnSubirImg.setIcon(new ImageIcon(Compras.class.getResource("/imagenes/btnFocus.png")));
				txtNombre.setText("---------");
				txtPrecioVenta.setText("0.00");
				txtStockAntiguo.setText("00");
				txtStockAniadido.setText("00");
				txtStockFinal.setText("00");
				
				
			}else if(itemSeleccionado.getIdProducto()>=1){
				txtNombre.setText(itemSeleccionado.getNombre());
				txtPrecioVenta.setText(String.valueOf(itemSeleccionado.getPrecio()));
				txtCodigo.setText(itemSeleccionado.getCodigo());
				txtStockAntiguo.setText(String.valueOf(itemSeleccionado.getStock()));
				txtStockAniadido.setText("0");
				txtStockFinal.setText("00");
				txtNombre.setEditable(false);
				txtPrecioVenta.setEditable(false);
				btnSubirImg.removeMouseListener(subirImg);
				btnSubirImg.setIcon(new ImageIcon(Compras.class.getResource("/imagenes/btn.png")));
				
				txtStockAniadido.setBorder(new LineBorder(new Color(114, 138, 253), 2, true));
				txtNombre.setBorder(null);
				txtPrecioVenta.setBorder(null);
			}else {
				txtNombre.setText("---------");
				txtPrecioVenta.setText("0.00");
				txtCodigo.setText("0000");
				txtStockAntiguo.setText("00");
				txtStockAniadido.setText("00");
				txtStockFinal.setText("00");
				txtNombre.setEditable(false);
				txtPrecioVenta.setEditable(false);
				btnSubirImg.removeMouseListener(subirImg);
				btnSubirImg.setIcon(new ImageIcon(Compras.class.getResource("/imagenes/btn.png")));
				
				txtStockAniadido.setBorder(null);
				txtNombre.setBorder(null);
				txtPrecioVenta.setBorder(null);
				
			}
		}
	};
	public KeyListener aniadiendoproductos=new KeyAdapter() {
		
	
		@Override
		public void keyReleased(KeyEvent arg0) {//LLAMA A LA ACCION CADA VEZ Q SE SUELTA EL BOTON, //NOS AYUDA A OBTENER ANTES EL TEXTO
			int stock=Integer.parseInt(txtStockAniadido.getText())+Integer.parseInt(txtStockAntiguo.getText());
			txtStockFinal.setText(String.valueOf(stock));
		}
	
	};
	
	
	public MouseListener subirImg=new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			JFileChooser selector=new JFileChooser();
			FileNameExtensionFilter filtro=new FileNameExtensionFilter("JPG & PNG Images", "jpg","png");
			selector.setFileFilter(filtro);
			int value=selector.showOpenDialog(lblSubirImg);
			if(value==JFileChooser.APPROVE_OPTION) {
				archivo=selector.getSelectedFile();
			}
		}
	};
	/*JComboBox<Object> JCbCategoria;
	JComboBox<Object> JCbProducto;
	JTextField txtNombre;
	JTextField txtPrecioVenta;
	JTextField txtCodigo;
	JTextField txtStockFinal;
	JLabel lblSubirImg;
	File archivo;*/
	public MouseListener guardarProducto=new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			String nombre=txtNombre.getText();
			float precio=Float.parseFloat(txtPrecioVenta.getText());
			String codigo=txtCodigo.getText();
			int stock=Integer.parseInt(txtStockFinal.getText());
			int categoria=((ConeccionCategoria)JCbCategoria.getSelectedItem()).getIdTipoProducto();
			
			int  insertarNuevoProducto=((ConeccionProductos)JCbProducto.getSelectedItem()).getIdProducto();
			//File archivo;
			
			if(insertarNuevoProducto==0) {
				new GuardarProductos(nombre, precio, codigo, stock, archivo, categoria);
			}
			JCbProducto.setSelectedIndex(0);
			JCbCategoria.setSelectedIndex(0);
			txtNombre.setText("");
			txtPrecioVenta.setText("0.00");
			txtCodigo.setText("0000");
			txtStockAniadido.setText("00");
			txtStockFinal.setText("0");
			archivo=null;
		}
	};
}


















