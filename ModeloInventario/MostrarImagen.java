package ModeloInventario;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class MostrarImagen extends JPanel{
public BufferedImage imgcompactar;
	
	public MostrarImagen(int ancho,int alto,BufferedImage imgcompactar) {
		this.setSize(ancho,alto);
		this.imgcompactar=imgcompactar;
	}
	@Override
	public void paint(Graphics g) {
		
		BufferedImage img=imgcompactar;
		g.drawImage(img, 0, 0, this.getWidth(),this.getHeight(),null);
		setOpaque(false);	
		super.paintComponent(g);
	}
}
