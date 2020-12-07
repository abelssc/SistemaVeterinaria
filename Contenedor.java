import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.w3c.dom.events.MouseEvent;

import com.jgoodies.forms.layout.ConstantSize;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JComboBox;

public class Contenedor extends JFrame {

	private JPanel contentPane;
	private int x;
	private int y;

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
		//////MENU
		Menu menu=new Menu();
		contentPane.add(menu);
		//////////////
		
		Compras compras = new Compras();
		contentPane.add(compras);
		
		
		ImageIcon icono=new ImageIcon(Contenedor.class.getResource("/imagenes/animals/fondoCompras.jpg"));
		JLabel lblFondo = new JLabel();
		lblFondo.setBounds(300, 0, 1300, 800);
		lblFondo.setIcon(new ImageIcon(icono.getImage().getScaledInstance(1300, 800,Image.SCALE_SMOOTH)));
		contentPane.add(lblFondo);
		//////////////////////////////
	}
}
