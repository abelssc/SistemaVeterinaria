package ModeloVentas;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class ImgTabla extends DefaultTableCellRenderer {
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		this.setHorizontalAlignment(SwingConstants.CENTER);
		this.setVerticalAlignment(SwingConstants.CENTER);
		table.getColumnModel().getColumn(3).setMaxWidth(100);
		
		table.getColumnModel().getColumn(4).setMaxWidth(200);
		table.getColumnModel().getColumn(4).setMinWidth(200);
		
		table.getColumnModel().getColumn(5).setMaxWidth(100);
		
		table.getColumnModel().getColumn(6).setMaxWidth(200);
		table.getColumnModel().getColumn(6).setMinWidth(200);
		
		table.getColumnModel().getColumn(7).setMaxWidth(60);
		
		
		if(value instanceof JLabel) {
			JLabel lbl=(JLabel) value;
			return lbl;
		}

		return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	}
};
