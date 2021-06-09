import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JCheckBoxMenuItem;

public class Menu extends JPanel {
	JPanel infoUsuario;
	JPanel menuItems;
	
	public static JLabel almacen;
	public static JLabel compras;
	public static JLabel ventas;
	public static JLabel historialventas;
	public  String nuevopanel;
	public JLabel[] estilosMenu;
	
	////////////////////////METODOS
	public MouseListener mouselistener=new MouseListener() {
	
		@Override
		public void mouseClicked(MouseEvent event) {
			nuevopanel=((JComponent) event.getSource()).getName();
			Contenedor.agregarpaneles(nuevopanel);
			if(!almacen.getName().equals(nuevopanel)) {
				almacen.setBackground(null);
			}
			if(!compras.getName().equals(nuevopanel)) {
				compras.setBackground(null);
			}
			if(!ventas.getName().equals(nuevopanel)) {
				ventas.setBackground(null);
			}
			if(!historialventas.getName().equals(nuevopanel)) {
				historialventas.setBackground(null);
			}
		}
		
		@Override
		public void mouseEntered(MouseEvent event) {
			((JComponent) event.getSource()).setBackground(Color.LIGHT_GRAY);
			
		}
		@Override
		public void mouseExited(MouseEvent event) {
			if(!((JComponent) event.getSource()).getName().equals(nuevopanel)){
				((JComponent) event.getSource()).setBackground(null);
			}
		
		}
		
		@Override
		public void mousePressed(MouseEvent event) {
		// TODO Auto-generated method stub
		
		}
		
		@Override
		public void mouseReleased(MouseEvent event) {
		// TODO Auto-generated method stub
		
		}
	
	};

	/**
	 * Create the panel.
	 */
	public Menu() {
		setBounds(0,0,300,800);
		setLayout(null);
		
		infoUsuario = new JPanel();
		infoUsuario.setBounds(0, 0, 300, 150);
		infoUsuario.setLayout(null);
		infoUsuario.setBackground(new Color(47,44,70));
		add(infoUsuario);
		crearInfoUsuario();
		
		menuItems = new JPanel();
		menuItems.setBounds(0, 150, 300, 650);
		menuItems.setLayout(null);
		menuItems.setBackground(new Color(47,44,70));
		add(menuItems);
		crearMenuItems();
		
	}
	
	public void crearInfoUsuario() {
		//CREANDO IMAGEN DEL PERFIL DE USUARIO
		ImageIcon iconoUsuario=new ImageIcon(getClass().getResource("/imagenes/dog_paw.png"));
		JLabel imagenUsuario=new JLabel();
		imagenUsuario.setBounds(25,25,100,100);
		imagenUsuario.setIcon(new ImageIcon(iconoUsuario.getImage().getScaledInstance(imagenUsuario.getWidth(), imagenUsuario.getHeight(), Image.SCALE_SMOOTH)));
		infoUsuario.add(imagenUsuario);
		
		//AÑADIENDO NOMBRE DEL USUARIO
		
		String nombrevendedor=Login.nombreusuario;
		JLabel nombreUsuario=new JLabel(nombrevendedor);
		nombreUsuario.setBounds(150,50,140,25);
		nombreUsuario.setFont(new Font("Yu Gothic UI Light", Font.BOLD | Font.ITALIC, 20));
		nombreUsuario.setForeground(Color.WHITE);
		infoUsuario.add(nombreUsuario);
		
		
		
		JLabel cargoUsuario=new JLabel("Gerente");
		cargoUsuario.setBounds(150,80,100,25);
		cargoUsuario.setFont(new Font("Yu Gothic UI Light", Font.BOLD | Font.ITALIC, 20));
		cargoUsuario.setForeground(Color.WHITE);
		infoUsuario.add(cargoUsuario);
		
		
		
	}
	
	
	public void crearMenuItems() {
		int alturaItems=50;	
		int anchoItems=menuItems.getWidth();
		int contador=0;
		
		almacen=new JLabel("   Almacén");
		almacen.setName("almacen");
		ImageIcon iconoAlmacen= new ImageIcon(getClass().getResource("/imagenes/almacen.png"));
		almacen.setIcon(new ImageIcon(iconoAlmacen.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
		almacen.setHorizontalAlignment(SwingConstants.LEADING);
		
		compras=new JLabel("   Compras");
		compras.setName("compras");
		ImageIcon iconoCompras= new ImageIcon(getClass().getResource("/imagenes/compras.png"));
		compras.setIcon(new ImageIcon(iconoCompras.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
		
		
		
		ventas=new JLabel("    Ventas");
		ventas.setName("ventas");
		ImageIcon iconoVentas= new ImageIcon(getClass().getResource("/imagenes/ventas.png"));
		ventas.setIcon(new ImageIcon(iconoVentas.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
		
		
		historialventas=new JLabel("    Historial de Ventas");
		historialventas.setName("historial");
		ImageIcon iconohistorial= new ImageIcon(getClass().getResource("/imagenes/historialventas.png"));
		historialventas.setIcon(new ImageIcon(iconohistorial.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
		
		
		JLabel salir=new JLabel("   Salir");
		salir.setName("salir");
		ImageIcon iconoSalir= new ImageIcon(getClass().getResource("/imagenes/salir.png"));
		salir.setIcon(new ImageIcon(iconoSalir.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
		
		
		
		//////////////////////ASIGNANDO VALORES A LOS JLABELS DE MENU	
		JLabel estilosMenu[]= {almacen,compras,ventas,historialventas,salir};
		for(JLabel e:estilosMenu) {
			e.setBounds(0,contador*alturaItems,anchoItems,alturaItems);
			e.setFont(new Font("Yu Gothic UI Light", Font.BOLD | Font.ITALIC, 20));
			e.setForeground(Color.WHITE);
			e.setOpaque(true);
			e.setBackground(null);
			e.setBorder(new EmptyBorder(0,20,0,0));//PARA CONFIGURAR EL MARGEN : //top,left,bottom,right
			e.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			menuItems.add(e);
			e.addMouseListener(mouselistener);
			contador++;
		}
		almacen.setBackground(Color.LIGHT_GRAY);
		salir.setBounds(0,600,anchoItems,alturaItems);
		
	}
}
