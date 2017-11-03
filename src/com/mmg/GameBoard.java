package com.mmg;

import javax.swing.*;
import javax.swing.table.*;
import javax.swing.text.TableView;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Random;


public class GameBoard {

    private JTable              table           = new JTable();
    private JScrollPane         panel           = new JScrollPane();
    private GameModel           gameModel;
    private DefaultTableModel   tm              = new DefaultTableModel();
    //private String[]            heading         = new String[]{"1", "2", "3", "4", "5", "6", "7", "8"};
    private GameStyle           style;
    int                         CELL_WIDTH;
    int                         NUMBER_OF_ROWS;
    private ArrayList<Cell>     cells           = new ArrayList<>();
    // Constructor
    public GameBoard(){

            //JTable table, GameModel gameModel, GameStyle style) {
        //this.table      = table;
        //table.setRowHeight(GameStyle.CELL_SIZE);
//        this.gameModel  = gameModel;
//        this.style      = style;
        //JTable table = new JTable();
        /* INIT COMPONENTS NEEDS TO WORK!!!!!!!!!!!!!!!!!! <<<<<<<<<<<<<<<<<<
        initComponents();
        */
        //setLocationRelativeTo(null);
//        table.setVisible(true);

        start();
    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    public JScrollPane getPanel() {
        return panel;
    }

    public void setPanel(JScrollPane panel) {
        this.panel = panel;
    }

    public GameModel getGameModel() {
        return gameModel;
    }

    public void setGameModel(GameModel gameModel) {
        this.gameModel = gameModel;
    }

    public DefaultTableModel getTm() {
        return tm;
    }

    public void setTm(DefaultTableModel tm) {
        this.tm = tm;
    }

//    public String[] getHeading() {
//        return heading;
//    }
//
//    public void setHeading(String[] heading) {
//        this.heading = heading;
//    }

    public GameStyle getStyle() {
        return style;
    }

    public void setStyle(GameStyle style) {
        this.style = style;
    }

    public int getCELL_WIDTH() {
        return CELL_WIDTH;
    }

    public void setCELL_WIDTH(int CELL_WIDTH) {
        this.CELL_WIDTH = CELL_WIDTH;
    }

    public int getNUMBER_OF_ROWS() {
        return NUMBER_OF_ROWS;
    }

    public void setNUMBER_OF_ROWS(int NUMBER_OF_ROWS) {
        this.NUMBER_OF_ROWS = NUMBER_OF_ROWS;
    }

    public ArrayList<Cell> getCells() {
        return cells;
    }

    public void setCells(ArrayList<Cell> cells) {
        this.cells = cells;
    }

    public GameBoard(int size){
        CELL_WIDTH = 450 / size;
        tm.setColumnCount(size);
        tm.setRowCount(size);
        boolean hasBomb = false;
        int bombCount = 0;

        int cellCount = size*size;

        ArrayList<Cell> cells_helper = new ArrayList<>();

        // forms all cells, includes bomb in one of them randomly
        for(int i=0; i < cellCount; i++){
            hasBomb = false;
            // randomly assigns 1 bomb
            if(bombCount == 0){
                hasBomb = Math.random() < 0.5;
                if(hasBomb) {
                    bombCount++;
                }
            }

            // if it reached the end of the cellCount it will set hasBomb to true
            // in order to make sure there is at least one bomb in the board
            if(i == cellCount - 1 && bombCount==0){
                hasBomb = true;
            }

            Cell c = new Cell(hasBomb, false);
            cells_helper.add(c);
        }

        // uses a helper so the cells array will remain unchanged
        // we can then use it to work once the game starts
        cells = cells_helper;


        // method to assign all cells to rows
        Object[][] data = new Object[size][size];

        for(int i = 0; i < size ; i++){
            for(int j = 0; j < size; j++){
                // because it will take the element and remove it from the list
                // it will always work with position 0
                data[i][j] = cells_helper.get(0);
                cells_helper.remove(cells_helper.get(0));
            }
        }


        // creates column names according to table size
        String[] column_names = new String[size];
        for(int i = 0; i < size; i++){
            column_names[i] = "" + i;
        }

        // creates table with the previous data
        tm.setDataVector(data,column_names);
        table.setModel(tm);

        Enumeration<TableColumn> columns = table.getColumnModel().getColumns();
        for (int colIndex = 0; colIndex < size; colIndex++) {
            TableColumn cbCol = table.getColumnModel().getColumn(colIndex);
            //cbCol.setCellRenderer(icnRenderer);
            //columns.nextElement().setPreferredWidth(CELL_WIDTH);
            columns.nextElement().setWidth(CELL_WIDTH);
        }
        table.setRowHeight(CELL_WIDTH);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        panel.setViewportView(table);
    }

    private void addBomb(){
        // Checks every cell, makes sure it is not uncovered,
        // makes sure it doesn't already have a bomb and adds it to a list.
        // Then it randomly selects one and assigns a bomb to it

        // First checks to see all the unclicked, not with bomb cells and adds to list
        for(Cell c : cells){
            if(c.isHasBomb() || c.isClicked()){
                cells.remove(c);
            }
        }

        int s = cells.size();
        Random r = new Random();
        int ran = r.nextInt(s);
        Cell c = cells.get(ran);
        c.setHasBomb(true);

        cells.remove(c);

        // TODO: redraw table with the new data
    }

    private void start(){

        /*
        table.getColumnModel().getColumn(0).setPreferredWidth(CELL_WIDTH);
        table.getColumnModel().getColumn(1).setPreferredWidth(CELL_WIDTH);
        table.getColumnModel().getColumn(2).setPreferredWidth(CELL_WIDTH);
        table.getColumnModel().getColumn(3).setPreferredWidth(CELL_WIDTH);
        table.getColumnModel().getColumn(4).setPreferredWidth(CELL_WIDTH);

        tm = (DefaultTableModel) table.getModel();
        tm.setNumRows(NUMBER_OF_ROWS);
*/

    }

    private void addToTable(){

    }



    /*
    public GameBoard_(){

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
