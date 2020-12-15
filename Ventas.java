import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;

public class Ventas extends JPanel {

	/**
	 * Create the panel.
	 */
	public Ventas() {
		setBounds(320,20,1260,760);
		setOpaque(false);//NO SE PUEDE PINTAR MANTIENE SUS VALORES POR DEFECTO
		int margentop=40;
		int margenleft=30;
		setLayout(null);
		
		JLabel lblVentas = new JLabel("Ventas");
		lblVentas.setFont(new Font("JetBrainsMonoMedium Nerd Font", Font.PLAIN, 25));
		lblVentas.setBounds(10, 10, 1240, 30);
		add(lblVentas);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 38, 1240, 2);
		add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 290, 1240, 2);
		add(separator_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 50, 1240, 240);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setBounds(20, 20, 46, 30);
		panel.add(lblCliente);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(20, 50, 820, 40);
		panel.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(900, 50, 300, 40);
		panel.add(comboBox_1);
		
		JLabel lblNewLabel = new JLabel("Fecha de Emision");
		lblNewLabel.setBounds(20, 100, 200, 30);
		panel.add(lblNewLabel);
		
		JLabel lblAquiIraLa = new JLabel("AQUI IRA LA FECHA");
		lblAquiIraLa.setBounds(20, 130, 200, 30);
		panel.add(lblAquiIraLa);
		
		JLabel lblNewLabel_1 = new JLabel("RUC");
		lblNewLabel_1.setBounds(900, 20, 300, 30);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("N\u00B0 Factura");
		lblNewLabel_2.setBounds(329, 100, 46, 14);
		panel.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 300, 1240, 300);
		add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 123, 1180, 122);
		panel_1.add(scrollPane);
		
		
		
		
		
		
		
				
				
		/////////////////////////////////////////////////////////////////////////BACKGROUND
		JLabel lblBackground = new JLabel();
		lblBackground.setBounds(0, 0, 1260, 760);
		lblBackground.setOpaque(true);//ESTO SE PUEDE CONSEGUIR PONEIENDO UN BACKGROUND NO TRANSPARENTE O PONIENDO UNA OPACITY(FALSE) AL COMPONENTE
		lblBackground.setBackground(new Color(40,40,40,80));//OPACITI FALSE INDICA Q EL COMPONENTE NO SERA PINTADO
		add(lblBackground);//ENTONCES AL NO PODER HACER TRANSPARENTE EL JPANEL SE DEBE CREAR UN JLABEL Q ADQUIERA LOS VALORES DE TRANSPARENCIA.
		
		
	}
}
