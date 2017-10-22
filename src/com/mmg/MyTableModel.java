package com.mmg;

import javax.swing.table.DefaultTableModel;

class MyTableModel extends DefaultTableModel {

    public MyTableModel(Object[] os) {
        super();
        for (Object o : os) {
            addColumn(o);
        }
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        switch (columnIndex) {
            default:
                return Integer.class;
        }
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }
}
