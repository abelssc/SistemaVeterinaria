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

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JCheckBoxMenuItem;

public class Menu extends JPanel {
	JPanel infoUsuario;
	JPanel menuItems;
	
	
	////////////////////////METODOS
	public MouseListener mouselistener=new MouseListener() {
	
		@Override
		public void mouseClicked(MouseEvent event) {
			JOptionPane.showMessageDialog(null, ((JComponent) event.getSource()).getName());
			/*switch(((JComponent) event.getSource()).getName()) {
			case "almacen":
				Inventario inventario=new Inventario();
				inventario.setVisible(true);
				
				
				
			}*/
		
		}
		
		@Override
		public void mouseEntered(MouseEvent event) {
			((JComponent) event.getSource()).setBackground(Color.LIGHT_GRAY);
			((JComponent) event.getSource()).setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			
		
		}
		
		@Override
		public void mouseExited(MouseEvent event) {
			((JComponent) event.getSource()).setBackground(null);
			((JComponent) event.getSource()).setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		
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
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		
		infoUsuario = new JPanel();
		infoUsuario.setBounds(0, 0, 300, 150);
		infoUsuario.setLayout(null);
		infoUsuario.setBackground(Color.DARK_GRAY);
		add(infoUsuario);
		crearInfoUsuario();
		
		menuItems = new JPanel();
		menuItems.setBounds(0, 150, 300, 650);
		menuItems.setLayout(null);
		menuItems.setBackground(Color.DARK_GRAY);
		add(menuItems);
		crearMenuItems();
		
		Inventario inventario=new Inventario();
		inventario.setVisible(true);
		
	}
	
	public void crearInfoUsuario() {
		//CREANDO IMAGEN DEL PERFIL DE USUARIO
		ImageIcon iconoUsuario=new ImageIcon(getClass().getResource("/imagenes/dog_paw.png"));
		JLabel imagenUsuario=new JLabel();
		imagenUsuario.setBounds(25,25,100,100);
		imagenUsuario.setIcon(new ImageIcon(iconoUsuario.getImage().getScaledInstance(imagenUsuario.getWidth(), imagenUsuario.getHeight(), Image.SCALE_SMOOTH)));
		infoUsuario.add(imagenUsuario);
		
		//AÑADIENDO NOMBRE DEL USUARIO
		JLabel nombreUsuario=new JLabel("Abel Abed");
		nombreUsuario.setBounds(150,50,100,25);
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
		
		JLabel almacen=new JLabel("   Almacén");
		almacen.setName("almacen");
		ImageIcon iconoAlmacen= new ImageIcon(getClass().getResource("/imagenes/almacen.png"));
		almacen.setIcon(new ImageIcon(iconoAlmacen.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
		almacen.setHorizontalAlignment(SwingConstants.LEADING);
		//menuItems.add(almacen);
		
		JLabel compras=new JLabel("   Compras");
		compras.setName("compras");
		ImageIcon iconoCompras= new ImageIcon(getClass().getResource("/imagenes/compras.png"));
		compras.setIcon(new ImageIcon(iconoCompras.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
		
		//menuItems.add(compras);
		
		JLabel ventas=new JLabel("    Ventas");
		ventas.setName("ventas");
		ImageIcon iconoVentas= new ImageIcon(getClass().getResource("/imagenes/ventas.png"));
		ventas.setIcon(new ImageIcon(iconoVentas.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
		//menuItems.add(ventas);
		
		JLabel historialventas=new JLabel("    Historial de Ventas");
		historialventas.setName("historial");
		ImageIcon iconohistorial= new ImageIcon(getClass().getResource("/imagenes/ventas.png"));
		historialventas.setIcon(new ImageIcon(iconohistorial.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
		//menuItems.add(ventas);
		
		JLabel salir=new JLabel("   Salir");
		salir.setName("salir");
		ImageIcon iconoSalir= new ImageIcon(getClass().getResource("/imagenes/salir.png"));
		salir.setIcon(new ImageIcon(iconoSalir.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
		//menuItems.add(salir);
		
		
		//////////////////////ASIGNANDO VALORES A LOS JLABELS DE MENU	
		JLabel[] estilosMenu= {almacen,compras,ventas,historialventas,salir};
		for(JLabel e:estilosMenu) {
			e.setBounds(0,contador*alturaItems,anchoItems,alturaItems);
			e.setFont(new Font("Yu Gothic UI Light", Font.BOLD | Font.ITALIC, 20));
			e.setForeground(Color.WHITE);
			e.setOpaque(true);
			e.setBackground(null);
			e.setBorder(new EmptyBorder(0,20,0,0));//PARA CONFIGURAR EL MARGEN : //top,left,bottom,right
			menuItems.add(e);
			e.addMouseListener(mouselistener);
			contador++;
		}
		salir.setBounds(0,600,anchoItems,alturaItems);
		
	}
}
