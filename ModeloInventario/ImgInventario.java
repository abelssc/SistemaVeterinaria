package ModeloInventario;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class ImgInventario extends DefaultTableCellRenderer {
	
		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			this.setHorizontalAlignment(SwingConstants.CENTER);
			this.setVerticalAlignment(SwingConstants.CENTER);
			
			table.getColumnModel().getColumn(0).setMaxWidth(150);
			table.getColumnModel().getColumn(0).setMinWidth(100);
			
			table.getColumnModel().getColumn(2).setMaxWidth(110);
			table.getColumnModel().getColumn(2).setMinWidth(110);
			

			
			table.getColumnModel().getColumn(3).setMaxWidth(80);
			table.getColumnModel().getColumn(3).setMinWidth(80);
			
			table.getColumnModel().getColumn(4).setMaxWidth(80);
			table.getColumnModel().getColumn(4).setMinWidth(80);
			
			if(value instanceof JLabel) {
				JLabel lbl=(JLabel) value;
				return lbl;
			}

			return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		}
	};


