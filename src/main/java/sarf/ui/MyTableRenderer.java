package sarf.ui;

import javax.swing.table.*;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.JTable;
import java.awt.*;

/**
 * <p>Title: Sarf</p>
 *
 * <p>Description: ?????? ???????</p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author Haytham Mohtasseb Billah
 * @version 1.0
 */
public class MyTableRenderer extends DefaultTableCellRenderer {
    public MyTableRenderer() {
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,int row, int column){
        JLabel label = (JLabel)super.getTableCellRendererComponent(table, value,
                        isSelected, hasFocus, row, column);
        label.setPreferredSize(new Dimension(100,100));
        return label;
    }

}
