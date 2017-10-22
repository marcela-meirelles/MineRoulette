package com.mmg;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

class IconRenderer extends DefaultTableCellRenderer {

    GameStyle style;

    public IconRenderer() {
        super();
    }

    @Override
    public void setValue(Object value) {
        if (value instanceof Integer) {
            switch ((Integer) value) {
                case GameModel.BLACK:
                    setIcon(style.getBlackIcn());
                    break;
                case GameModel.WHITE:
                    setIcon(style.getWhiteIcn());
                    break;
                case GameModel.POSSIBLE:
                    setIcon(style.getPossibleIcn());
                    break;
                default:
                    setIcon(style.getEmptyIcn());
            }
        }

    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Object firstColumnValue = table.getValueAt(row, 0);

        setVerticalAlignment(JLabel.TOP);
        setValue(value);
        setBackground(table.getBackground());
        setForeground(table.getForeground());
        return this;
    }
}
