import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Compras extends JPanel {

	/**
	 * Create the panel.
	 */
	public Compras() {
		setBounds(625,20,650,760);
		setLayout(null);
		//setOpaque(false);
		setBackground(new Color(0,0,0,80));
		int margentop=40;
		int margenleft=30;
		
		
		/////////////////////////JLABELS
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
		
		JButton btnGuardar = new JButton("Guardar");
		JButton btnCancelar = new JButton("Cancelar");
		
		margentop=120;
		JLabel[] labelsDato= {lblCategoria,lblNombre,lblPrecioVenta};
		JLabel[] labelsCant= {lblStockAniadido,lblStockAntiguo,lblStockFinal};
		JLabel[] labelsVisual= {lblCodigo,lblSubirImg};
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
		
		////////////////////////TEXTFIELDS
		JComboBox JCbCategoria=new JComboBox();
		/*JCbCategoria.setBounds();
		JCbCategoria.setBackground();
		JCbCategoria.setForeground();
		JCbCategoria.setFont();*/
		add(JCbCategoria);
		
		JTextField txtNombre=new JTextField();
		JTextField txtPrecioVenta=new JTextField();
		
		JTextField txtStockAniadido=new JTextField();
		JTextField txtStockAntiguo=new JTextField();
		JTextField txtStockFinal=new JTextField();
		
		JTextField txtCodigo=new JTextField();
		JButton btnSubirImg=new JButton();
		
		/////////////////////////////////DATOS
		//margentop=120(lblDatos)+30widthlbs
		margentop=150;
		margenleft=30;
		JTextField[] txtsDato= {txtNombre,txtPrecioVenta};
		for(JTextField txt:txtsDato) {
			
			txt.setOpaque(false);
			txt.setBorder(null);
			txt.setForeground(new Color(80,80,80));
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
		//////////////////////////////////////CANTIDADES
		//margentop=280+50width
		margenleft=30;
		margentop=330;
		
		JTextField[] txtsCant= {txtStockAniadido,txtStockAntiguo,txtStockFinal};
		for(JTextField txt:txtsCant) {
			/*txt.setBackground();
			txt.setForeground();
			txt.setFont();*/
			txt.setBounds(margenleft,margentop,190,30);
			add(txt);
			margenleft+=210;
			
		}
		
	//
		
		
	}
	

}
