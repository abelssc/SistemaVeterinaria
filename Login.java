import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Canvas;

public class Login extends JPanel {
	private JTextField txtEmail;
	private JPasswordField txtPasswordEmail;
	public JLabel lblEmail;
	public JLabel lblPasswordEmail;
	public JButton btnLogin;
	public JLabel imagenCandado;
	public ImageIcon candado;
	public ImageIcon candadoOpen;
	
	public FocusListener focus=new FocusListener() {
	
		@Override
		public void focusGained(FocusEvent e) {
			if(e.getSource()==txtEmail) {
				if(txtEmail.getText().equals("")) {
					lblEmail.setLocation(lblEmail.getX(), lblEmail.getY()-15);
					lblEmail.setFont(new Font("Segoe UI Semibold", 3, 14));
				}
			}else if(e.getSource()==txtPasswordEmail) {
				if(txtPasswordEmail.getPassword().length==0) {
					lblPasswordEmail.setLocation(lblPasswordEmail.getX(), lblPasswordEmail.getY()-15);
					lblPasswordEmail.setFont(new Font("Segoe UI Semibold", 3, 14));
				}
			}
		}
			
		@Override
		public void focusLost(FocusEvent e) {
			if(e.getSource()==txtEmail) {
				if(txtEmail.getText().equals("")) {
					lblEmail.setLocation(lblEmail.getX(), lblEmail.getY()+15);
					lblEmail.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
				}
			}else if(e.getSource()==txtPasswordEmail) {
				if(txtPasswordEmail.getPassword().length==0) {
					lblPasswordEmail.setLocation(lblPasswordEmail.getX(), lblPasswordEmail.getY() + 15);
					lblPasswordEmail.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));				
				}
			}
		}
		
	};
	public MouseListener mouseFocus=new MouseListener() {

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent event) {
			imagenCandado.setIcon(candadoOpen);
			((JComponent) event.getSource()).setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			
		}

		@Override
		public void mouseExited(MouseEvent event) {
			imagenCandado.setIcon(candado);
			((JComponent) event.getSource()).setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	};
	

	/**
	 * Create the panel.
	 */
	public Login() {
		setBounds(0,0,800,650);
		setLayout(null);
		setBackground(null);
		int x=this.getWidth()/3;
		int y=this.getHeight()/2;
		
			
		////////////////////////////////////////////////////////////EMAIL
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
		txtEmail.setOpaque(false);
		txtEmail.setBorder(null);
		txtEmail.setBounds(x, y, x, 30);
		txtEmail.setBackground(null);
		txtEmail.setForeground(new Color(242,242,242));
		add(txtEmail);
		txtEmail.addFocusListener(focus);
		
		lblEmail = new JLabel("E m a i l");
		lblEmail.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
		lblEmail.setBounds(x, y, x, 30);
		lblEmail.setForeground(new Color(255,255,255));
		lblEmail.setBackground(null);
		add(lblEmail);
		
		
		
		
		
		///////////////////////////////////////////////////////////PASSWORD
		txtPasswordEmail = new JPasswordField();
		txtPasswordEmail.setBorder(null);
		txtPasswordEmail.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
		txtPasswordEmail.setBounds(x, y+40,x, 30);
		txtPasswordEmail.setBackground(null);
		txtPasswordEmail.setOpaque(false);
		txtPasswordEmail.setForeground(new Color(242,242,242));
		add(txtPasswordEmail);
		txtPasswordEmail.addFocusListener(focus);
		
		
		lblPasswordEmail = new JLabel("P a s s w o r d");
		lblPasswordEmail.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
		lblPasswordEmail.setBounds(x, y+40,x, 30);
		lblPasswordEmail.setForeground(new Color(255,255,255));
		lblPasswordEmail.setBackground(null);
		add(lblPasswordEmail);
		
		
		
		//////////////////////////////////////////////////////////BOTON AND CHEKBOX
		JCheckBox chckbxRecordar = new JCheckBox("Recordar usuario");
		chckbxRecordar.setFont(new Font("Segoe UI Semibold", 3, 13));
		chckbxRecordar.setFocusPainted(false);
		chckbxRecordar.setBounds(x, y+80,x, 30);
		chckbxRecordar.setOpaque(false);
		chckbxRecordar.setForeground(new Color(255, 255, 255));		
		add(chckbxRecordar);
	
		
		
		//////////////////////////////////////////////////////////SEPARADOR
		JSeparator separatorEmail = new JSeparator();
		separatorEmail.setBounds(x, y+30, x, 2);
		separatorEmail.setBackground(new Color(255,99,71));
		add(separatorEmail);
		
		JSeparator separatorPassword = new JSeparator();
		separatorPassword.setBounds(x, y+70, x, 2);
		separatorPassword.setBackground(new Color(255,99,71));
		add(separatorPassword);
		
		//////////////////////////////////////////////////////////IMAGENES
		candado=new ImageIcon(getClass().getResource("/imagenes/candado.png"));
		candadoOpen=new ImageIcon(getClass().getResource("/imagenes/candadoOpen.png"));
		imagenCandado = new JLabel(candado);
		imagenCandado.setBounds(x-120, y, 80, 80);
		add(imagenCandado);
		imagenCandado.addMouseListener(mouseFocus);
		
		
		ImageIcon icono=new ImageIcon(getClass().getResource("/imagenes/animals/login.jpg"));
		JLabel imagen=new JLabel(icono);
		imagen.setBounds(0,0,800,650);
		add(imagen);
		
	}
}
