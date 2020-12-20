
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;


import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;





import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.MouseEvent;



public class Contenedor extends JFrame {

	private static JPanel contentPane;
	private int x;
	private int y;
	private static Menu menu=new Menu();
	private static Inventario inventario;
	private static Compras compras;
	private static Ventas ventas;
	private static VentasGeneradas historial;
	private static JLabel lblFondo;
	
	private static ImageIcon icono;
	private static JLabel lblexit;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Contenedor frame = new Contenedor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static void agregarpaneles(String panel) {
		contentPane.removeAll();
		contentPane.add(lblexit);
		switch (panel) {
			case "almacen":
				inventario=new Inventario();
				contentPane.add(inventario);
				Menu.almacen.setBackground(Color.LIGHT_GRAY);
				icono=new ImageIcon(Contenedor.class.getResource("/imagenes/animals/almacen.jpg"));
				lblFondo.setIcon(new ImageIcon(icono.getImage().getScaledInstance(1300, 800,Image.SCALE_SMOOTH)));
				break;
			case "compras":
				compras=new Compras();
				contentPane.add(compras);
				Menu.compras.setBackground(Color.LIGHT_GRAY);
				icono=new ImageIcon(Contenedor.class.getResource("/imagenes/animals/login.jpg"));
				lblFondo.setIcon(new ImageIcon(icono.getImage().getScaledInstance(1300, 800,Image.SCALE_SMOOTH)));
				break;
			case "ventas":
				ventas=new Ventas();
				contentPane.add(ventas);
				Menu.ventas.setBackground(Color.LIGHT_GRAY);
				icono=new ImageIcon(Contenedor.class.getResource("/imagenes/animals/ventas.jpg"));
				lblFondo.setIcon(new ImageIcon(icono.getImage().getScaledInstance(1300, 800,Image.SCALE_SMOOTH)));
				break;
			case "historial":
				historial=new VentasGeneradas();
				contentPane.add(historial);
				Menu.historialventas.setBackground(Color.LIGHT_GRAY);
				icono=new ImageIcon(Contenedor.class.getResource("/imagenes/animals/historialventas.jpg"));
				lblFondo.setIcon(new ImageIcon(icono.getImage().getScaledInstance(1300, 800,Image.SCALE_SMOOTH)));
				break;
			case "salir":
				System.exit(0);
		}
		
		contentPane.add(menu);
		contentPane.add(lblFondo);
		
		contentPane.revalidate();
		contentPane.repaint();
	}
	
	
	
	
	/**
	 * Create the frame.
	 */
	
	
	public Contenedor() {
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize(1600,800);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(java.awt.event.MouseEvent e) {
				x=e.getX();
				y=e.getY();
			}
		});
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(java.awt.event.MouseEvent e) {
				int xScreen=e.getXOnScreen();
				int yScreen=e.getYOnScreen();
				setLocation(xScreen-x,yScreen-y);
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		lblexit = new JLabel("");
		lblexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblexit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblexit.setIcon(new ImageIcon(Contenedor.class.getResource("/imagenes/exit.png")));
		lblexit.setBounds(1550, 10, 30, 30);
		contentPane.add(lblexit);
		//////MENU
		//menu=new Menu();
		contentPane.add(menu);
		///////////////////////////////////////////////////////////////////////////////////////////////////////
		
		/*Compras compras = new Compras();
		contentPane.add(compras);*/
		
		/*Ventas ventas =new Ventas();
		contentPane.add(ventas);*/
		
		inventario=new Inventario();
		contentPane.add(inventario);
		
		/*VentasGeneradas ventasgeneradas=new VentasGeneradas();
		contentPane.add(ventasgeneradas);*/
		/////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		icono=new ImageIcon(Contenedor.class.getResource("/imagenes/animals/almacen.jpg"));
		lblFondo = new JLabel();
		lblFondo.setBounds(300, 0, 1300, 800);
		lblFondo.setIcon(new ImageIcon(icono.getImage().getScaledInstance(1300, 800,Image.SCALE_SMOOTH)));
		contentPane.add(lblFondo);
		
	
		
		//////////////////////////////
	}
	
}
