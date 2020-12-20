package modeloVentasGeneradas;

import java.awt.Component;


import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class FormatoTabla extends DefaultTableCellRenderer {
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		
		if(column==5||column==8) {
			this.setVerticalAlignment(SwingConstants.TOP);
		
		}else {
			this.setVerticalAlignment(SwingConstants.CENTER);
		}
		this.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		table.setRowHeight(40);
		table.getTableHeader().setPreferredSize(new java.awt.Dimension(0,30));
		
		
		
		table.getColumnModel().getColumn(3).setMinWidth(180);
		
		table.getColumnModel().getColumn(6).setMinWidth(180);
		table.getColumnModel().getColumn(8).setMinWidth(160);
	

		return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	}
};

