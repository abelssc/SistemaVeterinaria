import java.awt.BorderLayout;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Component;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Image;
import java.awt.ComponentOrientation;
import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Rectangle;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;


public class RegistroIngresoArticulo extends JFrame {

	private JPanel contentPane;
	private JTextField txtPrecioVenta;
	private JTextField txtNombre;
	private JTextField txtStock;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroIngresoArticulo frame = new RegistroIngresoArticulo();
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
	public RegistroIngresoArticulo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200,660);
		//setExtendedState(Frame.MAXIMIZED_BOTH);
		//setUndecorated(true);
		setLocationRelativeTo(null);
		
		
		contentPane = new JPanel();
		contentPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		contentPane.setBackground(new Color(13, 17, 20));
		contentPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Registrar Art\u00EDculo");
		lblTitulo.setFont(new Font("Lucida Console", Font.PLAIN, 20));
		lblTitulo.setBounds(33, 11, 330, 34);
		lblTitulo.setForeground(new Color(242, 242, 242));
		contentPane.add(lblTitulo);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Lucida Console", Font.PLAIN, 15));
		lblNombre.setBounds(50, 198, 500, 30);
		lblNombre.setForeground(new Color(242, 242, 242));
		contentPane.add(lblNombre);
		
		JLabel lblPrecioVenta = new JLabel("Precio de Venta");
		lblPrecioVenta.setFont(new Font("Lucida Console", Font.PLAIN, 15));
		lblPrecioVenta.setBounds(50, 296, 500, 30);
		lblPrecioVenta.setForeground(new Color(242, 242, 242));
		contentPane.add(lblPrecioVenta);
		
		JLabel lblStock = new JLabel("Stock");
		lblStock.setFont(new Font("JetBrainsMonoMedium NF", Font.BOLD, 25));
		lblStock.setBounds(650, 102, 180, 30);
		lblStock.setForeground(new Color(242, 242, 242));
		contentPane.add(lblStock);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setFont(new Font("Lucida Console", Font.PLAIN, 15));
		lblCategoria.setBounds(50, 102, 500, 30);
		lblCategoria.setForeground(new Color(242, 242, 242));
		contentPane.add(lblCategoria);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setFont(new Font("Lucida Console", Font.PLAIN, 15));
		lblCodigo.setBounds(650, 296, 180, 30);
		lblCodigo.setForeground(new Color(242, 242, 242));
		contentPane.add(lblCodigo);
		
		JLabel lblSubirImg = new JLabel("Subir Imagen");
		lblSubirImg.setFont(new Font("Lucida Console", Font.PLAIN, 15));
		lblSubirImg.setBounds(50, 421, 180, 30);
		lblSubirImg.setForeground(new Color(242, 242, 242));
		contentPane.add(lblSubirImg);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 56, 1164, 2);
		contentPane.add(separator);
		
		JComboBox comboBoxCategoria = new JComboBox();
		comboBoxCategoria.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		comboBoxCategoria.setBounds(50, 130, 500, 30);
		comboBoxCategoria.setBackground(new Color(242,242,242));
		contentPane.add(comboBoxCategoria);
		
		txtPrecioVenta = new JTextField();
		txtPrecioVenta.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		txtPrecioVenta.setBounds(50, 323, 500, 30);
		txtPrecioVenta.setBackground(new Color(242,242,242));
		contentPane.add(txtPrecioVenta);
		txtPrecioVenta.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		txtNombre.setBounds(50, 225, 500, 30);
		txtNombre.setBackground(new Color(242,242,242));
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtStock = new JTextField();
		txtStock.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		txtStock.setBounds(650, 130, 500, 30);
		txtStock.setBackground(new Color(242,242,242));
		contentPane.add(txtStock);
		txtStock.setColumns(10);
		
		JLabel lblStockFinal = new JLabel("Stock Final");
		lblStockFinal.setFont(new Font("Lucida Console", Font.PLAIN, 15));
		lblStockFinal.setBounds(650, 198, 180, 30);
		lblStockFinal.setForeground(new Color(242, 242, 242));
		contentPane.add(lblStockFinal);
		
		JLabel txtStockFinal = new JLabel("-");
		txtStockFinal.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		txtStockFinal.setOpaque(true);
		txtStockFinal.setBackground(new Color(242,242,242));
		txtStockFinal.setBounds(650, 225, 500, 30);
		contentPane.add(txtStockFinal);
		
		JLabel txtCodigo = new JLabel("-");
		txtCodigo.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		txtCodigo.setOpaque(true);
		txtCodigo.setBackground(new Color(242,242,242));
		txtCodigo.setBounds(650, 323, 500, 30);
		contentPane.add(txtCodigo);
		
		JButton btnNewButton = new JButton("Seleccionar Imagen");
		btnNewButton.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		btnNewButton.setEnabled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(50, 449, 180, 30);
		contentPane.add(btnNewButton);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		btnGuardar.setBounds(650, 449, 120, 30);
		contentPane.add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Mongolian Baiti", Font.PLAIN, 17));
		btnCancelar.setBounds(880, 449, 120, 30);
		contentPane.add(btnCancelar);
		
		JLabel lblX = new JLabel("X");
		lblX.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblX.setBounds(1131, 11, 20, 20);
		contentPane.add(lblX);
		
		JLabel lblFondo = new JLabel();
		lblFondo.setFont(new Font("Tahoma", Font.PLAIN, 75));
		lblFondo.setBounds(300, 69, 600, 500);

		
		ImageIcon imagenFondo=new ImageIcon(getClass().getResource("/imagenes/dog_paw.png"));
		lblFondo.setIcon(new ImageIcon(imagenFondo.getImage().getScaledInstance(lblFondo.getWidth(),lblFondo.getHeight(),Image.SCALE_SMOOTH)));
		/*JLabel lblimagen=new JLabel();
		lblimagen.setBounds(500,70,400,700);
		lblimagen.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(lblimagen.getWidth(),lblimagen.getHeight(),Image.SCALE_SMOOTH)));
		panel.add(lblimagen);*/
	
		contentPane.add(lblFondo);
	}
}
