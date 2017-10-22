package com.mmg;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.util.Enumeration;

/*

GameModel will be in the logic layer
GameStyle will be in style layer

 */

public class GameBoard extends JFrame {

    JTable              table       = new JTable();
    JScrollPane         panel       = new JScrollPane();
    GameModel           gameModel;
    DefaultTableModel   tm;
    String[]            heading     = new String[]{"1", "2", "3", "4", "5", "6", "7", "8"};
    GameStyle           style;


    // Constructor
    public GameBoard(JTable table, GameModel gameModel, GameStyle style) {
        this.table      = table;
        //table.setRowHeight(GameStyle.CELL_SIZE);
        this.gameModel  = gameModel;
        this.style      = style;
    }

    public GameBoard(){

        JButton btn_bomb = new JButton();
        btn_bomb.setText("B");

        table.setRowHeight(60);
        table.setBounds(100,100,100,100);

        IconRenderer icnRenderer = new IconRenderer();
        tm = new MyTableModel(heading);
        for (int row = 0; row < 8; row++) {

            Object[] rowData = new Object[8];
            for (int col = 0; col < 8; col++) {
                rowData[col] = btn_bomb;
            }
            tm.addRow(rowData);
        }

        table.setModel(tm);
        Enumeration<TableColumn> columns = table.getColumnModel().getColumns();
        for (int colIndex = 0; colIndex < 8; colIndex++) {
            TableColumn cbCol = table.getColumnModel().getColumn(colIndex);
            cbCol.setCellRenderer(icnRenderer);
            columns.nextElement().setPreferredWidth(GameStyle.CELL_SIZE);
        }
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);


        table.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {btn_bomb, btn_bomb, btn_bomb, btn_bomb},
                        {btn_bomb, btn_bomb, btn_bomb, btn_bomb},
                        {btn_bomb, btn_bomb, btn_bomb, btn_bomb},
                        {btn_bomb, btn_bomb, btn_bomb, btn_bomb}
                },
                new String [] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));

        panel.setViewportView(table);
    }

    public void setStyle(GameStyle style) {
        this.style = style;
    }

    public void updateTable() {
        int colCount = table.getColumnModel().getColumnCount();
        Object[][] tableVal = new Object[colCount][8];
        int[][] board = gameModel.getBoardData();
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                tableVal[row][col] = board[row][col];
            }
        }
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < colCount; col++) {
                tm.setValueAt(tableVal[row][col], row, col);
            }
        }
    }

    public void setTable() {
        tm = new MyTableModel(heading);
        IconRenderer icnRenderer = new IconRenderer();
        int[][] board = gameModel.getBoardData();

        for (int row = 0; row < 8; row++) {
            Object[] rowData = new Object[8];
            for (int col = 0; col < 8; col++) {
                rowData[col] = board[row][col];
            }
            tm.addRow(rowData);
        }

        table.setModel(tm);
        Enumeration<TableColumn> columns = table.getColumnModel().getColumns();
        for (int colIndex = 0; colIndex < 8; colIndex++) {
            TableColumn cbCol = table.getColumnModel().getColumn(colIndex);
            cbCol.setCellRenderer(icnRenderer);
            columns.nextElement().setPreferredWidth(GameStyle.CELL_SIZE);
        }
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    }

/*
    public void setColumns(){
        TableColumn column = null;
        for (int i = 0; i < 5; i++) {
            column = table.getColumnModel().getColumn(i);
            column.setPreferredWidth(50);
        }
    }

    public void setColumnName(){
        String[] columnNames = new String[5];
        for (int i = 0; i < 5; i++) {
            String columnName = " " + i ;
            columnNames[i] = columnName;
        }
    }
*/
}
