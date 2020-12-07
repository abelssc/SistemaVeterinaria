import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Cursor;

public class Compras extends JPanel {

	/**
	 * Create the panel.
	 */
	public Compras() {
		setBounds(625,20,650,760);
		setLayout(null);
		setOpaque(false);//NO SE PUEDE PINTAR MANTIENE SUS VALORES POR DEFECTO
		int margentop=40;
		int margenleft=30;
		
		
		////////////////////////////////////////////////////////////////////////////////////JLABELS
		JLabel lblTitulo =new JLabel("Registrar Compras");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(new Color(255,255,240));
		lblTitulo.setFont(new Font("JetBrainsMonoMedium NF", Font.BOLD, 25));
		lblTitulo.setBounds(0,margentop,650,40);
		add(lblTitulo);
		
		JLabel lblCategoria = new JLabel("Categoria");
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
		btnGuardar.setBounds(170,580,150,30);
		add(btnGuardar);
		JLabel btnCancelar = new JLabel();
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setHorizontalAlignment(SwingConstants.CENTER);
		btnCancelar.setIcon(new ImageIcon(Compras.class.getResource("/imagenes/Cancelar.png")));
		btnCancelar.setBounds(320,580,150,30);
		add(btnCancelar);
		
		margentop=120;
		JLabel[] labelsDato= {lblCategoria,lblNombre,lblPrecioVenta};
		JLabel[] labelsCant= {lblStockAniadido,lblStockAntiguo,lblStockFinal};
		JLabel[] labelsVisual= {lblCodigo/*,lblSubirImg*/};
		boolean rigth=false,top=false;
		for(JLabel lbl:labelsDato) {
			lbl.setFont(new Font("mononoki Nerd Font Mono", Font.BOLD, 15));
			lbl.setForeground(new Color(255,255,255));
			lbl.setBounds(margenleft,margentop,265,30);
			add(lbl);
			rigth=(rigth)?false:true;
			margenleft=(rigth)?325:30;
			margentop=(top)?margentop+70:margentop;
			top=true;
		}
		//margentop=190;->+30w+30w+30h
		//margenleft=30;
		margenleft=30;
		margentop=280;
		for(JLabel lbl:labelsCant) {
			lbl.setFont(new Font("mononoki Nerd Font Mono", Font.BOLD, 15));
			lbl.setForeground(new Color(255,255,255));
			lbl.setBounds(margenleft,margentop,190,50);	
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
			lbl.setBounds(margenleft,margentop,210,30);
			add(lbl);
			margenleft+=320;
		}
		
		///////////////////////////////////////////////////////////////////////////////TEXTFIELDS
		JComboBox JCbCategoria=new JComboBox();
		JCbCategoria.setBounds(30,150,265,30);
		JCbCategoria.setOpaque(true);
		JCbCategoria.setBackground(new Color(40,40,40));
		JCbCategoria.setForeground(new Color(255,255,255));
		JCbCategoria.setFont(new Font("mononoki Nerd Font Mono", Font.BOLD, 12));
		add(JCbCategoria);
		
		
		JTextField txtNombre=new JTextField();
		JTextField txtPrecioVenta=new JTextField();
		
		JTextField txtStockAniadido=new JTextField();
		JTextField txtStockAntiguo=new JTextField();
		JTextField txtStockFinal=new JTextField();
		
		JTextField txtCodigo=new JTextField();
		txtCodigo.setBounds(54,420,210,30);
		txtCodigo.setOpaque(false);
		txtCodigo.setBorder(null);
		txtCodigo.setFont(new Font("mononoki Nerd Font Mono", Font.BOLD, 15));
		txtCodigo.setForeground(new Color(255,255,255));
		txtCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		add(txtCodigo);
		JLabel	opacity4codigo=new JLabel();
		opacity4codigo.setBounds(54,420,210,30);
		opacity4codigo.setOpaque(true);
		opacity4codigo.setBackground(new Color(40,40,40,80));
		add(opacity4codigo);
		
		JLabel btnSubirImg=new JLabel();
		btnSubirImg.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSubirImg.setHorizontalAlignment(SwingConstants.CENTER);
		btnSubirImg.setIcon(new ImageIcon(Compras.class.getResource("/imagenes/btn.png")));
		btnSubirImg.setBounds(374,420,210,30);
		btnSubirImg.setOpaque(false);
		add(btnSubirImg);
		
		///////////////////////////////////////////////////////////////////////////////////DATOS
		//margentop=120(lblDatos)+30widthlbs
		margentop=150;
		margenleft=30;
		JTextField[] txtsDato= {txtNombre,txtPrecioVenta};
		for(JTextField txt:txtsDato) {
			
			txt.setOpaque(false);
			txt.setBorder(null);
			txt.setForeground(new Color(255,255,255));
			txt.setFont(new Font("mononoki Nerd Font Mono", Font.BOLD, 12));
			txt.setBounds(margenleft+295,margentop,265,30);
			add(txt);
			margenleft-=295;
			margentop+=70;
		}
		margentop=150;
		margenleft=30;
		JLabel lbl4nombre=new JLabel();
		JLabel lbl4precioventa=new JLabel();
		JLabel[] lblOpacity= {lbl4nombre,lbl4precioventa};
		for(JLabel lbls:lblOpacity) {
			lbls.setBounds(margenleft+295,margentop,265,30);
			lbls.setOpaque(true);
			lbls.setBackground(new Color(40,40,40,80));
			add(lbls);
			margenleft-=295;
			margentop+=70;
		}
		////////////////////////////////////////////////////////////////////////CANTIDADES
		//margentop=280+50width
		margenleft=30;
		margentop=330;
		
		JTextField[] txtsCant= {txtStockAniadido,txtStockAntiguo,txtStockFinal};
		for(JTextField txt:txtsCant) {
			txt.setBounds(margenleft,margentop,190,30);
			txt.setOpaque(false);
			txt.setBorder(null);
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
			lbls.setBounds(margenleft,margentop,190,30);
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
		
		
		
		
		
		
		
		
		
		
		
		
		
	/////////////////////////////////////////////////////////////////////////BACKGROUND
		JLabel lblBackground = new JLabel();//SOLUCION ALA TRANSPARENCIA
		lblBackground.setBounds(0, 0, 650, 760);//EL OBJETO A LA QUE SE LE APLICA LA TRANSPARENCIA NECSITA BUSCAR UN PADRE QUE NO SEA TRANSPARENTE, que no haya sido pintado
		lblBackground.setOpaque(true);//ESTO SE PUEDE CONSEGUIR PONEIENDO UN BACKGROUND NO TRANSPARENTE O PONIENDO UNA OPACITY(FALSE) AL COMPONENTE
		lblBackground.setBackground(new Color(40,40,40,80));//OPACITI FALSE INDICA Q EL COMPONENTE NO SERA PINTADO
		add(lblBackground);//ENTONCES AL NO PODER HACER TRANSPARENTE EL JPANEL SE DEBE CREAR UN JLABEL Q ADQUIERA LOS VALORES DE TRANSPARENCIA.
		
	}
}
