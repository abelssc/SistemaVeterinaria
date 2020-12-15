import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Modelo.ConeccionCategoria;
import Modelo.ConeccionNCodigo;
import Modelo.ConeccionProductos;

import java.awt.Cursor;
import javax.swing.JSeparator;

public class Compras extends JPanel {
	JComboBox<Object> JCbCategoria;
	JComboBox<Object> JCbProducto;
	JTextField txtNombre;
	JTextField txtPrecioVenta;
	JTextField txtCodigo;

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
		JLabel lblSubirImg = new JLabel("Subir Imagen");
		
		JLabel btnGuardar = new JLabel();
		btnGuardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGuardar.setHorizontalAlignment(SwingConstants.CENTER);
		btnGuardar.setIcon(new ImageIcon(Compras.class.getResource("/imagenes/Guardar.png")));
		btnGuardar.setBounds(160,580+bajar,150,30);
		add(btnGuardar);
		JLabel btnCancelar = new JLabel();
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setHorizontalAlignment(SwingConstants.CENTER);
		btnCancelar.setIcon(new ImageIcon(Compras.class.getResource("/imagenes/Cancelar.png")));
		btnCancelar.setBounds(330,580+bajar,150,30);
		add(btnCancelar);
		
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
		
		JTextField txtStockAniadido=new JTextField();
		JTextField txtStockAntiguo=new JTextField();
		txtStockAntiguo.setEditable(false);
		JTextField txtStockFinal=new JTextField();
		txtStockFinal.setEditable(false);
		
		txtCodigo=new JTextField("0000");
		txtCodigo.setBounds(54,420+bajar,210,30);
		txtCodigo.setOpaque(false);
		txtCodigo.setBorder(null);
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
		
		JLabel btnSubirImg=new JLabel();
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
			if(((ConeccionProductos)JCbProducto.getSelectedItem()).getIdProducto()==0) {
				txtNombre.setEditable(true);
				txtPrecioVenta.setEditable(true);
				ConeccionNCodigo codigo=new ConeccionNCodigo();
				txtCodigo.setText("0000"+codigo.generarCodigo());
				
			}
		}
	};
}
